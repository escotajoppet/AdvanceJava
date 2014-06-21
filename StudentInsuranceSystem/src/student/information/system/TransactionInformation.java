package student.information.system;

import java.util.ArrayList;

public abstract class TransactionInformation {
	ArrayList<String> transactionDate = new ArrayList<String>();
	ArrayList<String> transactionAdmin = new ArrayList<String>();
	ArrayList<String> transactionAction = new ArrayList<String>();
	ArrayList<Integer> transactionAccount = new ArrayList<Integer>();
	
	public void clearTransactionInformation(){
		this.transactionAccount.clear();
		this.transactionAction.clear();
		this.transactionAdmin.clear();
		this.transactionDate.clear();
	}
	public ArrayList<String> getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate.add(transactionDate);
	}
	public ArrayList<String> getTransactionAdmin() {
		return transactionAdmin;
	}
	public void setTransactionAdmin(String transactionAdmin) {
		this.transactionAdmin.add(transactionAdmin);
	}
	public ArrayList<String> getTransactionAction() {
		return transactionAction;
	}
	public void setTransactionAction(String transactionAction) {
		this.transactionAction.add(transactionAction);
	}
	public ArrayList<Integer> getTransactionAccount() {
		return transactionAccount;
	}
	public void setTransactionAccount(int transactionAccount) {
		this.transactionAccount.add(transactionAccount);
	}	
}
