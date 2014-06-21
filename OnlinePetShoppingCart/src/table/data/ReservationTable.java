package table.data;

import java.util.ArrayList;

public class ReservationTable extends PetItems{
	ArrayList<String> transactionDate = new ArrayList<String>();
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> address = new ArrayList<String>();
	ArrayList<String> contactNumber = new ArrayList<String>();
	ArrayList<String> reservedOrder = new ArrayList<String>();
	
	public ArrayList<String> getTransactionDate() {
		return this.transactionDate;
	}
	
	public void setTransactionDate(String transactionDate) {
		this.transactionDate.add(transactionDate);
	}
	
	public ArrayList<String> getReservedName() {
		return this.name;
	}
	
	public void setReservedName(String name) {
		this.name.add(name);
	}
	
	public ArrayList<String> getReservedAddress() {
		return this.address;
	}
	
	public void setReservedAddress(String address) {
		this.address.add(address);
	}
	
	public ArrayList<String> getReservedContactNumber() {
		return this.contactNumber;
	}
	
	public void setReservedContactNumber(String contactNumber) {
		this.contactNumber.add(contactNumber);
	}
	
	public ArrayList<String> getOrder() {
		return this.reservedOrder;
	}
	
	public void setOrder(String reservedOrder) {
		this.reservedOrder.add(reservedOrder);
	}
	
	public void clearReservationTable(){
		this.address.clear();
		this.contactNumber.clear();
		this.name.clear();
		this.transactionDate.clear();
		this.reservedOrder.clear();
	}
}
