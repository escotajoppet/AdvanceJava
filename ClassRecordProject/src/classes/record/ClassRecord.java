package classes.record;

import java.sql.*;
import java.util.ArrayList;

public class ClassRecord {
	
	//identifiers for database connection///
	private Connection dbCon = null;  //
	private Statement st = null;       	//
	private ResultSet rs = null;		  	//
	private String query = "";			  	//
	//////////////////////////////////////////
	
	//identifiers for classes///////////////////////////////////////////////////////////
	private ArrayList<String> classes = new ArrayList<String>();				  //
	private ArrayList<String> numberOfStudents = new ArrayList<String>();//
	private ArrayList<String> classSchedule = new ArrayList<String>();		  //
	///////////////////////////////////////////////////////////////////////////////////
	
	//identifiers for students/////////////////////////////////////////////////////////////
	private ArrayList<String> studentId = new ArrayList<String>();			  	  //
	private ArrayList<String> studentName = new ArrayList<String>();		 	  //
	private ArrayList<String> studentAddress = new ArrayList<String>();	  	  //
	private ArrayList<String> studentGender = new ArrayList<String>();	 	  //
	private ArrayList<String> studentContact = new ArrayList<String>();	  	  //
	
	private String classSection = "";														  	  //
	///////////////////////////////////////////////////////////////////////////////////////

	//identifiers for grades////////////////////////
	private String minorExamQuiz1 = "";		//
	private String minorExamQuiz2 = "";		//
	private String minorExamQuiz3 = "";		//
	private String minorExamQuiz4 = "";		//
	private String majorExamMidterm = "";	//
	private String majorExamFinal = "";		//
	private String projectMidterm = "";			//
	private String projectFinal = "";				//
	
	private String id = "";							//
	////////////////////////////////////////////////
	
	//identifier for the message/////////
	private String message = "";		//
	//////////////////////////////////////
	
	//identifier for getting the student name for header//
	private String nameOfStudent = "";				  //
	/////////////////////////////////////////////////////////
	
	//identifier for setting the full name//
	private String fullName = "";		 //
	///////////////////////////////////////
	
	
	
	//connecting to database//////////////////////////////////////////////////////////////////////////////////////////////////////
	public ClassRecord(){																														   	 //
		try{																																				 //
			Class.forName("com.mysql.jdbc.Driver").newInstance();																		 //
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/classrecordproject", "root", "password");  //
			dbCon.setAutoCommit(false);																										 //
											
			System.out.println("connection established!");																						 //
		} catch(Exception e){																														 //
			setMessage("error connecting to database: " + e);																				 //
		}																																					 //
	}																																						 //
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	//setting and getting the section of the class///////////
	public void setClassSection(String classSection){	//
		this.classSection = classSection;						//
	}																	//
	
	public String getClassSection(){							//
		return this.classSection;								//
	}																	//
	//////////////////////////////////////////////////////////
	
	
	
	//setting and getting the student//////
	public void setStudent(String id){ 	//
		this.id = id;								//
	}												//
													//
	public String getStudent(){			//
		return this.id;						//
	}												//
	//////////////////////////////////////////
	
	
	
	//setting and getting the class information in arraylist////////////////////////////////////////////////////
	public void setClass(){																									//
		try{																														//													   	
			st = dbCon.createStatement();																				//								   	
			query = "SELECT `class_year_and_section`, `class_schedule` FROM `list_of_classes`";   	//									
			rs = st.executeQuery(query);																					//								 	
			
			while(rs.next()){																									//								   	
				classes.add(rs.getString("class_year_and_section"));												//
				classSchedule.add(rs.getString("class_schedule"));													//								   	
			}																														//								   	
			
		} catch(Exception e){																								//								   		
			setMessage("error setting classes: " + e);																	//						   		   	
			return;																												//								   	
		}																															//								   	
	}																																//								   	
	
	public void setNumberOfStudents(){																				//
		int rowCount = 0;																									//
		
		try{																														//											
			st = dbCon.createStatement();																				//
				
			for(int i = 0; i<getClasses().size(); i++){																	//
				rowCount = 0;																									//
				
				query = "SELECT 'student_id' FROM `"+getClasses().get(i)+"_class`";						//
				rs = st.executeQuery(query);																				//
				
				while(rs.next()){																								//
					rowCount++;																								//
				}																													//
				
				numberOfStudents.add(Integer.toString(rowCount));												//
			}																														//
			
		} catch(Exception e){																								//
			setMessage("error setting number of students in class: " + e);										//
			return;																												//
		}																															//
	}																																//
	
	public ArrayList<String> getClasses(){																				//
		return this.classes;																									//
	}																																//
	
	public ArrayList<String> getNumberOfStudents(){																//
		return this.numberOfStudents;																					//
	}																																//
	
