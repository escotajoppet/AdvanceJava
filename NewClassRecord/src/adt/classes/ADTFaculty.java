package adt.classes;

import java.util.ArrayList;

public abstract class ADTFaculty extends ADTClass{
	ArrayList<String> alFacultyId = new ArrayList<String>();
	ArrayList<String> alFacultyName = new ArrayList<String>();
	ArrayList<String> alFacultyStatus = new ArrayList<String>();
	ArrayList<String> alFacultyPassword = new ArrayList<String>();
	
	String loggedId = "";
	String loggedName = "";
	String loggedStatus = "";

	public void clearFacultyInfo(){
		this.alFacultyId.clear();
		this.alFacultyName.clear();
		this.alFacultyPassword.clear();
		this.alFacultyStatus.clear();
	}
	
	public String getLoggedId() {
		return loggedId;
	}

	public void setLoggedId(String loggedId) {
		this.loggedId = loggedId;
	}

	public String getLoggedName() {
		return loggedName;
	}

	public void setLoggedName(String loggedName) {
		this.loggedName = loggedName;
	}

	public String getLoggedStatus() {
		return loggedStatus;
	}

	public void setLoggedStatus(String loggedStatus) {
		this.loggedStatus = loggedStatus;
	}
	
	public ArrayList<String> getAlFacultyId() {
		return alFacultyId;
	}
	
	public void setAlFacultyId(String alFacultyId) {
		this.alFacultyId.add(alFacultyId);
	}
	
	public ArrayList<String> getAlFacultyName() {
		return alFacultyName;
	}
	
	public void setAlFacultyName(String alFacultyName) {
		this.alFacultyName.add(alFacultyName);
	}
	
	public ArrayList<String> getAlFacultyStatus() {
		return alFacultyStatus;
	}
	
	public void setAlFacultyStatus(String alFacultyStatus) {
		this.alFacultyStatus.add(alFacultyStatus);
	}
	
	public ArrayList<String> getAlFacultyPassword() {
		return alFacultyPassword;
	}
	
	public void setAlFacultyPassword(String alFacultyPassword) {
		this.alFacultyPassword.add(alFacultyPassword);
	}	
}
