package hotel.reservation;

import java.util.ArrayList;

public abstract class TableData extends HotelLocation{
	ArrayList<String> hotelName = new ArrayList<String>();
	ArrayList<String> location = new ArrayList<String>();
	ArrayList<String> routeFrom = new ArrayList<String>();
	ArrayList<String> description = new ArrayList<String>();
	ArrayList<Integer> hotelId = new ArrayList<Integer>();

	public void clearTableData(){
		this.hotelId.clear();
		this.description.clear();
		this.hotelName.clear();
		this.routeFrom.clear();
		this.description.clear();
	}
	
	public ArrayList<Integer> getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId.add(hotelId);
	}
	
	public ArrayList<String> getHotelName() {
		return hotelName;
	}
	
	public void setHotelName(String hotelName) {
		this.hotelName.add(hotelName);
	}
	
	public ArrayList<String> getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location.add(location);
	}
	
	public ArrayList<String> getRouteFrom() {
		return routeFrom;
	}
	
	public void setRouteFrom(String routeFrom) {
		this.routeFrom.add(routeFrom);
	}
	
	public ArrayList<String> getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description.add(description);
	}
}
