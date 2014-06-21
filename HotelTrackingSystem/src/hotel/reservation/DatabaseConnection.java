package hotel.reservation;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection extends SQLConnectionString{
	Connection dbCon = null;
	
	public Connection getConnection(){
		try{
			Class.forName(getDriver()).newInstance();
			dbCon = DriverManager.getConnection(getURL(), getUsername(), getPassword());
			
			return this.dbCon;
		} catch(Exception e){
			System.out.println("error connecting to database: " + e);
			return null;
		}
	}
}