	public ArrayList<String> getClassSchedule(){																		//
		return this.classSchedule;																							//
	}																																//																																									   //
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	//setting and getting the student information in arraylist////////////////////////////////////////////////////////
	public void setStudents(){																									//											
		try{																																//
			st = dbCon.createStatement();																						//
			query = "SELECT `student_id`, `student_name`, `student_address`,"
					+ " `student_gender`, `student_contact_number` FROM `"+getClassSection()+"_class`";	//
			rs = st.executeQuery(query);																							//
																																			
			while(rs.next()){																											//
				studentId.add(rs.getString("student_id"));																		//
				studentName.add(rs.getString("student_name"));															//
				studentAddress.add(rs.getString("student_address"));														//
				studentGender.add(rs.getString("student_gender"));														//
				studentContact.add(rs.getString("student_contact_number"));											//
			}																																//
			
		} catch(Exception e){																										//
			setMessage("error setting students:  " + e);																		//
			return;																														//
		}																																	//
	}																																		//
	
	public ArrayList<String> getStudentId(){																					//
		return this.studentId;																										//
	}																																		//
	
	public ArrayList<String> getStudentName(){																				//
		return this.studentName;																									//
	}																																		//
	
	public ArrayList<String> getStudentAddress(){																			//
		return this.studentAddress;																								//
	}																																		//
	
	public ArrayList<String> getStudentGender(){																			//
		return this.studentGender;																								//
	}																																		//
	
	public ArrayList<String> getStudentContact(){																			//
		return this.studentContact;																								//
	}																																		//
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	//setting and getting the student information in arraylist////////////////////////////////////////////////////////////////////////////
	public void setGrades(){																																//																																																		
		try{																																						//
			st = dbCon.createStatement();																												//																																																					
			query = "SELECT `minor_exam_quiz_1`, `minor_exam_quiz_2`, `major_exam_midterm`, `project_midterm`, "	//
					+ "`minor_exam_quiz_3`, `minor_exam_quiz_4`, `major_exam_finals`, `project_finals` FROM "				//
					+ "`"+getClassSection()+"_class` WHERE `student_id`='"+getStudent()+"'";											//
			rs = st.executeQuery(query);																													//
			
			while(rs.next()){																																	//
				minorExamQuiz1 = rs.getString("minor_exam_quiz_1");																			//
				minorExamQuiz2 = rs.getString("minor_exam_quiz_2");																			//
				majorExamMidterm = rs.getString("major_exam_midterm");																		//
				projectMidterm = rs.getString("project_midterm");																					//
				minorExamQuiz3 = rs.getString("minor_exam_quiz_3");																			//
				minorExamQuiz4 = rs.getString("minor_exam_quiz_4");																			//
				majorExamFinal = rs.getString("major_exam_finals");																				//
				projectFinal = rs.getString("project_finals");																							//
			}																																						//
															
		} catch(Exception e){																																//
			setMessage("error setting grades: " + e);																									//
			return;																																				//
		}																																							//
	}																																								//
	
	public String getQuiz1(){																																//
		return this.minorExamQuiz1;																														//
	}																																								//
																
	public String getQuiz2(){																																//
		return this.minorExamQuiz2;																														//
	}																																								//
		
	public String getQuiz3(){																																//
		return this.minorExamQuiz3;																														//
	}																																								//
	
	public String getQuiz4(){																																//
		return this.minorExamQuiz4;																														//
	}																																								//
		
	public String getMidtermExam(){																													//
		return this.majorExamMidterm;																													//
	}																																								//
				
	public String getFinalExam(){																															//
		return this.majorExamFinal;																														//
	}																																								//
	
	public String getMidtermProject(){																													//
		return this.projectMidterm;																														//
	}																																								//
	
	public String getFinalProject(){																														//
		return this.projectFinal;																															//
	}																																								//
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	// getting the schedule of the faculty in his class dynamically//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getScheduleOfNewClass(String[] days, String[] fromTime0, String[] fromTime1, String[] from, String[] toTime0, String[] toTime1, String[] to){	//
		StringBuilder sb = new StringBuilder();																																							//
		
		for(int i = 0; i<days.length; i++){																																								//
			if(i>0){																																																//
				sb.append("/ ");																																												//
			}																																																		//
			
			sb.append(days[i] + " " + fromTime0[i]+":"+fromTime1[i]+from[i] + " - " + toTime0[i]+":"+toTime1[i]+to[i]);														//
		}																																																			//
		
