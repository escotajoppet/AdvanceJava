package hotel.reservation;

import java.util.ArrayList;

public abstract class PromoInformation extends RoomInformation{
	ArrayList<String> viewPromoName = new ArrayList<String>();
	ArrayList<String> viewPromoDescription = new ArrayList<String>();
	public void clearPromoInfomation(){
		this.viewPromoDescription.clear();
		this.viewPromoName.clear();
	}
	public ArrayList<String> getViewPromoName() {
		return viewPromoName;
	}
	public void setViewPromoName(String viewPromoName) {
		this.viewPromoName.add(viewPromoName);
	}
	public ArrayList<String> getViewPromoDescription() {
		return viewPromoDescription;
	}
	public void setViewPromoDescription(String viewPromoDescription) {
		this.viewPromoDescription.add(viewPromoDescription);
	}
}
