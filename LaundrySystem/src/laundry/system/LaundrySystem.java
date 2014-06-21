package laundry.system;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import sql.string.commands.SqlStringCommands;
import transaction.information.TransactionSummary;
import database.connection.*;

public class LaundrySystem extends TransactionSummary{
	DatabaseConnection objDbCon;
	
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	
	String sqlQuery = "";
	String message = "";
	
	public LaundrySystem(){
		objDbCon = new DatabaseConnection();
	}
	
	public Connection getConnection(){
		return objDbCon.connectToDb();
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void registerNewMember(String lastName, String firstName, String address, String contactNo, String emailAdd, String password, String confirmPassword){
		lastName = lastName.trim();
		firstName = firstName.trim();
		address = address.trim();
		contactNo = contactNo.trim();
		emailAdd = emailAdd.trim();
		password = password.trim();
		confirmPassword = confirmPassword.trim();
		
		if(lastName.equals("") || firstName.equals("")){
			setMessage("enter your complete name");
			return;
		} else if(address.equals("") || contactNo.equals("") || emailAdd.equals("")){
			setMessage("enter your complete contact details");
			return;
		} else if(password.equals("") || confirmPassword.equals("")){
			setMessage("enter your password");
			return;
		} else if(!password.equals(confirmPassword)){
			setMessage("passwords don't match");
			return;
		}
		
		try{
			sqlQuery = insertIntoFields("members", "`lastname`, `firstname`, `address`, `contactno`, `emailadd`, `password`", "?, ?, ?, ?, ?, ?");
			ps = getConnection().prepareStatement(sqlQuery);
			ps.setString(1, lastName);
			ps.setString(2, firstName);
			ps.setString(3, address);
			ps.setString(4, contactNo);
			ps.setString(5, emailAdd);
			ps.setString(6, password);
			
			ps.execute();
			
			setMessage("registration successful");
		} catch(Exception e){
			setMessage("error registering new member " + e);
			return;
		}
	}
	
	public boolean logInMember(String email, String password, String LoggedAs){
		try{
			st = getConnection().createStatement();
			sqlQuery = selectFields("`emailadd`, `password`", LoggedAs, "1");
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				if(email.equals(rs.getString("emailadd"))){
					if(password.equals(rs.getString("password"))){
						return true;
					}
				}
			}
			
			setMessage("error logging in: the information is not on the database");
			return false;
		} catch(Exception e){
			setMessage("error logging in " + e);
			return false;
		}
	}
	
	public void setTransactionConfirmation(String countTShirt, String countShort, String countPants, String countUnderwear, String countOthers, String countKilo, String typeOfWash, String modeOfPayment, String typeOfService){
		int totalNumberOfClothes = 0;
		double totalAmount = 0;
		double kiloCount = 0;
		
		double pricePerShirt = 10;
		double pricePerShort = 10;
		double pricePerPants = 20;
		double pricePerUnderwear = 5;
		double pricePerOther = 15;
		
		countTShirt = countTShirt.equals("") ? "0" : countTShirt;
		countShort = countShort.equals("") ? "0" : countShort;
		countPants = countPants.equals("") ? "0" : countPants;
		countUnderwear = countUnderwear.equals("") ? "0" : countUnderwear;
		countOthers = countOthers.equals("") ? "0" : countOthers;
		countKilo = countKilo.equals("") ? "0.0" : countKilo;
		
		if(typeOfWash.equals("")){
			setMessage("indicate the type of wash");
			return;
		} else if(modeOfPayment.equals("")){
			setMessage("indicate the mode of payment");
			return;			
		} else if(typeOfService.equals("")){
			setMessage("indicate the type of service");
			return;			
		}
		
		try{
			totalNumberOfClothes = Integer.parseInt(countTShirt) + 
					Integer.parseInt(countShort) + 
					Integer.parseInt(countPants) + 
					Integer.parseInt(countUnderwear) + 
					Integer.parseInt(countOthers);
			
			totalAmount = (Integer.parseInt(countTShirt) * pricePerShirt) +
					(Integer.parseInt(countShort) * pricePerShort) + 
					(Integer.parseInt(countPants) * pricePerPants) +
					(Integer.parseInt(countUnderwear) * pricePerUnderwear) + 
					(Integer.parseInt(countOthers) * pricePerOther);
			
			kiloCount = Double.parseDouble(countKilo);
			
			setTotalNumberOfClothes(totalNumberOfClothes);
			setKiloCount(kiloCount);
			setTypeOfService(typeOfService);
			setTypeOfWash(typeOfWash);
			setModeOfPayment(modeOfPayment);
			setAmount(totalAmount);
			
		} catch(Exception e){
			setMessage("error setting tracsaction confirmation " + e);
			return;
		}
	}
	
	public void cancelTransaction(){
		setTotalNumberOfClothes(0);
		setTypeOfService("");
		setTypeOfWash("");
		setModeOfPayment("");
		setKiloCount(0);
	}
	
	public void confirmTransaction(){		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		try{
			st = getConnection().createStatement();

			
			sqlQuery =	insertIntoFields("latesttransaction", "`emailadd`, `transaction_date`, `numberofclothes`, `kilocount`, `amount`, `typeofwash`, `modeofpayment`, `typeofservice`, `status`", "'"+getUserEmailAdd()+"', '"+dateFormat.format(date)+"', '"+getTotalNumberOfClothes()+"', '"+getKiloCount()+"', '"+getAmount()+"', '"+getTypeOfWash()+"', '"+getModeOfPayment()+"', '"+getTypeOfService()+"', 'Transaction On Process'");
			st.execute(sqlQuery);

			setMessage("transaction successfull");
		} catch(Exception e){
			setMessage("error confirmation of transaction " + e);
			return;
		}
	}
	
	public void setRecentTransaction(String condition){
		try{
			st = getConnection().createStatement();
			sqlQuery = selectFields("`emailadd`, `transaction_date`, `numberofclothes`, `kilocount`, `amount`, `typeofwash`, `modeofpayment`, `typeofservice`, `status`", "latesttransaction", condition);
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				setRecentDate(rs.getString("transaction_date"));
				setRecentEmail(rs.getString("emailadd"));
				setRecentTotalNumberOfClothes(rs.getInt("numberofclothes"));
				setRecentKilo(rs.getDouble("kilocount"));
				setRecentAmount(rs.getDouble("amount"));
				setRecentTypeOfWash(rs.getString("typeofwash"));
				setRecentModeOfPayment(rs.getString("modeofpayment"));
				setRecentTypeOfService(rs.getString("typeofservice"));
				setRecentStatus(rs.getString("status"));
			}
			
		} catch(Exception e){
			setMessage("error setting recent transaction " + e);
			return;
		}
	}
	
	public void removeTransaction(String date){
		try{
			st = getConnection().createStatement();
			sqlQuery = deleteFromField("latesttransaction", "transaction_date", date);
			st.execute(sqlQuery);
			
		} catch(Exception e){
			setMessage("error removing transaction " + e);
			return;
		}		
	}
	
	public void updateStatus(String[] status){
		try{
			st = getConnection().createStatement();
			for(int i = 0; i<status.length; i++){
				sqlQuery = updateField("latesttransaction", "status", status[i], "`transaction_date`='"+getRecentDate().get(i)+"'");
				st.execute(sqlQuery);
			}
			
		} catch(Exception e){
			setMessage("error updating status " + e);
			return;
		}
	}
}
