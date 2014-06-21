package classrecord.table.data;

import java.util.ArrayList;

public abstract class Students extends GradeSheet{
	private ArrayList<String> studentId = new ArrayList<String>();
	private ArrayList<String> studentName= new ArrayList<String>();
	private ArrayList<String> studentAddress = new ArrayList<String>();
	private ArrayList<String> studentGender = new ArrayList<String>();
	private ArrayList<String> studentContact = new ArrayList<String>();
	
	public void setStudentId(String studentId){
		this.studentId.add(studentId);
	}
	
	public ArrayList<String> getStudentId(){
		return this.studentId;
	}
	
	public void setStudentName(String studentName){
		this.studentName.add(studentName);
	}
	
	public ArrayList<String> getStudentName(){
		return this.studentName;
	}
	
	public void setStudentAddress(String studentAddress){
		this.studentAddress.add(studentAddress);
	}
	
	public ArrayList<String> getStudentAddress(){
		return this.studentAddress;
	}
	
	public void setStudentGender(String studentGender){
		this.studentGender.add(studentGender);
	}
	
	public ArrayList<String> getStudentGender(){
		return this.studentGender;
	}
	
	public void setStudentContact(String studentContact){
		this.studentContact.add(studentContact);
	}
	
	public ArrayList<String> getStudentContact(){
		return this.studentContact;
	}
	
	public void clearStudentLists(){
		this.studentAddress.clear();
		this.studentContact.clear();
		this.studentGender.clear();
		this.studentId.clear();
		this.studentName.clear();
	}
}
