package online.pet.shop;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import table.data.CategoryList;
import database.connection.DbConnect;

public class OnlinePetShop extends CategoryList{
	
	ArrayList<String> categories = new ArrayList<String>();
	
	DbConnect objDbCon;
	Statement st = null;
	ResultSet rs = null;
	
	String sqlQuery = "";
	String from = "";
	String as = "";
	
	public OnlinePetShop(){
		objDbCon = new DbConnect();
	}
	
	public Connection getDbConnection(){
		return objDbCon.getConnection();
	}
	
	public void setLoggedAs(String as){
		this.as = as;
	}
	
	public String getLoggedAs(){
		return this.as;
	}
	
	public void setCategoryList(){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "SELECT `category` FROM `petcategory`";
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				setCategory(rs.getString("category"));
			}
			
			setQuantity();
		} catch(Exception e){
			System.out.println("error setting category list " + e);
			return;
		}
	}
	
	public void setQuantity(){
		int count = 0;
		this.categories = getCategory();
		
		try{
			st = getDbConnection().createStatement();
			for(int i = 0; i<this.categories.size(); i++){
				count = 0;
				
				sqlQuery = "SELECT DISTINCT `breed` FROM `"+getCategory().get(i)+"_category`";
				rs = st.executeQuery(sqlQuery);
				
				while(rs.next()){
					count++;
				}
				
				setQuantities(count);
			}
			
		} catch(Exception e){
			System.out.println("error setting quantity " + e);
			return;
		}
	}
	
	public void addCategory(String category){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "INSERT INTO `petcategory` (`category`, `breedquantity`) VALUES('"+category.substring(0, 1).toUpperCase() + category.substring(1)+"', 0)";
			st.execute(sqlQuery);
			
			createNewTableCategory(category);
			
		} catch(Exception e){
			System.out.println("error adding category " + e);
			return;
		}
	}
	
	public void createNewTableCategory(String category){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "CREATE TABLE IF NOT EXISTS `"+category+"_category` (`entryid` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ "`breed` VARCHAR(30), `price` VARCHAR(30))";
			
			st.execute(sqlQuery);
			
		} catch(Exception e){
			System.out.println("error creating new table category " + e);
			return;
		}
	}
	
	public void setSelectedCategoryBreeds(){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "SELECT `entryid`, `breed`, `price` FROM `"+getSelectedCategory()+"_category`";
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				setEntryId(rs.getInt("entryid"));
				setCategoryBreeds(rs.getString("breed"));
				setBreedPrices(rs.getString("price"));
			}
			
		} catch(Exception e){
			System.out.println("error setting selected category breeds " + e);
			return;
		}
	}
	
	public void removeSelectedCategory(){
		try{			
			st = getDbConnection().createStatement();
			sqlQuery = "DELETE FROM `petcategory` WHERE `category`='"+getSelectedCategory()+"'";
			st.execute(sqlQuery);
			
			removeTableCategory();
			
		} catch(Exception e){
			System.out.println("error removing selected category " + e);
			return;
		}
	}
	
	public void removeTableCategory(){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "DROP TABLE `"+getSelectedCategory()+"_category`";
			st.execute(sqlQuery);
			
		} catch(Exception e){
			System.out.println("error dropping table " + e);
			return;
		}
	}
	
	public void addNewEntry(String newEntry, String price){
		newEntry = newEntry.trim().substring(0, 1) + newEntry.substring(1);
		price = price.trim();
		
		if(newEntry.equals("") || price.equals("")){
			System.out.println("indicate the information of new entry");
			return;
		}
		
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "INSERT INTO `"+getSelectedCategory()+"_category` (`breed`, `price`) VALUES('"+newEntry+"', '"+price+"')";
			st.execute(sqlQuery);
			
		} catch(Exception e){
			System.out.println("error adding new entry " + e);
			return;
		}
	}
	
	public void removeEntry(String entry){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "DELETE FROM `"+getSelectedCategory()+"_category` WHERE `entryid`='"+Integer.parseInt(entry)+"'";
			st.execute(sqlQuery);
			
		} catch(Exception e){
			System.out.println("error removing entry " + e);
			return;
		}
	}
	
	public void setReservation1(String entryId, int quantity){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "SELECT `breed`, `price` FROM `"+getSelectedCategory()+"_category` WHERE `entryid`='"+entryId+"'";
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				setReservedEntryId(Integer.parseInt(entryId));
				setQuantity(quantity);
				setBreedName(rs.getString("breed"));
				setTotalPrice(Double.parseDouble(rs.getString("price")) * quantity);;
			}
			
		} catch(Exception e){
			System.out.println("error setting reservation " + e);
			return;
		}
	}
	
	public void setReservation2(String fullName, String address, String contactNumber){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();

		setDate(dateFormat.format(date));
		setName(fullName);
		setAddress(address);
		setContactNumber(contactNumber);
		setReservedOrder(getQuantity() + " " + (getFrom().equals("petitems") ? getItemName() : getBreedName()) + ", with a total of " + getTotalPrice());
	}
	
	public void setReservation3(String itemName, int quantity){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "SELECT `petitem`, `priceperitem` FROM `petitems` WHERE `petitem`='"+itemName+"'";
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				setItemName(itemName);
				setQuantity(quantity);
				setTotalPrice(Double.parseDouble(rs.getString("priceperitem")) * quantity);;
			}
			
		} catch(Exception e){
			System.out.println("error setting reservation " + e);
			return;
		}
	}
	
	public void addReservation(){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "INSERT INTO `reservation` (`transactiondate`, `name`, `address`, `contactno`, `reservedorder`) VALUES('"+getDate()+"', '"+getName()+"', '"+getAddress()+"', '"+getContactNumber()+"', '"+getReservedOrder()+"')";
			st.execute(sqlQuery);
			
		} catch(Exception e){
			System.out.println("error adding reservation " + e);
			return;
		}
	}
	
	public void setFrom(String from){
		this.from = from;
	}
	
	public String getFrom(){
		return this.from;
	}
	
	
	
	public void setReservationTable(){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "SELECT `transactiondate`, `name`, `address`, `contactno`, `reservedorder` FROM `reservation`";
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				setTransactionDate(rs.getString("transactiondate"));
				setReservedName(rs.getString("name"));
				setReservedAddress(rs.getString("address"));
				setReservedContactNumber(rs.getString("contactno"));
				setOrder(rs.getString("reservedorder"));
			}
			
		} catch(Exception e){
			System.out.println("error setting reservation table " + e);
			return;
		}
	}
	
	public void setItemList(){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "SELECT `petitem`, `priceperitem` FROM `petitems`";
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				setPetItems(rs.getString("petitem"));
				setPricePerItem(rs.getString("priceperitem"));
			}
			
		} catch(Exception e){
			System.out.println("error setting item list " + e);
			return;
		}
	}
	
	public void addNewItem(String newItem, String price){
		newItem = newItem.trim().substring(0, 1) + newItem.substring(1);
		price = price.trim();
		
		if(newItem.equals("") || price.equals("")){
			System.out.println("indicate the information of new entry");
			return;
		}
		
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "INSERT INTO `petitems` (`petitem`, `priceperitem`) VALUES('"+newItem+"', '"+price+"')";
			st.execute(sqlQuery);
			
		} catch(Exception e){
			System.out.println("error adding new item " + e);
			return;
		}
	}
	
	public void removeItems(String item){
		try{
			st = getDbConnection().createStatement();
			
			sqlQuery = "DELETE FROM `petitems` WHERE `petitem`='"+item+"'";
			st.execute(sqlQuery);		
			
		} catch(Exception e){
			System.out.println("error removing entry " + e);
			return;
		}
	}
	
	public boolean logIn(String username, String password){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = "SELECT `username`, `password` FROM `admin`";
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				if(username.equals(rs.getString("username"))){
					if(password.equals(rs.getString("password"))){
						return true;
					}
				}
			}
			
			System.out.println("error logging in: the information is not on the database");
			return false;
		} catch(Exception e){
			System.out.println("error logging in " + e);
			return false;
		}
	}
}
