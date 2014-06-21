package hotel.reservation;

public abstract class SQLConnectionString {
	public String getDriver(){
		return "com.mysql.jdbc.Driver";
	}
	
	public String getURL(){
		return "jdbc:mysql://localhost:3306/loyolaproject";
	}
	
	public String getUsername(){
		return "root";
	}
	
	public String getPassword(){
		return "password";
	}
}
