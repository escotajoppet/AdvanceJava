package art.gallery;

import java.util.ArrayList;

import sql.string.commands.SqlStringCommands;

public abstract class ArtWorks extends SelectedInfo{
	ArrayList<Integer> artEntryNumber = new ArrayList<Integer>();
	ArrayList<String> artEntryDate = new ArrayList<String>();
	ArrayList<String> artEntryTitle = new ArrayList<String>();
	ArrayList<String> artAuthor = new ArrayList<String>();
	ArrayList<String> artLocation = new ArrayList<String>();
	ArrayList<String> artCategory = new ArrayList<String>();

	public ArrayList<String> getArtAuthor() {
		return artAuthor;
	}

	public void setArtAuthor(String artAuthor) {
		this.artAuthor.add(artAuthor);
	}
	
	public ArrayList<String> getArtEntryDate() {
		return artEntryDate;
	}

	public void setArtEntryDate(String artEntryDate) {
		this.artEntryDate.add(artEntryDate);
	}

	public ArrayList<String> getArtLocation() {
		return artLocation;
	}

	public void setArtLocation(String artLocation) {
		this.artLocation.add(artLocation);
	}

	public ArrayList<String> getArtCategory() {
		return artCategory;
	}

	public void setArtCategory(String artCategory) {
		this.artCategory.add(artCategory);
	}

	public void clearArtInfo(){
		this.artEntryTitle.clear();
		this.artEntryDate.clear();
		this.artEntryNumber.clear();
		this.artAuthor.clear();
		this.artLocation.clear();
		this.artCategory.clear();
	}
	
	public ArrayList<Integer> getArtEntryNumber() {
		return artEntryNumber;
	}
	
	public void setArtEntryNumber(int artEntryNumber) {
		this.artEntryNumber.add(artEntryNumber);
	}
	
	public ArrayList<String> getPhotographEntryDate() {
		return artEntryDate;
	}
	
	public void setPhotographEntryDate(String artEntryDate) {
		this.artEntryDate.add(artEntryDate);
	}
	
	public ArrayList<String> getArtEntryTitle() {
		return artEntryTitle;
	}
	
	public void setArtEntryTitle(String artEntryTitle) {
		this.artEntryTitle.add(artEntryTitle);
	}	
}
