package table.data;

import java.util.ArrayList;

public abstract class ViewCustomers {
	ArrayList<String> customerName = new ArrayList<String>();
	ArrayList<String> customerAddress = new ArrayList<String>();
	ArrayList<String> customerContact = new ArrayList<String>();
	ArrayList<String> customerEmailAdd = new ArrayList<String>();
	ArrayList<String> customerBday = new ArrayList<String>();
	ArrayList<String> customerGender = new ArrayList<String>();
	ArrayList<String> customerCivilStatus = new ArrayList<String>();
	ArrayList<String> customerUsername = new ArrayList<String>();
	ArrayList<String> customerPassword = new ArrayList<String>();
	public void clearCustomerView(){
		this.customerAddress.clear();
		this.customerName.clear();
		this.customerContact.clear();
		this.customerEmailAdd.clear();
		this.customerBday.clear();
		this.customerGender.clear();
		this.customerCivilStatus.clear();
		this.customerUsername.clear();
		this.customerPassword.clear();
	}
	public ArrayList<String> getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName.add(customerName) ;
	}
	public ArrayList<String> getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress.add(customerAddress);
	}
	public ArrayList<String> getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact.add(customerContact);
	}
	public ArrayList<String> getCustomerEmailAdd() {
		return customerEmailAdd;
	}
	public void setCustomerEmailAdd(String customerEmailAdd) {
		this.customerEmailAdd.add(customerEmailAdd);
	}
	public ArrayList<String> getCustomerBday() {
		return customerBday;
	}
	public void setCustomerBday(String customerBday) {
		this.customerBday.add(customerBday);
	}
	public ArrayList<String> getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender.add(customerGender);
	}
	public ArrayList<String> getCustomerCivilStatus() {
		return customerCivilStatus;
	}
	public void setCustomerCivilStatus(String customerCivilStatus) {
		this.customerCivilStatus.add(customerCivilStatus);
	}
	public ArrayList<String> getCustomerUsername() {
		return customerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername.add(customerUsername);
	}
	public ArrayList<String> getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword.add(customerPassword);
	}
}
