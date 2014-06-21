package database.connection;

import java.sql.*;

public class ConnectToDb extends DatabaseConnectionString{	
	public Connection getConnection(){
		try{
			Class.forName(getDriver()).newInstance();
			return DriverManager.getConnection(getURL(), getUsername(), getPassword());
			
		} catch(Exception e){
			System.out.println("error " + e);
			return null;
		}
	}
}
