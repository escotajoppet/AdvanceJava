package adt.classes;

import java.util.ArrayList;

public abstract class ADTClass extends ADTStudent{
	ArrayList<Integer> classEntryNumber = new ArrayList<Integer>();
	ArrayList<String> classSubjectCode = new ArrayList<String>();
	ArrayList<String> classSubjectName = new ArrayList<String>();
	ArrayList<String> classSchoolYear = new ArrayList<String>();
	ArrayList<String> classSemester = new ArrayList<String>();
	ArrayList<String> classSchedule = new ArrayList<String>();
	ArrayList<String> classYearAndSection = new ArrayList<String>();

	String selectedClassSubjectCode = "";
	String selectedClassSchedule = "";
	String selectedClassSubjectName = "";

	public void clearClassInfo(){
		this.classEntryNumber.clear();
		this.classSchedule.clear();
		this.classSchoolYear.clear();
		this.classSemester.clear();
		this.classSubjectCode.clear();
		this.classSubjectName.clear();
		this.classYearAndSection.clear();
	}
	
	public String getSelectedClassSubjectCode() {
		return selectedClassSubjectCode;
	}
	
	public void setSelectedClassSubjectCode(String selectedClassSubjectCode) {
		this.selectedClassSubjectCode = selectedClassSubjectCode;
	}
	
	public String getSelectedClassSubjectName() {
		return selectedClassSubjectName;
	}

	public void setSelectedClassSubjectName(String selectedClassSubjectName) {
		this.selectedClassSubjectName = selectedClassSubjectName;
	}

	public String getSelectedClassSchedule() {
		return selectedClassSchedule;
	}
	
	public void setSelectedClassSchedule(String selectedClassSchedule) {
		this.selectedClassSchedule = selectedClassSchedule;
	}

	public ArrayList<String> getClassYearAndSection() {
		return classYearAndSection;
	}

	public void setClassYearAndSection(String classYearAndSection) {
		this.classYearAndSection.add(classYearAndSection);
	}

	public ArrayList<Integer> getClassEntryNumber() {
		return classEntryNumber;
	}

	public void setClassEntryNumber(int classEntryNumber) {
		this.classEntryNumber.add(classEntryNumber);
	}

	public ArrayList<String> getClassSubjectCode() {
		return classSubjectCode;
	}
	
	public void setClassSubjectCode(String classSubjectCode) {
		this.classSubjectCode.add(classSubjectCode);
	}
	
	public ArrayList<String> getClassSubjectName() {
		return classSubjectName;
	}
	
	public void setClassSubjectName(String className) {
		this.classSubjectName.add(className);
	}
	
	public ArrayList<String> getClassSchoolYear() {
		return classSchoolYear;
	}
	
	public void setClassSchoolYear(String classSchoolYear) {
		this.classSchoolYear.add(classSchoolYear);
	}
	
	public ArrayList<String> getClassSemester() {
		return classSemester;
	}
	
	public void setClassSemester(String classSemester) {
		this.classSemester.add(classSemester);
	}
	
	public ArrayList<String> getClassSchedule() {
		return classSchedule;
	}
	
	public void setClassSchedule(String classSchedule) {
		this.classSchedule.add(classSchedule);
	}
}
