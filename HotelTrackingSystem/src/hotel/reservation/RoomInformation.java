package hotel.reservation;

import java.util.ArrayList;

public abstract class RoomInformation {
	ArrayList<String> viewRoomType = new ArrayList<String>();
	ArrayList<String> viewRoomDescription = new ArrayList<String>();
	public void clearRoomInformation(){
		this.viewRoomDescription.clear();
		this.viewRoomType.clear();
	}
	public ArrayList<String> getViewRoomType() {
		return viewRoomType;
	}
	public void setViewRoomType(String viewRoomType) {
		this.viewRoomType.add(viewRoomType);
	}
	public ArrayList<String> getViewRoomDescription() {
		return viewRoomDescription;
	}
	public void setViewRoomDescription(String viewRoomDescription) {
		this.viewRoomDescription.add(viewRoomDescription);
	}
}
