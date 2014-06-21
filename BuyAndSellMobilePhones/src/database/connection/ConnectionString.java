package database.connection;

public class ConnectionString {
	public String getDriver(){
		return "com.mysql.jdbc.Driver";
	}
	
	public String getURL(){
		return "jdbc:mysql://localhost:3306/buyandsellmobilephones";
	}
	
	public String getUsername(){
		return "root";
	}
	
	public String getPassword(){
		return "password";
	}
}
