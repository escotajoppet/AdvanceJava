package buy.and.sell;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import table.data.*;
import database.connection.*;

public class BuyAndSell extends SearchResults{
	DbConnect objDbCon;
	
	ResultSet rs = null;
	Statement st = null;
	
	String sql = "";
	String message = "";
	
	String emailAddress = "";
	String memberName = "";
	
	public BuyAndSell(){
		objDbCon = new DbConnect();
	}
	
	public Connection getDbConnection(){
		return objDbCon.getConnection();
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress(){
		return this.emailAddress;
	}
	
	public void setMemberName(String emailAddress){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`sellername`", "sellersprofile", "`emailaddress`='"+emailAddress+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				System.out.println("asdasd");
				this.memberName = rs.getString("sellername");
			}
			
			System.out.println("kjlkjkl");
		} catch(Exception e){
			setMessage("error setting member " + e);
			return;
		}
	}
	
	public String getMemberName(){
		return this.memberName;
	}
	
	public void addNewEntry(String deviceModel, String description, String price){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		try{
			st = getDbConnection().createStatement();
			sql = insertIntoFields("mobilephones", "`devicemodel`, `dateposted`, `description`, `seller`, `price`", "'"+deviceModel+"', '"+dateFormat.format(date)+"', '"+description+"', '"+getEmailAddress()+"', '"+price+"'");
			st.execute(sql);
			
			setMessage("adding new entry successful");
		} catch(Exception e){
			setMessage("error adding new entry " + e);
			return;
		}
	}
	
	public void addNewEntrySeller(String sellerName, String number, String emailAddress, String fbAccount, String password, String retypePass){
		if(!password.equals(retypePass)){
			setMessage("error signing up passwords don't match");
			return;
		}
		
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`sellername`, `contactnumber`, `emailaddress`", "sellersprofile", "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				if(rs.getString("emailaddress").equals(emailAddress)){
					setMessage("error signing up: email address already in use");
					return;
				} 
			}

			sql = insertIntoFields("sellersprofile", "`sellername`, `contactnumber`, `emailaddress`, `fbaccount`, `postedrate`, `password`", "'"+sellerName+"', '"+number+"', '"+emailAddress+"', '"+fbAccount+"', 0, '"+password+"'");
			st.execute(sql);
			
			setMessage("successfully signed up");
		} catch(Exception e){
			setMessage("error adding new entry seller " + e);
			return;
		}
	}
	
	public void setSearchResults(String keyWord, String searchBy){
		String condition = "`"+searchBy+"` REGEXP '"+keyWord+"' ";
		condition = searchBy.equals("seller") ? condition + "GROUP BY(`seller`)" : condition;
		
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`entrynumber`, `devicemodel`, `dateposted`, `description`, `seller`, `price`", "mobilephones", condition);
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setEntryNumber(rs.getInt("entrynumber"));
				setDeviceModel(rs.getString("devicemodel"));
				setDatePosted(rs.getString("dateposted"));
				setDescription(rs.getString("description"));
				setSeller(rs.getString("seller"));
				setPrice(rs.getString("price"));
			}
			
		} catch(Exception e){
			setMessage("error setting search results " + e);
			return;
		}
	}
	
	public void setSellerProfile(){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`contactnumber`, `emailaddress`, `fbaccount`", "sellersprofile", "`sellername`='"+getMemberName()+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setContactNumber(rs.getString("contactnumber"));
				setEmailAddress(rs.getString("emailaddress"));
				setFbAccount(rs.getString("fbaccount"));
			}
			
			sql = selectFields("`devicemodel`, `dateposted`, `description`, `price`", "mobilephones", "`seller`='"+getEmailAddress()+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setSellerPhones(rs.getString("devicemodel"));
				setSellerDates(rs.getString("dateposted"));
				setSellerDescriptions(rs.getString("description"));
				setSellerPrices(rs.getString("price"));
			}
			
		} catch(Exception e){
			setMessage("error setting seller profile " + e);
			return;
		}
	}
	
	public boolean login(String emailAddress, String password){
		String tableName = emailAddress.equals("admin") ? "admin" : "sellersprofile";
		String fields = emailAddress.equals("admin") ? "`username`, `password`" : "`emailaddress`, `password`"; 
		String field = emailAddress.equals("admin") ? "username" : "emailaddress";
		
		try{
			st = getDbConnection().createStatement();
			sql = selectFields(fields, tableName, "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				if(rs.getString(field).equals(emailAddress)){
					if(rs.getString("password").equals(password)){
						return true;
					}
				} 
			}

			setMessage("error logging in: the information is not in the database");
			return false;
		} catch(Exception e){
			setMessage("error logging in " + e);
			return false;
		}
	}
	
	public void deletePost(String type, String fieldValue){
		String field = type.equals("admin") ? "entrynumber" : "dateposted";
		
		try{
			st = getDbConnection().createStatement();
			sql = deleteFromField("mobilephones", field, fieldValue);
			st.execute(sql);
			
		} catch(Exception e){
			setMessage("error deleting post " + e);
			return;
		}
	}
	
	public void updateProfile(String contactNumber, String fbAccount){
		try{
			st = getDbConnection().createStatement();
			sql = updateFields("sellersprofile", "`contactnumber`='"+contactNumber+"', `fbaccount`='"+fbAccount+"'", "`emailaddress`='"+getEmailAddress()+"'");
			st.execute(sql);
			
		} catch(Exception e){
			setMessage("error updating profile" + e);
			return;
		}
	}
	
	public void itemSold(String deviceModel, String description, String datePosted, String price){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		try{
			st = getDbConnection().createStatement();
			
			sql = insertIntoFields("solditems", "`devicemodel`, `description`, `price`, `datesold`, `seller`", "'"+deviceModel+"', '"+description+"', '"+price+"', '"+df.format(date)+"', '"+getEmailAddress()+"'");
			st.execute(sql);
			
			sql = deleteFromField("mobilephones", "dateposted", datePosted);
			st.execute(sql);
			
		} catch(Exception e){
			setMessage("error selling item" + e);
			return;
		}
	}
	
	public void setSoldItems(){
		try{
			st = getDbConnection().createStatement();			
			sql = selectFields("*", "solditems", "`seller`='"+getEmailAddress()+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setSoldEntryNumber(rs.getInt("entrynumber"));
				setSoldDeviceModel(rs.getString("devicemodel"));
				setSoldDate(rs.getString("datesold"));
				setSoldDescription(rs.getString("description"));
				setSoldPrice(rs.getString("price"));
			}
		} catch(Exception e){
			setMessage("error setting sold items " + e);
			return;
		}
	}
	
	public void setAdminView(){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("*", "mobilephones", "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setEntryNumber(rs.getInt("entrynumber"));
				setDeviceModel(rs.getString("devicemodel"));
				setDatePosted(rs.getString("dateposted"));
				setDescription(rs.getString("description"));
				setSeller(rs.getString("seller"));
				setPrice(rs.getString("price"));
			}
			
		} catch(Exception e){
			setMessage("error setting admin view " + e);
			return;
		}
	}
}