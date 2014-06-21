package table.data;

import java.util.ArrayList;

public class PetItems {
	ArrayList<String> petItems = new ArrayList<String>();
	ArrayList<String> pricePetItem = new ArrayList<String>();
	
	public ArrayList<String> getPetItems() {
		return petItems;
	}
	
	public void setPetItems(String petItem){
		this.petItems.add(petItem);
	}
	
	public ArrayList<String> getPricePetItem() {
		return pricePetItem;
	}
	
	public void setPricePerItem(String price){
		this.pricePetItem.add(price);
	}
	
	public void clearItemList(){
		this.petItems.clear();
		this.pricePetItem.clear();
	}
}
