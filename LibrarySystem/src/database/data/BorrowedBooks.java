package database.data;

import java.util.ArrayList;

import database.connection.SQLStringQueries;

public abstract class BorrowedBooks extends SQLStringQueries{
	ArrayList<String> borrowedControlNumber = new ArrayList<String>();
	ArrayList<String> borrowedBookTitle = new ArrayList<String>();
	ArrayList<String> borrowedAuthor = new ArrayList<String>();
	ArrayList<String> borrowedBorrower = new ArrayList<String>();
	ArrayList<Integer> borrowedYearPublished = new ArrayList<Integer>();
	
	public void clearBorrowed(){
		this.borrowedAuthor.clear();
		this.borrowedBookTitle.clear();
		this.borrowedControlNumber.clear();
		this.borrowedYearPublished.clear();
		this.borrowedBorrower.clear();
	}
	
	public ArrayList<String> getBorrowedBorrower() {
		return borrowedBorrower;
	}

	public void setBorrowedBorrower(String borrowedBorrower) {
		this.borrowedBorrower.add(borrowedBorrower);
	}
	
	public ArrayList<String> getBorrowedControlNumber() {
		return borrowedControlNumber;
	}
	
	public void setBorrowedControlNumber(String borrowedControlNumber) {
		this.borrowedControlNumber.add(borrowedControlNumber);
	}
	
	public ArrayList<String> getBorrowedBookTitle() {
		return borrowedBookTitle;
	}
	
	public void setBorrowedBookTitle(String borrowedBookTitle) {
		this.borrowedBookTitle.add(borrowedBookTitle);
	}
	
	public ArrayList<String> getBorrowedAuthor() {
		return borrowedAuthor;
	}
	
	public void setBorrowedAuthor(String borrowedAuthor) {
		this.borrowedAuthor.add(borrowedAuthor);
	}
	
	public ArrayList<Integer> getBorrowedYearPublished() {
		return borrowedYearPublished;
	}
	
	public void setBorrowedYearPublished(int borrowedYearPublished) {
		this.borrowedYearPublished.add(borrowedYearPublished);
	}
}
