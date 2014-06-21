package HotelReservation;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DBConn extends ConnectionClass {

	public Connection connectDB() {
		Connection conn = null;
		try {
			Class.forName(getDriver()).newInstance();
			conn = DriverManager.getConnection(getURL(), getUserName(), getPassword());
			conn.setAutoCommit(false);	
			
		} catch (Exception e) {}		
		return conn;
	}

}
