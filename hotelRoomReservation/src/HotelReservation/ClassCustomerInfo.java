package HotelReservation;

public abstract class ClassCustomerInfo extends ClassGeneralInfo{
	private String fName ="";
	private String lName ="";
	private String address ="";
	private String email ="";
	private int contact = 0;

	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getfName() {
		return this.fName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getlName() {
		return this.lName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	
	public int getContact() {
		return this.contact;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
