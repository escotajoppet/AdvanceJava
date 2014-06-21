package table.data;

import java.util.ArrayList;

public abstract class CategoryList extends BreedList {
	private ArrayList<String> petCategory = new ArrayList<String>();
	private ArrayList<Integer> breedQuantity = new ArrayList<Integer>();
	
	public void setCategory(String category){
		this.petCategory.add(category);
	}
	
	public ArrayList<String> getCategory(){
		return this.petCategory;
	}
	
	public void setQuantities(int quantity){
		this.breedQuantity.add(quantity);
	}
	
	public ArrayList<Integer> getQuantities(){
		return this.breedQuantity;
	}
	
	public void clearCategoryList(){
		this.petCategory.clear();
		this.breedQuantity.clear();
	}
}
