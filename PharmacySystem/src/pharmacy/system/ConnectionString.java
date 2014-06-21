package pharmacy.system;

public class ConnectionString extends SqlStringCommands{
	public String getDriver(){
		return "com.mysql.jdbc.Driver";
	}
	
	public String getURL(){
		return "jdbc:mysql://localhost:3306/pharmacydb";
	}
	
	public String getUsername(){
		return "root";
	}
	
	public String getDbPassword(){
		return "password";
	}
}
