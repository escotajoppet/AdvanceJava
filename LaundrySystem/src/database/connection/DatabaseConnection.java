package database.connection;

import java.sql.*;

public class DatabaseConnection extends ConnectionString{
	Connection dbCon = null;
	
	public Connection connectToDb(){
		try{
			Class.forName(getDriver());
			dbCon = DriverManager.getConnection(getURL(), getUsername(), getPassword());
			
			return dbCon;
		} catch(Exception e){
			System.out.println("connection failed " + e);
			return null;
		}
	}
}
