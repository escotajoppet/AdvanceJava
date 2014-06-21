package flight.reservation;

import java.util.ArrayList;

public abstract class TransactionInformation {
	ArrayList<String> transactionTimeOfBooking = new ArrayList<String>();
	ArrayList<String> transactionEmailAddress = new ArrayList<String>();
	ArrayList<String> transactionFromLocation = new ArrayList<String>();
	ArrayList<String> transactionToLocation = new ArrayList<String>();
	ArrayList<String> transactionDeparture = new ArrayList<String>();
	ArrayList<String> transactionArrival = new ArrayList<String>();
	ArrayList<String> transactionStatus = new ArrayList<String>();
	
	public void clearTransactionInfo(){
		this.transactionDeparture.clear();
		this.transactionEmailAddress.clear();
		this.transactionFromLocation.clear();
		this.transactionStatus.clear();
		this.transactionTimeOfBooking.clear();
		this.transactionToLocation.clear();
	}
	
	public ArrayList<String> getTransactionTimeOfBooking() {
		return transactionTimeOfBooking;
	}
	
	public void setTransactionTimeOfBooking(String transactionTimeOfBooking) {
		this.transactionTimeOfBooking.add(transactionTimeOfBooking);
	}
	
	public ArrayList<String> getTransactionEmailAddress() {
		return transactionEmailAddress;
	}
	
	public void setTransactionEmailAddress(String transactionEmailAddress) {
		this.transactionEmailAddress.add(transactionEmailAddress);
	}
	
	public ArrayList<String> getTransactionFromLocation() {
		return transactionFromLocation;
	}
	
	public void setTransactionFromLocation(String transactionFromLocation) {
		this.transactionFromLocation.add(transactionFromLocation);
	}
	
	public ArrayList<String> getTransactionToLocation() {
		return transactionToLocation;
	}
	
	public void setTransactionToLocation(String transactionToLocation) {
		this.transactionToLocation.add(transactionToLocation);
	}
	
	public ArrayList<String> getTransactionDeparture() {
		return transactionDeparture;
	}
	
	public void setTransactionDeparture(String transactionDeparture) {
		this.transactionDeparture.add(transactionDeparture);
	}
	
	public ArrayList<String> getTransactionArrival() {
		return transactionDeparture;
	}
	
	public void setTransactionArrival(String transactionArrival) {
		this.transactionArrival.add(transactionArrival);
	}
	
	public ArrayList<String> getTransactionStatus() {
		return transactionStatus;
	}
	
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus.add(transactionStatus);
	}
}
