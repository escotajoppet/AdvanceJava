package HotelReservation;

public abstract class ConnectionClass {
	private String Driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/hotelroomreservation";
	private String UserName = "root";
	private String Password = "";
	
	public String getURL() {
		return this.URL;
	}	
	
	public String getDriver() {
		return this.Driver;
	}
	
	public String getUserName() {
		return this.UserName;
	}
	
	public String getPassword() {
		return this.Password;
	}
}
