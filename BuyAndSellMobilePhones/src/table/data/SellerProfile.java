package table.data;

import java.util.ArrayList;

import sql.string.commands.SqlStringCommands;

public abstract class SellerProfile extends SoldItems{
	String contactNumber = "";
	String emailAddress = "";
	String fbAccount = "";
	String name = "";
	
	ArrayList<String> sellerPhones = new ArrayList<String>();
	ArrayList<String> sellerDates = new ArrayList<String>();
	ArrayList<String> sellerDescription= new ArrayList<String>();
	ArrayList<String> sellerPrices= new ArrayList<String>();
	ArrayList<Integer> sellerEntryNumber = new ArrayList<Integer>();
	
	public void clearSellerProfile(){
		this.sellerDates.clear();
		this.sellerPhones.clear();
		this.sellerPrices.clear();
		this.sellerDescription.clear();
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getFbAccount() {
		return fbAccount;
	}
	
	public void setFbAccount(String fbAccount) {
		this.fbAccount = fbAccount;
	}
	
	public ArrayList<Integer> getSellerEntryNumber() {
		return sellerEntryNumber;
	}
	
	public void setSellerEntryNumber(int sellerEntryNumber) {
		this.sellerEntryNumber.add(sellerEntryNumber);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setSellerPhones(String phones){
		this.sellerPhones.add(phones);
	}
	
	public ArrayList<String> getSellerPhones(){
		return this.sellerPhones;
	}
	
	public void setSellerDates(String date){
		this.sellerDates.add(date);
	}
	
	public ArrayList<String> getSellerDates(){
		return this.sellerDates;
	}
	
	public void setSellerDescriptions(String description){
		this.sellerDescription.add(description);
	}
	
	public ArrayList<String> getSellerDescription(){
		return this.sellerDescription;
	}
	
	public void setSellerPrices(String price){
		this.sellerPrices.add(price);
	}
	
	public ArrayList<String> getSellerPrices(){
		return this.sellerPrices;
	}
}
