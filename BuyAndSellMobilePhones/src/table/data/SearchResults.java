package table.data;

import java.util.ArrayList;

public abstract class SearchResults extends SellerProfile{
	ArrayList<Integer> entryNumber = new ArrayList<Integer>();
	ArrayList<String> deviceModel = new ArrayList<String>();
	ArrayList<String> datePosted = new ArrayList<String>();
	ArrayList<String> description = new ArrayList<String>();
	ArrayList<String> seller = new ArrayList<String>();
	ArrayList<String> price = new ArrayList<String>();
	
	public ArrayList<Integer> getEntryNumber() {
		return entryNumber;
	}
	
	public void setEntryNumber(int entryNumber) {
		this.entryNumber.add(entryNumber);
	}
	
	public ArrayList<String> getDeviceModel() {
		return deviceModel;
	}
	
	public void setDeviceModel(String deviceModel) {
		this.deviceModel.add(deviceModel);
	}
	
	public ArrayList<String> getDatePosted() {
		return datePosted;
	}
	
	public void setDatePosted(String datePosted) {
		this.datePosted.add(datePosted);
	}
	
	public ArrayList<String> getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description.add(description);
	}
	
	public ArrayList<String> getSeller() {
		return seller;
	}
	
	public void setSeller(String seller) {
		this.seller.add(seller);
	}
	
	public ArrayList<String> getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price.add(price);
	}
	
	public void clearResults(){
		this.datePosted.clear();
		this.description.clear();
		this.deviceModel.clear();
		this.entryNumber.clear();
		this.price.clear();
		this.seller.clear();
	}
}
