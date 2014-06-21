package student.information.system;

import java.util.ArrayList;

public abstract class ViewCustomers extends UpdateAccountForm{
	ArrayList<Integer> accountNumber = new ArrayList<Integer>();
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> startingDate = new ArrayList<String>();
	ArrayList<String> expirationDate = new ArrayList<String>();
	ArrayList<String> insuranceType = new ArrayList<String>();
	
	public void clearCustomers(){
		this.accountNumber.clear();
		this.name.clear();
		this.startingDate.clear();
		this.expirationDate.clear();
		this.insuranceType.clear();
	}
	
	public ArrayList<String> getInsuranceType() {
		return insuranceType;
	}
	
	public void setInsuranceType(String insuranceType) {
		this.insuranceType.add(insuranceType);
	}

	public ArrayList<Integer> getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber.add(accountNumber);
	}
	
	public ArrayList<String> getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name.add(name);
	}
	
	public ArrayList<String> getStartingDate() {
		return startingDate;
	}
	
	public void setStartingDate(String startingDate) {
		this.startingDate.add(startingDate);
	}
	
	public ArrayList<String> getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(String expirationDate) {
		this.expirationDate.add(expirationDate);
	}
}
