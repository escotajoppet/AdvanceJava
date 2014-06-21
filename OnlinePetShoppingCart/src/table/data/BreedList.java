package table.data;

import java.util.ArrayList;

public abstract class BreedList extends ForReservation{
	String selectedCategory = "";
	
	ArrayList<Integer> entryIds = new ArrayList<Integer>();
	ArrayList<String> categoryBreeds = new ArrayList<String>();
	ArrayList<String> breedPrice = new ArrayList<String>();
	
	public void setSelectedCategory(String selectedCategory){
		this.selectedCategory = selectedCategory;
	}
	
	public String getSelectedCategory(){
		return this.selectedCategory;
	}
	
	public void setCategoryBreeds(String breed){
		this.categoryBreeds.add(breed);
	}
	
	public ArrayList<String> getCategoryBreeds(){
		return this.categoryBreeds;
	}
	
	public void setBreedPrices(String price){
		this.breedPrice.add(price);
	}
	
	public ArrayList<String> getBreedPrices(){
		return this.breedPrice;
	}
	
	public void setEntryId(int entryId){
		this.entryIds.add(entryId);
	}
	
	public ArrayList<Integer> getEntryId(){
		return this.entryIds;
	}
	
	public void clearSelectedCategoryBreeds(){
		this.breedPrice.clear();
		this.categoryBreeds.clear();
		this.entryIds.clear();
	}
}
