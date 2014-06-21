package classrecord.table.data;

import java.sql.*;
import java.util.ArrayList;

import database.connection.ConnectToDb;

public abstract class Classes extends Students{
	private ConnectToDb objNewDbCon = new ConnectToDb();

	private ArrayList<String> classYearSection = new ArrayList<String>();
	private ArrayList<String> classNumberOfStudents = new ArrayList<String>();
	private ArrayList<String> classSchedule = new ArrayList<String>();
	
	private Connection dbCon = objNewDbCon.getConnection();
	private Statement st = null;
	private String query = "";
	private String newSchedule = "";
	private ResultSet rs = null;
	
	public void setClassYearSection(String classYearSection){
		this.classYearSection.add(classYearSection);
	}
	
	public ArrayList<String> getClassYearSection(){
		return this.classYearSection;
	}
	
	public void setClassSchedule(String classSchedule){
		this.classSchedule.add(classSchedule);
	}
	
	public ArrayList<String> getClassSchedule(){
		return this.classSchedule;
	}
	
	public void setNumberOfStudents(){																				
		int rowCount = 0;																									
		
		try{																																									
			st = dbCon.createStatement();																				
				
			for(int i = 0; i<getClassYearSection().size(); i++){																	
				rowCount = 0;																									
				
				query = "SELECT 'student_id' FROM `"+getClassYearSection().get(i)+"_class`";						
				rs = st.executeQuery(query);																				
				
				while(rs.next()){																								
					rowCount++;																								
				}																													
				
				this.classNumberOfStudents.add(Integer.toString(rowCount));	
				updateNumberOfStudents(getClassYearSection().get(i), rowCount);
			}																														
			
		} catch(Exception e){
			System.out.println("error setting number of students: " + e);
			return;																												
		}																															
	}
	
	public void updateNumberOfStudents(String classYearSection, int rowCount){
		try{
			st = dbCon.createStatement();
			query = "UPDATE `list_of_classes` SET `class_number_of_students`='"+Integer.toString(rowCount)+"' WHERE `class_year_and_section`='"+classYearSection+"'";
			st.execute(query);

		} catch(Exception e){
			System.out.println("error updating number of students: " + e);
			return;
		}
	}
	
	public ArrayList<String> getNumberOfStudents(){																
		return this.classNumberOfStudents;																					
	}	
	
	public void clearClassLists(){
		this.classYearSection.clear();
		this.classSchedule.clear();
		this.classNumberOfStudents.clear();
	}
	
	public void setScheduleOfNewClass(String[] days, String[] fromTime0, String[] fromTime1, String[] from, String[] toTime0, String[] toTime1, String[] to){	
		StringBuilder sb = new StringBuilder();																																							
		
		for(int i = 0; i<days.length; i++){																																								
			if(i>0){																																																
				sb.append("/ ");																																												
			}																																																		
			
			sb.append(days[i] + " " + fromTime0[i]+":"+fromTime1[i]+from[i] + " - " + toTime0[i]+":"+toTime1[i]+to[i]);														
		}				
		
		this.newSchedule = sb.toString();
	}
	
	public String getScheduleOfNewClass(){
		return this.newSchedule;
	}
}
