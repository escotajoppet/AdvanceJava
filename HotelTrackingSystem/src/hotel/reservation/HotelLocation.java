package hotel.reservation;

public abstract class HotelLocation extends PromoInformation{
	String viewHotelLocation = "";
	String viewHotelAddress = "";
	String viewHotelContact = "";
	String viewHotelName = "";
	public void clearViewLocation(){
		this.viewHotelAddress = "";
		this.viewHotelContact = "";
		this.viewHotelLocation = "";
		this.viewHotelName = "";
	}
	public String getViewHotelLocation() {
		return viewHotelLocation;
	}
	public void setViewHotelLocation(String viewHotelLocation) {
		this.viewHotelLocation = viewHotelLocation;
	}
	public String getViewHotelAddress() {
		return viewHotelAddress;
	}
	public void setViewHotelAddress(String viewHotelAddress) {
		this.viewHotelAddress = viewHotelAddress;
	}
	public String getViewHotelContact() {
		return viewHotelContact;
	}
	public void setViewHotelContact(String viewHotelContact) {
		this.viewHotelContact = viewHotelContact;
	}
	public String getViewHotelName() {
		return viewHotelName;
	}
	public void setViewHotelName(String viewHotelName) {
		this.viewHotelName = viewHotelName;
	}
}
