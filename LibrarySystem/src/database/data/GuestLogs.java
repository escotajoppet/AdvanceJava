package database.data;

import java.util.ArrayList;
import database.connection.SQLStringQueries;

public abstract class GuestLogs extends BorrowedBooks{

	String name = "";
	String id = "";

	ArrayList<String> logsStudentNumber = new ArrayList<String>();
	ArrayList<String> logsName = new ArrayList<String>();
	ArrayList<String> logsDateTime = new ArrayList<String>();
	ArrayList<String> logsTransaction = new ArrayList<String>();
	
	public void clearLogs(){
		this.logsDateTime.clear();
		this.logsName.clear();
		this.logsTransaction.clear();
		this.logsStudentNumber.clear();
	}
	
	public ArrayList<String> getLogsStudentNumber() {
		return logsStudentNumber;
	}

	public void setLogsStudentNumber(String logsStudentNumber) {
		this.logsStudentNumber.add(logsStudentNumber);
	}

	public ArrayList<String> getLogsName() {
		return logsName;
	}

	public void setLogsName(String logsName) {
		this.logsName.add(logsName);
	}

	public ArrayList<String> getLogsDateTime() {
		return logsDateTime;
	}

	public void setLogsDateTime(String logsDateTime) {
		this.logsDateTime.add(logsDateTime);
	}

	public ArrayList<String> getLogsTransaction() {
		return logsTransaction;
	}

	public void setLogsTransaction(String logsTransaction) {
		this.logsTransaction.add(logsTransaction);
	}

	public void setName(String name){
		this.name = name;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getId(){
		return this.id;
	}
	
	
}
