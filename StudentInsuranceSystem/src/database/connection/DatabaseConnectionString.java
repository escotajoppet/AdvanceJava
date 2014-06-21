package database.connection;

public class DatabaseConnectionString {
	private final String DRIVER= "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/";
	private final String DATABASE = "studentinsurancesystem";
	private final String USERNAME = "root";
	private final String PASSWORD = "password";
	
	public String getDriver(){
		return this.DRIVER;
	}
	
	public String getURL(){
		return this.URL + this.DATABASE;
	}
	
	public String getUsername(){
		return this.USERNAME;
	}
	
	public String getPassword(){
		return this.PASSWORD;
	}
}
