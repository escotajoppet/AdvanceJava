package classes.record;

import database.connection.*;

import java.sql.*;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClassRecordManager extends SQLStringQueries{
	ConnectToDb objDb = new ConnectToDb();
	
	ResultSet rs = null;
	Statement st = null;
	
	String query = "";
	String message = "";
	
	String newSchedule = "";
	
	public Connection getConnection(){
		return objDb.getConnection();
	}
	
	public boolean login(String type, String id, String password){
		String tableName = "";
		String fields = "";
		String condition = "";
		
		tableName = type.equals("faculty") ? "tbl_faculty" : "tbl_administrator";
		fields = type.equals("faculty") ? "`faculty_id`, `faculty_name`, `faculty_status`, `faculty_password`" : "`admin_id`, `admin_password`"; 
		condition = "1";
		
		try{
			st = getConnection().createStatement();
			query = selectFields(fields, tableName, condition);
			rs = st.executeQuery(query);
			
			while(rs.next()){
				if(type.equals("faculty")){
					setAlFacultyId(rs.getString("faculty_id"));
					setAlFacultyName(rs.getString("faculty_name"));
					setAlFacultyStatus(rs.getString("faculty_status"));
					setAlFacultyPassword(rs.getString("faculty_password"));
				}
			}
			
			if(getAlFacultyId().contains(id)){
				if(getAlFacultyPassword().get(getAlFacultyId().indexOf(id)).equals(password)){
					setLoggedId(id);
					setLoggedName(getAlFacultyName().get(getAlFacultyId().indexOf(id)));
					setLoggedStatus(getAlFacultyStatus().get(getAlFacultyId().indexOf(id)));
					return true;
				}
			}
			
			setMessage("error logging in: the information is not in the database");
			return false;
		} catch(Exception e){
			setMessage("error logging in " + e);
			return false;
		}
	}
	
	public void setTable(String type){
		String tableName = "";
		String fields = "";
		String condition = "";
		
		switch(type){
			case "faculty":
				break;
			case "class":
				tableName = "tbl_class";
				fields = "`class_entry_number`, `class_year_and_section`, `class_school_year`, `class_semester`, `class_subject_code`, `class_subject_name`, `class_schedule`";
				condition = "`class_instructor`='"+getLoggedName()+"'";
				break;
			case "student":
				tableName = "tbl_student";
				fields = "`student_entry_number`, `student_subject_code`, `student_id`, `student_name`, `student_year_and_section`";
				condition = "`student_subject_code`='"+getSelectedClassSubjectCode()+"' AND `student_instructor`='"+getLoggedName()+"' AND `student_schedule`='"+getSelectedClassSchedule()+"'";
				break;
			case "grade":
				tableName = "tbl_grade";
				fields = "*";
				condition = "`grade_subject_code`='"+getGradeSelectedSubjectCode()+"' AND `grade_student_id`='"+getGradeSelectedStudentId()+"'";
				break;
			default:	
				break;
		}
		
		try{
			st = getConnection().createStatement();
			query = selectFields(fields, tableName, condition);
			rs = st.executeQuery(query);
			
			while(rs.next()){
				if(type.equals("class")){
					setClassEntryNumber(rs.getInt("class_entry_number"));
					setClassYearAndSection(rs.getString("class_year_and_section"));
					setClassSchoolYear(rs.getString("class_school_year"));
					setClassSemester(rs.getString("class_semester"));
					setClassSubjectCode(rs.getString("class_subject_code"));
					setClassSubjectName(rs.getString("class_subject_name"));
					setClassSchedule(rs.getString("class_schedule"));
				} else if(type.equals("student")){
					setStudentEntryNumber(rs.getInt("student_entry_number"));
					setStudentId(rs.getString("student_id"));
					setStudentName(rs.getString("student_name"));
					setStudentSubjectCode(rs.getString("student_subject_code"));
					setStudentYearAndSection(rs.getString("student_year_and_section"));
				} else if(type.equals("grade")){
					setGradeFinalExam(rs.getString("grade_final_exam"));
					setGradeFinalProject(rs.getString("grade_final_project"));
					setGradeFinalQuiz3(rs.getString("grade_final_quiz3"));
					setGradeFinalQuiz4(rs.getString("grade_final_quiz4"));
					setGradeMidtermExam(rs.getString("grade_midterm_exam"));
					setGradeMidtermProject(rs.getString("grade_midterm_project"));
					setGradeMidtermQuiz1(rs.getString("grade_midterm_quiz1"));
					setGradeMidtermQuiz2(rs.getString("grade_midterm_quiz2"));
				}
			}
			
		} catch(Exception e){
			setMessage("error setting table " + e);
			return;
		}
	}
	
	public void delete(String type, String id){
		String tableName = "";
		String conditionField = "";
		
		switch(type){
			case "faculty":
				tableName = "tbl_faculty";
				conditionField = "faculty_id";
				break;
			case "class":
				tableName = "tbl_class";
				conditionField = "class_entry_number";
				break;
			case "student":
				tableName = "tbl_student";
				conditionField = "student_entry_number";
				break;
		}
		
		try{
			st = getConnection().createStatement();
			query = deleteFromField(tableName, conditionField, id);
			st.execute(query);
			
		} catch(Exception e){
			setMessage("error deleting " + e);
			return;
		}
	}
	
	public void add(String type, String[] fieldValues){		
		String tableName = "";
		String fields = "";
		String completeName = "";
		String newId = "";
		
		switch(type){
			case "faculty":
				tableName = "tbl_faculty";
				fields = "`faculty_id`, `faculty_name`, `faculty_status`, `faculty_password`";
				completeName = fieldValues[1] + " " + fieldValues[2] + " " + fieldValues[0];
				break;
			case "student":
				tableName = "tbl_student";
				fields = "`student_subject_code`, `student_subject_name`, `student_instructor`, `student_schedule`, `student_id`, `student_name`, `student_year_and_section`" ;
				break;
			case "class":
				tableName = "tbl_class";
				fields = "`class_instructor`, `class_year_and_section`, `class_school_year`, `class_semester`, `class_subject_code`, `class_subject_name`, `class_schedule`";
			default:
				break;
		}
		
		try{
			st = getConnection().createStatement();
			
			if(type.equals("faculty")){
				if(!fieldValues[3].equals(fieldValues[4])){
					setMessage("error registration passwords don't match");
					return;
				}
				
				query = selectFields("`faculty_id`", tableName, "1");
				rs = st.executeQuery(query);
				
				newId = getNewId(type, rs);
				
				query = insertIntoFields(tableName, fields, "'"+newId+"', '"+completeName+"', 'Part-Time', '"+fieldValues[3]+"'");
				st.execute(query);
				
				setMessage("Registration Successful!!!<br /><br /> Your new id: " + newId);
			} else if(type.equals("class")){
				query = insertIntoFields(tableName, fields, "'"+getLoggedName()+"', '"+fieldValues[0]+"', '"+fieldValues[1]+"', '"+fieldValues[2]+"', '"+fieldValues[3]+"', '"+fieldValues[4]+"', '"+getScheduleOfNewClass()+"'");
				st.execute(query);
				
				setMessage("Adding new class successful!");
			} else if(type.equals("student")){
				query = insertIntoFields(tableName, fields, "'"+getSelectedClassSubjectCode()+"', '"+getSelectedClassSubjectName()+"', '"+getLoggedName()+"', '"+getSelectedClassSchedule()+"', '"+fieldValues[0]+"', '"+fieldValues[1]+"', '"+fieldValues[2]+"'");
				st.execute(query);
				
				tableName = "tbl_grade";
				fields = "`grade_subject_code`, `grade_student_id`, `grade_instructor`, `grade_midterm_quiz1`, `grade_midterm_quiz2`, `grade_midterm_exam`, `grade_midterm_project`, `grade_final_quiz3`, `grade_final_quiz4`, `grade_final_exam`, `grade_final_project`";
				
				query = insertIntoFields(tableName, fields, "'"+getSelectedClassSubjectCode()+"', '"+fieldValues[0]+"', '"+getLoggedName()+"', '', '', '', '', '', '', '', ''");
				st.execute(query);
				
				setMessage("Adding new student successful!");
			}
		} catch(Exception e){
			setMessage("error adding " + e);
			return;
		}
	}
	
	public String getNewId(String type, ResultSet newRS){
		GregorianCalendar gc = new GregorianCalendar();
		
		String id = "";
		String newId = "";
		int idNum = 0;
		
		try{
			if(type.equals("faculty")){
				while(newRS.next()){
					if(newRS.last()){
						idNum = Integer.parseInt(newRS.getString("faculty_id").substring(5, 10)) + 1;
						id = getId(Integer.toString(idNum));
						
						newId = Integer.toString(gc.get(gc.YEAR)) + "-" + id + "-MN-0";
						
						return newId;
					}
				}
			}

			return "";
		} catch(Exception e){
			setMessage("error getting new id " + e);
			return "";
		}
	}
	
	public String getId(String newId){
		String id = "";
		
		switch(newId.length()){
		case 1:
			id = "0000" + newId;
			break;
		case 2:
			id = "000" + newId;
			break;
		case 3:
			id = "00" + newId;
			break;
		case 4:
			id = "0" + newId;
			break;
		}
		
		return id;
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
	
	public void update(String[] grades){
		String[] gradeFields = {"grade_midterm_quiz1", "grade_midterm_quiz2", "grade_midterm_exam", "grade_midterm_project", "grade_final_quiz3" , "grade_final_quiz4", "grade_final_exam", "grade_final_project"};
		String tableName = "tbl_grade";		
		String condition = "`grade_subject_code`='"+getGradeSelectedSubjectCode()+"' AND `grade_student_id`='"+getGradeSelectedStudentId()+"'";
		
		try{
			st = getConnection().createStatement();
			
			for(int i = 0; i<grades.length; i++){
				query = updateField(tableName, gradeFields[i], grades[i], condition);
				st.execute(query);
			}
			
		} catch(Exception e){
			setMessage("error updating " + e);
			return;
		}
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
