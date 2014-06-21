package database.data;

import java.util.*;

public abstract class Booklist extends UserAdmin{
	ArrayList<String> controlNumber = new ArrayList<String>();
	ArrayList<String> book_title = new ArrayList<String>();
	ArrayList<String> author = new ArrayList<String>();
	ArrayList<Integer> year_published = new ArrayList<Integer>();
	ArrayList<String> availability = new ArrayList<String>();
	
	public void clear(){
		controlNumber.clear();
		book_title.clear();
		author.clear();
		year_published.clear();
		availability.clear();
	}
	
	public void setControlNumber(String controlNumber){
		this.controlNumber.add(controlNumber);
	}
	
	public ArrayList<String> getControlNumber() {
		return controlNumber;
	}

	public void setBook_title(String Book_title){
		this.book_title.add(Book_title);
	}
	
	public ArrayList<String> getBook_title() {
		return book_title;
	}
	
	public void setAuthor(String author){
		this.author.add(author);
	}

	public ArrayList<String> getAuthor() {
		return author;
	}
	
	public void setYear_Published(int year_published){
		this.year_published.add(year_published);
	}

	public ArrayList<Integer> getYear_published() {
		return year_published;
	}
	
	public void setAvailability(String availability){
		this.availability.add(availability);
	}

	public ArrayList<String> getAvailability() {
		return availability;
	}
}
