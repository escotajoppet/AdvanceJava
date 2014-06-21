package loan.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import sql.string.commands.SqlStringCommands;
import database.connect.DbConnect;

public class LoanSystem extends SqlStringCommands{
	DbConnect obj = new DbConnect();
	
	Statement st = null;
	ResultSet rs = null;

	String sql = "";
	String message = "";
	String username = "";
	
	public Connection getDbConnection(){
		return obj.getConnection();
	}
	
	public boolean logIn(String username, String password){

		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`username`, `password`",  "admin", "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				if(username.equals(rs.getString("username"))){
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
	
	public void registerUser(String firstName, String lastName, String gender, String age, String address, String emailAddress, String mobileNumber,  String username){		
		try{
			st = getDbConnection().createStatement();
			sql = insertIntoFields("customers", "`first_name`, `last_name`, `gender`, `age`, `address`, `email_address`, `contact`, `username`", "'"+firstName+"', '"+lastName+"', '"+gender+"', '"+age+"', '"+address+"', '"+emailAddress+"', '"+mobileNumber+"', '"+username+"'");
			st.execute(sql);
			
			setMessage("successfully registered");
		} catch(Exception e){
			setMessage("error registering new user " + e);
			return;
		}
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void getLoan(String loanAmount){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		double amount = Double.parseDouble(loanAmount);
		double interest = 0.3;
		double principalAmount = amount + (amount * interest);
		
		try{
			st = getDbConnection().createStatement();
			sql = insertIntoFields("loans", "`transaction_date`, `username`, `loan_amount`, `loan_interest`, `principal_amount`", "'"+df.format(date)+"', '"+getUsername()+"', "+amount+", '3%'," + principalAmount); 
			st.execute(sql);
			
			getDbConnection().close();
			
			st = getDbConnection().createStatement();
			sql = insertIntoFields("balances", "`balance_as_of`, `username`, `loan_interest`, `loan_amount`, `principal_amount`, `payment_amount`, `remaining_balance`", "'"+df.format(date)+"', '"+getUsername()+"', '3%', "+amount+", "+principalAmount+", 0, " + principalAmount);
			st.execute(sql);
			
			getDbConnection().close();
			
			setMessage("get loan success");
		} catch(Exception e){
			setMessage("error loan " + e);
			return;
		}
	}
	
	public void getPayment(String paymentAmount){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		double amount = Double.parseDouble(paymentAmount);
		double newRemaining = 0;
		double principalValue = 0;
		double loanAmount = 0;
		
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`principal_amount`, `loan_amount`, `remaining_balance`", "balances", "`username`='"+getUsername()+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				if(rs.last()){
					principalValue = rs.getDouble("principal_amount");
					newRemaining = rs.getDouble("remaining_balance") - amount;
					loanAmount = rs.getDouble("loan_amount");
				}
			}
			
			sql = insertIntoFields("payments", "`transaction_date`, `username`, `payment_amount`", "'"+df.format(date)+"', '"+getUsername()+"', "+paymentAmount+"");
			st.execute(sql);
			
			sql = insertIntoFields("balances", "`balance_as_of`, `username`, `loan_interest`, `loan_amount`, `principal_amount`, `payment_amount`, `remaining_balance`", "'"+df.format(date)+"', '"+getUsername()+"', '3%', "+loanAmount+", "+principalValue+", "+paymentAmount+", " + newRemaining);
			st.execute(sql);
			
			setMessage("success paying");
		} catch(Exception e){
			setMessage("error paying " + e);
			return;
		}
	}
	
	public void setBalance(){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`balance_as_of`, `loan_amount`, `loan_interest`, `principal_amount`, `payment_amount`, `remaining_balance`", "balances", "`username`='"+getUsername()+"'");
			rs = st.executeQuery(sql);		
					
			while(rs.next()){
				setPayments(rs.getDouble("payment_amount"));
				setRemainingBalance(rs.getDouble("remaining_balance"));
				setTransactionDates(rs.getString("balance_as_of"));
				setTotalAmount(rs.getDouble("principal_amount"));
				setLoanAmount(rs.getDouble("loan_amount"));
				setLoanInterest(rs.getString("loan_interest"));
			}
			
		} catch(Exception e){
			setMessage("error setting balance " + e);
			return;
		}
	}
	
	public double getRB(){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`remaining_balance`", "balances", "`username`='"+getUsername()+"'");
			rs = st.executeQuery(sql);		
			
			while(rs.next()){
				if(rs.last()){
					return rs.getDouble("remaining_balance");
				}
			}
			
			return 0;
		} catch(Exception e){
			setMessage("error setting balance " + e);
			return 0;
		}
	}
}
