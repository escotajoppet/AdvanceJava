package pharmacy.system;

import java.sql.*;

public class DbConnect extends ConnectionString{	
	public Connection getConnection(){
		try{
			Class.forName(getDriver()).newInstance();
			Connection dbCon =  DriverManager.getConnection(getURL(), getUsername(), getDbPassword());
			dbCon.setAutoCommit(false);
			
			return dbCon;
		} catch(Exception e){
			System.out.println("error " + e);
			return null;
		}
	}
}
