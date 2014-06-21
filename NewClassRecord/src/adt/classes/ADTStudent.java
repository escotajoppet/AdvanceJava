package adt.classes;

import java.util.ArrayList;

public abstract class ADTStudent extends ADTGrade{
	ArrayList<Integer> studentEntryNumber = new ArrayList<Integer>();
	ArrayList<String> studentSubjectCode = new ArrayList<String>();
	ArrayList<String> studentId = new ArrayList<String>();
	ArrayList<String> studentName = new ArrayList<String>();
	ArrayList<String> studentYearAndSection = new ArrayList<String>();
	ArrayList<String> studentStatus = new ArrayList<String>();
	
	String selectedStudent = "";
	String selectedSubject = "";
	
	public void clearStudentInfo(){
		this.studentEntryNumber.clear();
		this.studentId.clear();
		this.studentName.clear();
		this.studentStatus.clear();
		this.studentSubjectCode.clear();
		this.studentYearAndSection.clear();
	}
	
	public String getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(String selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public String getSelectedSubject() {
		return selectedSubject;
	}

	public void setSelectedSubject(String selectedSubject) {
		this.selectedSubject = selectedSubject;
	}

	public ArrayList<Integer> getStudentEntryNumber() {
		return studentEntryNumber;
	}
	
	public void setStudentEntryNumber(int studentEntryNumber) {
		this.studentEntryNumber.add(studentEntryNumber);
	}
	
	public ArrayList<String> getStudentSubjectCode() {
		return studentSubjectCode;
	}
	
	public void setStudentSubjectCode(String studentSubjectCode) {
		this.studentSubjectCode.add(studentSubjectCode);
	}
	
	public ArrayList<String> getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId.add(studentId);
	}
	
	public ArrayList<String> getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName.add(studentName);
	}
	
	public ArrayList<String> getStudentYearAndSection() {
		return studentYearAndSection;
	}
	
	public void setStudentYearAndSection(String studentYearAndSection) {
		this.studentYearAndSection.add(studentYearAndSection);
	}
}
