package loan.system;

import java.util.ArrayList;

public abstract class GetBalance {
	ArrayList<String> transactionDates = new ArrayList<String>();
	ArrayList<String> loanInterest = new ArrayList<String>();
	ArrayList<Double> totalAmount = new ArrayList<Double>();
	ArrayList<Double> remainingBalance = new ArrayList<Double>();
	ArrayList<Double> payments = new ArrayList<Double>();
	ArrayList<Double> loanAmount = new ArrayList<Double>();
	
	
	public void clearBalance(){
		this.payments.clear();
		this.remainingBalance.clear();
		this.totalAmount.clear();
		this.transactionDates.clear();
		this.loanAmount.clear();
	}
	public ArrayList<String> getLoanInterest() {
		return loanInterest;
	}
	public void setLoanInterest(String loanInterest) {
		this.loanInterest.add(loanInterest);
	}
	public ArrayList<Double> getLoanAmount(){
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount){
		this.loanAmount.add(loanAmount);
	}
	public ArrayList<String> getTransactionDates() {
		return transactionDates;
	}
	public void setTransactionDates(String transactionDates) {
		this.transactionDates.add(transactionDates);
	}
	public ArrayList<Double> getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount.add(totalAmount);
	}
	public ArrayList<Double> getRemainingBalance() {
		return remainingBalance;
	}
	public void setRemainingBalance(double remainingBalance) {
		this.remainingBalance.add(remainingBalance);
	}
	public ArrayList<Double> getPayments() {
		return payments;
	}
	public void setPayments(double payments) {
		this.payments.add(payments);
	}
	
}
