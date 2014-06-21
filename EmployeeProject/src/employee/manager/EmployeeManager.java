package employee.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeManager {
	
	Connection dbCon = null;
	Statement st = null;
	ResultSet rs = null;
	
	String idNumber = "";
	String name = "";
	String address = "";
	String mobile = "";
	
	String query = "";
	
	public EmployeeManager(){		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "password");
			dbCon.setAutoCommit(false);
			System.out.println("Connecting to Database Established!");
		} catch(Exception e){
			System.out.println("Connecting to Database Failed! " + e);
		}
	}
	
	public void setFields(String idNumber){
		if(idNumber.equals("")){
			this.name = "";
			this.address = "";
			this.mobile = "";
		}
		
		try{
			st = dbCon.createStatement();
			query = "SELECT `employee_name`, `employee_address`, `employee_contact` FROM `employee_info` WHERE `employee_id`='"+idNumber+"'";
			rs = st.executeQuery(query);
			
			while(rs.next()){
				this.name = rs.getString("employee_name");
				this.address = rs.getString("employee_address");
				this.mobile = rs.getString("employee_contact");
			}
			
		} catch(Exception e){
			System.out.println("Error! " + e);
		}
	}
	
	public void setIdNumber(String idno){
		this.idNumber = idno;
	}
	
	public String getIdNumber(){
		return this.idNumber;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getMobile(){
		return this.mobile;
	}
	
	public void addEmployee(String idNumber, String name, String address, String number){
		try{
			st = dbCon.createStatement();
			query = "INSERT INTO `employee_info` (`employee_id`, `employee_name`, `employee_address`, `employee_contact`) VALUES('"+idNumber+"', '"+name+"', '"+address+"', '"+number+"')";
			st.execute(query);
			
			dbCon.commit();
			
			System.out.println("Success Adding");
		} catch(Exception e){
			System.out.println("Error Adding: " + e);
		}
	}
	
	public void deleteEmployee(String idNumber){		
		try{
			st = dbCon.createStatement();
			query = "DELETE FROM `employee_info` WHERE `employee_id`='"+idNumber+"'";
			st.execute(query);
			
			dbCon.commit();
			
			System.out.println("Success Deleting");
		} catch(Exception e){
			System.out.println("Error Deleting: " + e);
		}
	}
	
	public void updateEmployee(String idNumber, String name, String address, String number){
		try{			
			st = dbCon.createStatement();
			query = "UPDATE `employee_info` SET `employee_name`='"+name+"', `employee_address`='"+address+"', `employee_contact`='"+number+"' WHERE `employee_id`='"+idNumber+"'";
			st.execute(query);
			
			dbCon.commit();
			
			System.out.println("Success Updating");
		} catch(Exception e){
			System.out.println("Error Updating: " + e);
		}
	}
}
