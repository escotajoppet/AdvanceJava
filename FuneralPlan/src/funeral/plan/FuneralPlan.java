package funeral.plan;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import sql.string.commands.SqlStringCommands;
import database.connect.*;

public class FuneralPlan extends SqlStringCommands{
	DbConnect obj = new DbConnect();
	
	Statement st = null;
	ResultSet rs = null;
	
	String username = "";
	String message = "";
	String sql = "";
	String plan = "";
	String selectedPlanType = "";
	String name = "";
	String planType = "";
	
	public Connection getDbConnection(){
		return obj.getConnection();
	}
	
	public void setUser(String emailAdd){
		this.username = emailAdd;
	}
	
	public String getUser(){
		return this.username;
	}
	
	public void setPlans(){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`plans`, `description`", "plans", "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setPlans(rs.getString("plans"));
				setDescription(rs.getString("description"));
			}
			
		} catch(Exception e){
			setMessage("error setting plans " + e);
			return;
		}
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public boolean logIn(String emailAdd, String password, String tableName){

		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`username`, `password`",  tableName, "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				if(emailAdd.equals(rs.getString("username"))){
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
	
	public void registerUser(String fullName, String address, String mobileNumber, String emailAddress, String birthDate, String gender, String civilStatus, String username, String password, String retypePassword){
		if(!password.equals(retypePassword)){
			setMessage("passwords dont match");
			return;
		}
		
		try{
			st = getDbConnection().createStatement();
			sql = insertIntoFields("customers", "`customer_name`, `address`, `contact_number`, `email_address`, `birth_date`, `gender`, `civil_status`, `username`, `password`", "'"+fullName+"', '"+address+"', '"+mobileNumber+"', '"+emailAddress+"', '"+birthDate+"', '"+gender+"', '"+civilStatus+"', '"+username+"', '"+password+"'");
			st.execute(sql);
			
			setMessage("successfully registered");
		} catch(Exception e){
			setMessage("error registering new user " + e);
			return;
		}
	}
	
	public void setPlan(String plan){
		this.plan = plan;
	}
	
	public String getPlan(){
		return this.plan;
	}
	
	public void setSelectedPlanType(String plan){
		this.selectedPlanType = plan;
	}
	
	public String getSelectedPlanType(){
		return this.selectedPlanType;
	}
	
	public void setSelectedPlan(){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`plan_type`, `description`, `contract_price`, `annual`, `semi_annual`, `quarterly`, `monthly`",  getPlan(), "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setPlanTypes(rs.getString("plan_type"));
				setDescriptions(rs.getString("description"));
				setContractPrices(rs.getDouble("contract_price"));
				setAnnuals(rs.getDouble("annual"));
				setSemiAnnuals(rs.getDouble("semi_annual"));
				setQuarterlys(rs.getDouble("quarterly"));
				setMonthlys(rs.getDouble("monthly"));
			}
		} catch(Exception e){
			setMessage("error setting selected plan " + e);
			return;
		}
	}
	
	public void submitSelectedPlan(String planType, String paymentType){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`plan_type`, `description`, `"+paymentType+"`", getPlan(), "`plan_type`='"+planType+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setSubmittedPlanType(rs.getString("plan_type"));
				setSubmittedDescription(rs.getString("description"));
				setSubmittedPaymentType(paymentType);
				setSubmittedPrice(rs.getDouble(paymentType));
			}
			
		} catch(Exception e){
			setMessage("error submitting selected plan");
			return;
		}
	}
	
	public void setName(String username){
		if(username.equals("admin")){
			this.name = "admin";
			return;
		}
		
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`customer_name`", "customers", "`username`='"+username+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				this.name = rs.getString("customer_name");
			}
			
		} catch(Exception e){
			setMessage("error setting name " + e);
			return;
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addToTransactionLog(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		try{
			st = getDbConnection().createStatement();
			sql = insertIntoFields("transactionlogs", "`transaction_date`, `name`, `plan_type`, `description`, `payment_type`, `payment_amount`",  "'"+dateFormat.format(date)+"', '"+getName()+"', '"+getSubmittedPlanType()+"', '"+getSubmittedDescription()+"', '"+getSubmittedPaymentType()+"', "+getSubmittedPrice()+"");
			st.execute(sql);
			
		} catch(Exception e){
			setMessage("error adding to transaction logs " + e);
			return;
		}
	}
	
	public void setCustomersView(){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("*", "customers", "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setCustomerName(rs.getString("customer_name"));
				setCustomerAddress(rs.getString("address"));
				setCustomerContact(rs.getString("contact_number"));
				setCustomerEmailAdd(rs.getString("email_address"));
				setCustomerBday(rs.getString("birth_date"));
				setCustomerGender(rs.getString("gender"));
				setCustomerCivilStatus(rs.getString("civil_status"));
				setCustomerUsername(rs.getString("username"));
				setCustomerPassword(rs.getString("password"));
			}
			
		} catch(Exception e){
			setMessage("error setting vustomers view " + e);
			return;
		}
	}
	
	public void removePlanType(String planType){
		try{
			st = getDbConnection().createStatement();
			sql = deleteFromField(getPlan(), "plan_type", planType);
			st.execute(sql);
			
		} catch(Exception e){
			setMessage("error removing plan type " + e);
			return;
		}
	}
	
	public void setPlanType(String planType){
		this.planType = planType;
	}
	
	public String getPlanType(){
		return this.planType;
	}
	
	public void setUpdateFields(){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`plan_type`, `description`, `contract_price`, `annual`, `semi_annual`, `quarterly`, `monthly`",  getPlan(), "`plan_type`='"+getPlanType()+"'");
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setPlanTypes(rs.getString("plan_type"));
				setDescriptions(rs.getString("description"));
				setContractPrices(rs.getDouble("contract_price"));
				setAnnuals(rs.getDouble("annual"));
				setSemiAnnuals(rs.getDouble("semi_annual"));
				setQuarterlys(rs.getDouble("quarterly"));
				setMonthlys(rs.getDouble("monthly"));
			}
		} catch(Exception e){
			setMessage("error setting update fields " + e);
			return;
		}
	}
	
	public void updatePlanTypes(String planType, String description, String contractPrice, String annual, String semiAnnual, String quarterly, String monthly){
		double cp = Double.parseDouble(contractPrice);
		double a = Double.parseDouble(annual);
		double sa = Double.parseDouble(semiAnnual);
		double q = Double.parseDouble(quarterly);
		double m = Double.parseDouble(monthly);
		
		try{
			st = getDbConnection().createStatement();
			sql = updateFields(getPlan(), "`plan_type`='"+planType+"', `description`='"+description+"', `contract_price`="+cp+", `annual`="+a+", `semi_annual`="+sa+", `quarterly`="+q+", `monthly`="+m+"", "`plan_type`='"+getPlanType()+"'");
			st.execute(sql);
			
		} catch(Exception e){
			setMessage("error updating plan types " + e);
			return;
		}
	}
	
	public void addNewPlanType(String planType, String description, String contractPrice, String annual, String semiAnnual, String quarterly, String monthly){
		double cp = Double.parseDouble(contractPrice);
		double a = Double.parseDouble(annual);
		double sa = Double.parseDouble(semiAnnual);
		double q = Double.parseDouble(quarterly);
		double m = Double.parseDouble(monthly);
		
		try{
			st = getDbConnection().createStatement();
			sql = insertIntoFields(getPlan(), "`plan_type`, `description`, `contract_price`, `annual`, `semi_annual`, `quarterly`, `monthly`", "'"+planType+"', '"+description+"', "+cp+", "+a+", "+sa+", "+q+", "+m+"");
			st.execute(sql);
		
		} catch(Exception e){
			setMessage("error adding new plan type " + e);
			return;
		}
	}
}