		return sb.toString();																																													//
	}																																																				//
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	//adding new class on the list///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void addNewClass(String classYear, String classSection, String schedule){																//		
		if(classYear.equals("") || classSection.equals("")){																									//
			setMessage("error adding new class: please indicate the class year and section!");														//
			return;																																						//
		}																																									//
		
		String newClass = classYear + "-" + classSection;																									//
			
		try{																																								//
			st = dbCon.createStatement();																														//
			query = "INSERT INTO `list_of_classes` (`class_year_and_section`, `class_number_of_students`, `class_schedule`) "	//
					+ "VALUES('"+newClass+"', '0', '"+schedule+"')";																						//
			st.execute(query);																																		//
			
			createNewClassTable(newClass);																														//
			
			dbCon.commit();																																			//
				
		} catch(Exception e){																																		//
			setMessage("error adding new class: " + e);																										//
			return;																																						//
		}																																									//
	}																																										//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//removing class from the list//////////////////////////////////////////////////////////////////////////////////////////
	public void deleteClass(String[] classSection){																					//						
		try{																																		//
			st = dbCon.createStatement();																								//
						
			for(int i = 0; i<classSection.length; i++){																					//
				query = "DROP TABLE `"+classSection[i]+"_class`";																//
				st.execute(query);																											//
				
				query = "DELETE FROM `list_of_classes` WHERE `class_year_and_section`='"+classSection[i]+"'";	//
				st.execute(query);																											//
			}																																		//
			
			dbCon.commit();																													//
			
		} catch(Exception e){																												//
			setMessage("error deleting class: " + e);																					//
			return;																																//
		}																																			//
	}																																				//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//creating table for new class in database/////////////////////////////////////////////////////////////////////////////////////////////////
	public void createNewClassTable(String newClass){																									//
		try{																																								//
			st = dbCon.createStatement();																														//
			query = "CREATE TABLE IF NOT EXISTS `"+newClass+"_class` (`student_id` varchar(30) NOT NULL PRIMARY KEY, "	//
					+ "`student_name` varchar(30), `student_address` varchar(255), `student_contact_number` varchar(30), "		//
					+ "`student_gender` varchar(10), `major_exam_midterm` varchar(5), `major_exam_finals` varchar(5), "			//
					+ "`minor_exam_quiz_1` varchar(5), `minor_exam_quiz_2` varchar(5), `minor_exam_quiz_3` varchar(5), "			//
					+ "`minor_exam_quiz_4` varchar(5), `project_midterm` varchar(5), `project_finals` varchar(5))";						//
			st.execute(query);																																		//
			
		} catch(Exception e){																																		//
			setMessage("error creating new class table: " + e);																								//
			return;																																						//
		}																																									//
	}																																										//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	//adding new student on the class list//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void addNewStudent(String studentId, String studentName, String studentAddress, String studentContactNumber, String studentGender){	//		
		try{																																														//
			st = dbCon.createStatement();																																				//
			query = "INSERT INTO `"+getClassSection()+"_class` (`student_id`, `student_name`,"																	//
					+ " `student_address`, `student_contact_number`, `student_gender`, `major_exam_midterm`,"												//
					+ " `major_exam_finals`, `minor_exam_quiz_1`, `minor_exam_quiz_2`, `minor_exam_quiz_3`,"												//
					+ " `minor_exam_quiz_4`, `project_midterm`, `project_finals`) "																							//
					+ " VALUES('"+studentId+"', '"+studentName+"', '"+studentAddress+"'"																				//
					+ ", '"+studentContactNumber+"', '"+studentGender+"', '', '', '', '', '', '', '', '')";																			//
			st.execute(query);																																								//
			
			dbCon.commit();																																									//
				
		} catch(Exception e){																																								//
			setMessage("error adding new student: " + e);																															//
			return;																																												//
		}																																															//
	}																																																//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//removing students from the class list////////////////////////////////////////////////////////////////////////////////
	public void deleteStudent(String[] studentId){																					//
		try{																																		//
			st = dbCon.createStatement();																								//
			for(int i = 0; i<studentId.length; i++){																					//
				query = "DELETE FROM `"+getClassSection()+"_class`WHERE `student_id`='"+studentId[i]+"'";	//
				st.execute(query);																											//
			}																																		//
			
			dbCon.commit();																													//
			
		} catch(Exception e){																												//
			setMessage("error deleting student: " + e);																				//
			return;																																//
		}																																			//
	}																																				//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	//updating the grade sheet of a student///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void updateGradeSheet(String quiz1, String quiz2, String midtermExam, String midtermProject, String quiz3, String quiz4, String finalExam, String finalProject){	//	
		try{																																																				//
			st = dbCon.createStatement();																																										//
			query = "UPDATE `"+getClassSection()+"_class` SET `minor_exam_quiz_1`='"+quiz1+"', `minor_exam_quiz_2`='"+quiz2+"',"										//
					+ " `major_exam_midterm`='"+midtermExam+"', `project_midterm`='"+midtermProject+"', `minor_exam_quiz_3`='"+quiz3+"',"							//
					+ " `minor_exam_quiz_4`='"+quiz4+"', `major_exam_finals`='"+finalExam+"', `project_finals`='"+finalProject+"'"													//
					+ " WHERE `student_id`='"+getStudent()+"'";																																			//
			
			st.execute(query);																																														//
			
			dbCon.commit();																																															//
			
		} catch(Exception e){																																														//
			setMessage("error updating grades: " + e);																																						//
			return;																																																		//
		}																																																					//
	}																																																						//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	//getting the number of classes in the list///////////////////////////////////////////
	public int getClassRow(){																	//
		int rowCount = 0;																		//
		
		try{																							//
			st = dbCon.createStatement();													//
			query = "SELECT `class_year_and_section` FROM `list_of_classes`";	//
			rs = st.executeQuery(query);														//
			
			while(rs.next()){																		//
				rowCount++;																		//
			}																							//
			
			return rowCount;																		//
		} catch(Exception e){																	//
			setMessage("error getting row count of class: " + e);						//
			return 0;																				//
		}																								//
	}																									//
	/////////////////////////////////////////////////////////////////////////////////////
	
	
	
	//getting the number of students in the list///////////////////////////////////////////
	public int getStudentRow(){																	//
		int rowCount = 0;																			//
			
		try{																								//
			st = dbCon.createStatement();														//
			query = "SELECT `student_id` FROM `"+getClassSection()+"_class`";	//
			rs = st.executeQuery(query);															//
			
			while(rs.next()){																			//
				rowCount++;																			//
			}																								//
			
			return rowCount;																			//
			
		} catch(Exception e){																		//
			setMessage("error getting row count of student: " + e);						//
			return 0;																					//
		}																									//
	}																										//
	////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	//setting the message for display////////////////
	public void setMessage(String message){	//
		this.message = message;						//
	}															//
	////////////////////////////////////////////////////
	
	//getting the message for display///
	public String getMessage(){		//
		return this.message;			//
	}											//
	///////////////////////////////////////
	
	
	
	//setting the name of student for header///////////////////////////////////////////////
	public void setNameOfStudent(String studentId){											//
		try{																									//
			st = dbCon.createStatement();															//
			query = "SELECT `student_name` FROM `"+getClassSection()+"_class` "	//
					+ "WHERE `student_id`='"+studentId+"'";									//
			rs = st.executeQuery(query);																//
			
			while(rs.next()){																				//
				nameOfStudent = rs.getString("student_name");								//
			}																									//
			
		} catch(Exception e){																			//
			setMessage("error setting name of student: " + e);									//
			return;																							//
		}																										//
	}																											//
	////////////////////////////////////////////////////////////////////////////////////////////
	
	//getting the name of student for header////
	public String getNameOfStudent(){			//
		return this.nameOfStudent;				//
	}														//
	////////////////////////////////////////////////
	
	
	
	//setting the full name of the student, and filtering the forms of adding new student to the class list////////////////////////////////////////////////////////////////
	public void setFullName(String lastName, String firstName, String middleName, String studentId, String studentAddress, String studentContactNumber){	//
		lastName = lastName.trim();																																									//
		firstName = firstName.trim();																																									//
		middleName = middleName.trim();																																							//
		
		studentId = studentId.trim();																																									//
		studentAddress = studentAddress.trim();																																					//
		studentContactNumber = studentContactNumber.trim();																																//
		
		if(studentId.equals("")){																																										//
			setMessage("error adding new student: please indicate your student id");																										//
			return;																																															//
		} else if(lastName.equals("") || firstName.equals("") || middleName.equals("")){																								//
			setMessage("error setting full name of student: please indicate your last, first, and middle name");																	//
			return;																																															//
		} else if(studentAddress.equals("")){																																						//
			setMessage("error adding new student: please indicate your current address");																								//
			return;																																															//
		} else if(studentContactNumber.equals("")){																																				//
			setMessage("error adding new student: please indicate your contact details");																								//
			return;																																															//
		}																																																		//
			
		lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);																									//
		firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);																								//
		middleName = middleName.substring(0, 1).toUpperCase() + middleName.substring(1);																						//
			
		this.fullName = lastName + ", " + firstName + " " + middleName;																												//
	}																																																			//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//getting the full name of the student//
	public String getFullName(){			//
		return this.fullName;				//
	}												//
	//////////////////////////////////////////
	
	
	
	//clear all arraylists///////////////////	
	public void clearLists(){			//
		studentId.clear();					//
		studentName.clear();			//
		studentAddress.clear();			//
		studentGender.clear();			//
		studentContact.clear();			//
		numberOfStudents.clear();		//
		classes.clear();						//																													   
		classSchedule.clear();			//																												   
	}											//
	///////////////////////////////////////
}
