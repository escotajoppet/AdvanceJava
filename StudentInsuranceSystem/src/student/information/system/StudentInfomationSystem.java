package student.information.system;

import database.connection.*;
import java.util.Date;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class StudentInfomationSystem extends SQLStringQueries{
	ConnectToDb obj = new ConnectToDb();
	Statement st = null;
	ResultSet rs = null;
	
	String message = "";
	String query = "";
	String accountNumber = "";
	String tableName = "";
	String adminUsername = "";
	
	String transaction = "";
	
	int transactionAccountNumber = 0;
	
	public Connection getConnection(){
		return obj.getConnection();
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void setTransactionCommited(String transaction){
		this.transaction = transaction;
	}
	
	public String getTransactionCommited(){
		return this.transaction;
	}
	
	public void setTransactionAccountNumber(int transactionAccountNumber){
		this.transactionAccountNumber = transactionAccountNumber;
	}
	
	public int getTransactionAccountNumber(){
		return this.transactionAccountNumber;
	}
	
	public void addNewSIS(String firstName, String lastName, String address, String contact, String insuranceType, String startingDate, String expirationDate){
		
		try{
			st = getConnection().createStatement();
			
			query = selectFields("`first_name`, `last_name`", insuranceType, "1");
			rs = st.executeQuery(query);
			
			while(rs.next()){
				if(rs.getString("first_name").equals(firstName)){
					if(rs.getString("last_name").equals(lastName)){
						setMessage("error adding new member, member already exists");
						return;
					}
				}
			}
			
			query = insertIntoFields(insuranceType, "`first_name`, `last_name`, `address`, `contact_number`, `starting_date`, `expiration_date`", "'"+firstName+"', '"+lastName+"', '"+address+"', '"+contact+"', '"+startingDate+"', '"+expirationDate+"'");
			st.execute(query);
			
			setMessage("adding successful");
		} catch(Exception e){
			setMessage("error adding " + e);
			return;
		}
	}
	
	public int getNewAccountNumber(String tableName){
		try{
			st = getConnection().createStatement();
			query = selectFields("`account_number`", tableName, "1");
			rs = st.executeQuery(query);
			
			while(rs.next()){
				if(rs.last()){
					return rs.getInt("account_number");
				}
			}
			
			return 0;
		} catch(Exception e){
			setMessage("error setting account number");
			return 0;
		}
	}
	
	public void deleteAccount(String tableName){
		try{
			st = getConnection().createStatement();
			query = deleteFromField(tableName, "account_number", Integer.toString(getTransactionAccountNumber()));
			st.execute(query);
			
			addNewTransaction();
			
			setMessage("successfully deleted " + Integer.toString(getTransactionAccountNumber()));
		} catch(Exception e){
			setMessage("error deleting account " + e);
			return;
		}
	}
	
	public void viewAllMembers(String tableName, String accountNumber){
		accountNumber = accountNumber.equals("all") ? "1" : "`account_number`="+accountNumber+"";
		
		try{
			st = getConnection().createStatement();
			
			if(tableName.equals("")){
				String[] tables = {"carinsurance", "healthinsurance", "lifeinsurance", "travelinsurance"};
				String insuranceTypeDisplay = "";
				
				for(int i = 0; i<tables.length; i++){
					query = selectFields("*", tables[i], accountNumber);
					rs = st.executeQuery(query);
					
					switch(tables[i]){
						case "carinsurance":
							insuranceTypeDisplay = "Car Insurance";
							break;
						case "healthinsurance":
							insuranceTypeDisplay = "Health Insurance";
							break;
						case "lifeinsurance":
							insuranceTypeDisplay = "Life Insurance";
							break;
						case "travelinsurance":
							insuranceTypeDisplay = "Travel Insurance";
							break;
					}
					
					while(rs.next()){
						setAccountNumber(rs.getInt("account_number"));
						setName(rs.getString("last_name") + ", " + rs.getString("first_name"));
						setStartingDate(rs.getString("starting_date"));
						setExpirationDate(rs.getString("expiration_date"));
						setInsuranceType(insuranceTypeDisplay);
					}					
				}
			} else{
				query = selectFields("*", tableName, accountNumber);
				rs = st.executeQuery(query);
				
				while(rs.next()){
					setAccountNumber(rs.getInt("account_number"));
					setName(rs.getString("last_name") + ", " + rs.getString("first_name"));
					setStartingDate(rs.getString("starting_date"));
					setExpirationDate(rs.getString("expiration_date"));
				}
				
				addNewTransaction();
			}
		} catch(Exception e){
			setMessage("error viewing all members " + e);
			return;
		}
	}
	
	public void setUpdateAccountNumber(String accountNumber){
		this.accountNumber = accountNumber;
		try{
			st = getConnection().createStatement();
			query = selectFields("`first_name`, `last_name`, `address`, `contact_number`", getTableName(), "`account_number`="+accountNumber);
			rs = st.executeQuery(query);
			
			while(rs.next()){
				setUpdateFirstName(rs.getString("first_name"));
				setUpdateLastName(rs.getString("last_name"));
				setUpdateAddress(rs.getString("address"));
				setUpdateContact(rs.getString("contact_number"));
			}
			
		} catch(Exception e){
			setMessage("error updating account " + e);
			return;
		}
	}
	
	public String getUpdateAccountNumber(){
		return this.accountNumber;
	}
	
	public void updateAccountInfo(String firstName, String lastName, String address, String contact, String insuranceType){
		
		try{
			st = getConnection().createStatement();
			query = updateFields(getTableName(), "`first_name`='"+firstName+"', `last_name`='"+lastName+"', `address`='"+address+"', `contact_number`='"+contact+"'", "`account_number`='"+getUpdateAccountNumber()+"'");
			st.execute(query);
			
			addNewTransaction();
			
			setMessage("user " + getUpdateAccountNumber() + " successfully updated");
		} catch(Exception e){
			setMessage("error updating account info " + e);
			return;
		}
	}
	
	public void setTableName(String tableName){
		this.tableName = tableName;
	}
	
	public String getTableName(){
		return this.tableName;
	}
	
	public boolean login(String username, String password){
		try{
			st = getConnection().createStatement();
			query = selectFields("`username`, `password`", "adminuser" , "1");
			rs = st.executeQuery(query);
			
			while(rs.next()){
				if(rs.getString("username").equals(username)){
					if(rs.getString("password").equals(password)){
						return true;
					}
				}
			}
			
			setMessage("error logging in the information is not in the database");
			return false;
		} catch(Exception e){
			setMessage("error logging in " + e);
			return false;
		}
	}
	
	public void setAdminUsername(String adminUsername){
		this.adminUsername = adminUsername;
	}
	
	public String getAdminUsername(){
		return this.adminUsername;
	}
	
	
	public void signUp(String adminUsername, String password, String retypePass){
		if(!password.equals(retypePass)){
			setMessage("error signing up passwords don't match");
			return;
		}
		
		try{
			st = getConnection().createStatement();
			query = insertIntoFields("adminuser", "`username`, `password`", "'"+adminUsername+"', '"+password+"'");
			st.execute(query);
			
			setMessage("admin successfully signed up");
		} catch(Exception e){
			setMessage("error sign up " + e);
			return;
		}
	}
	
	public void setAllTransactions(){
		try{
			st = getConnection().createStatement();
			query = selectFields("*", "transaction", "1");
			rs = st.executeQuery(query);
			
			while(rs.next()){
				setTransactionDate(rs.getString("transactiondate"));
				setTransactionAdmin(rs.getString("username"));
				setTransactionAction(rs.getString("transactioncommitted"));
				setTransactionAccount(rs.getInt("accountnumber"));
			}
			
		} catch(Exception e){
			setMessage("error setting transaction " + e);
			return;
		}
	}
	
	public void addNewTransaction(){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String newDate = df.format(date);
		
		try{
			st = getConnection().createStatement();
			
			query = insertIntoFields("transaction", "`transactiondate`, `username`, `transactioncommitted`, `accountnumber`",  "'"+newDate+"', '"+getAdminUsername()+"', '"+getTransactionCommited()+"', '"+getTransactionAccountNumber()+"'");
			st.execute(query);
			
		} catch(Exception e){
			setMessage("error adding transaction " + e);
			return;
		}
	}
}