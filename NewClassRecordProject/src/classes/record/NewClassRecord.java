package classes.record;

import java.sql.*;
import database.connection.*;
import classrecord.table.data.*;

public class NewClassRecord extends Classes{
	
	private Statement st = null;
	private ResultSet rs = null;
	private ConnectToDb objDbCon = null;
	
	private String query = "";
	private String studentName = "";

	public NewClassRecord(){
		objDbCon = new ConnectToDb();
	}
	
	public Connection getConnection(){
		return this.objDbCon.getConnection();
	}
	
	public void setList(String type){
		String fields = "";
		String tableName = "";
		String condition = "";
		
		switch(type){
			case "classes":
				fields = "`class_year_and_section`, `class_schedule`";
				tableName = "list_of_classes";
				condition = "1";
				break;
			case "students":
				fields = "`student_id`, `student_name`, `student_address`, `student_contact_number`, `student_gender`";
				tableName = getClassInfo()+"_class";
				condition = "1";
				break;
			case "grades":
				fields = "`minor_exam_quiz_1`, `minor_exam_quiz_2`, `major_exam_midterm`, `project_midterm`, "
						+ "`minor_exam_quiz_3`, `minor_exam_quiz_4`, `major_exam_finals`, `project_finals`";
				tableName = getClassInfo()+"_class";
				condition = "`student_id`='"+getStudent()+"'";
				break;
			default:
				fields = "";
				tableName = "";
				condition = "";
				break;
		}
		
		try{
			st = getConnection().createStatement();
			query = selectFields(fields, tableName, condition);
			rs = st.executeQuery(query);
			
			while(rs.next()){
				switch(type){
					case "classes":
						setClassYearSection(rs.getString("class_year_and_section"));
						setClassSchedule(rs.getString("class_schedule"));
						break;
					case "students":
						setStudentId(rs.getString("student_id"));
						setStudentName(rs.getString("student_name"));
						setStudentAddress(rs.getString("student_address"));
						setStudentGender(rs.getString("student_gender"));
						setStudentContact(rs.getString("student_contact_number"));
						break;
					case "grades":
						setQuiz1(rs.getString("minor_exam_quiz_1"));																			
						setQuiz2(rs.getString("minor_exam_quiz_2"));																			
						setMidtermExam(rs.getString("major_exam_midterm"));																		
						setMidtermProject(rs.getString("project_midterm"));																					
						setQuiz3(rs.getString("minor_exam_quiz_3"));																			
						setQuiz4(rs.getString("minor_exam_quiz_4"));																			
						setFinalExam(rs.getString("major_exam_finals"));															
						setFinalProject(rs.getString("project_finals"));	
						break;
					default:
						break;
				}
			}
			
			if(type.equals("classes")){
				setNumberOfStudents();
			}
		} catch(Exception e){
			setMessage("error setting "+type+" list: " + e);
			return;
		}
	}
	
	public void add(String[] conditionValues, String type){
		String tableName = "";
		String fields = "";
		String values = "";
		
		switch(type){
			case "classes":
				tableName = "list_of_classes";
				fields = "`class_year_and_section`, `class_number_of_students`, `class_schedule`";
				values = "'"+conditionValues[0] + "-" +conditionValues[1] +"', '0', '"+getScheduleOfNewClass()+"'";
				break;
			case "students":
				tableName = getClassInfo()+"_class";
				fields = "`student_id`, `student_name`, `student_address`, `student_contact_number`, "
					+ "`student_gender`, `major_exam_midterm`, `major_exam_finals`, `minor_exam_quiz_1`, "
					+ "`minor_exam_quiz_2`, `minor_exam_quiz_3`, `minor_exam_quiz_4`, `project_midterm`, `project_finals`";
				values = "'"+conditionValues[0]+"', '"+getFullName()+"', '"+conditionValues[1]+"', '"+conditionValues[2]+"', "
					+ "'"+conditionValues[3]+"', '', '', '', '', '', '', '', ''";
				break;
		}
		
		try{
			st = getConnection().createStatement();
			query = insertIntoFields(tableName, fields, values);
			st.execute(query);
		} catch(Exception e){
			setMessage("error adding new " + type + " " + e);
			return;
		}
	}
	
