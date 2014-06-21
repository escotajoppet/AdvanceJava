package table.data;

import java.util.ArrayList;

import sql.string.commands.SqlStringCommands;

public abstract class SoldItems extends SqlStringCommands{
	ArrayList<Integer> soldEntryNumber = new ArrayList<Integer>();
	ArrayList<String> soldDeviceModel = new ArrayList<String>();
	ArrayList<String> soldDate = new ArrayList<String>();
	ArrayList<String> soldDescription = new ArrayList<String>();
	ArrayList<String> soldSeller = new ArrayList<String>();
	ArrayList<String> soldPrice = new ArrayList<String>();
	
	public void clearSoldItems(){
		this.soldDate.clear();
		this.soldDescription.clear();
		this.soldDeviceModel.clear();
		this.soldEntryNumber.clear();
		this.soldPrice.clear();
		this.soldSeller.clear();
	}
	public ArrayList<Integer> getSoldEntryNumber() {
		return soldEntryNumber;
	}
	public void setSoldEntryNumber(int soldEntryNumber) {
		this.soldEntryNumber.add(soldEntryNumber);
	}
	public ArrayList<String> getSoldDeviceModel() {
		return soldDeviceModel;
	}
	public void setSoldDeviceModel(String soldDeviceModel) {
		this.soldDeviceModel.add(soldDeviceModel);
	}
	public ArrayList<String> getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(String soldDate) {
		this.soldDate.add(soldDate);
	}
	public ArrayList<String> getSoldDescription() {
		return soldDescription;
	}
	public void setSoldDescription(String soldDescription) {
		this.soldDescription.add(soldDescription);
	}
	public ArrayList<String> getSoldSeller() {
		return soldSeller;
	}
	public void setSoldSeller(String soldSeller) {
		this.soldSeller.add(soldSeller);
	}
	public ArrayList<String> getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(String soldPrice) {
		this.soldPrice.add(soldPrice);
	}
}