	public void createNewClassTable(String classYear, String classSection){
		try{														
			st = getConnection().createStatement();
			query = createNewTable(classYear + "-" + classSection+"_class", "`student_id` varchar(30) NOT NULL PRIMARY KEY, "	
					+ "`student_name` varchar(30), `student_address` varchar(255), `student_contact_number` varchar(30), "		
					+ "`student_gender` varchar(10), `major_exam_midterm` varchar(5), `major_exam_finals` varchar(5), "			
					+ "`minor_exam_quiz_1` varchar(5), `minor_exam_quiz_2` varchar(5), `minor_exam_quiz_3` varchar(5), "			
					+ "`minor_exam_quiz_4` varchar(5), `project_midterm` varchar(5), `project_finals` varchar(5)");
			st.execute(query);			
		} catch(Exception e){																																		
			setMessage("error creating new class table: " + e);																								
			return;																																						
		}																																									
	}		
	
	public void delete(String[] conditionValues, String type){
		String tableName = "";
		String field = "";
		
		switch(type){
			case "classes":
				tableName = "list_of_classes";
				field = "class_year_and_section";
				break;
			case "students":
				tableName = getClassInfo()+"_class";
				field = "student_id";
				break;
		}
		
		try{
			st = getConnection().createStatement();
			
			for(int i = 0; i<conditionValues.length; i++){
				query = deleteFromField(tableName, field, conditionValues[i]);
				st.execute(query);
				
				if(type.equals("classes")){
					query = dropTable(conditionValues[i]+"_class");
					st.execute(query);
				}
			}
		} catch(Exception e){
			setMessage("error deleting " + type + " " + e);
			return;
		}
	}
	
	public void setStudentsName(){
		try{
			st = getConnection().createStatement();
			query = selectFields("student_name", getClassInfo()+"_class", "`student_id`='"+getStudent()+"'");
			rs = st.executeQuery(query);
			
			while(rs.next())
				this.studentName = rs.getString("student_name");
			
		} catch(Exception e){
			setMessage("error setting student name: " + e);
			return;
		}
	}
	
	public String getStudentsName(){
		return this.studentName;
	}
	
	public void updateGradeSheet(String quiz1, String quiz2, String midtermExam, String midtermProject, String quiz3, String quiz4, String finalExam, String finalProject){		
		try{																																																				
			st = getConnection().createStatement();			
			query = updateFields(getClassInfo()+"_class", "`minor_exam_quiz_1`='"+quiz1+"', `minor_exam_quiz_2`='"+quiz2+"',"										
					+ " `major_exam_midterm`='"+midtermExam+"', `project_midterm`='"+midtermProject+"', `minor_exam_quiz_3`='"+quiz3+"',"							
					+ " `minor_exam_quiz_4`='"+quiz4+"', `major_exam_finals`='"+finalExam+"', `project_finals`='"+finalProject+"'", "`student_id`='"+getStudent()+"'");																							
			
			st.execute(query);			
		} catch(Exception e){																																														
			setMessage("error updating grades: " + e);																																						
			return;																																																		
		}																																																					
	}	
	
	public int getRow(String type){
		int rowCount = 0;
		String tableName = type.equals("classes") ? "list_of_classes" : getClassInfo()+"_class";
		String field = type.equals("classes") ? "class_year_and_section" : "student_id";
		
		try{
			st = getConnection().createStatement();
			query = selectFields(field, tableName, "1");
			System.out.println(query);
			rs = st.executeQuery(query);
			
			while(rs.next()){
				rowCount++;
			}
			
			return rowCount;
		} catch(Exception e){
			setMessage("error setting row count " + e);
			return 0;
		}
	}
}
