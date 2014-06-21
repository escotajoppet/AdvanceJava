package classrecord.table.data;

import database.connection.SQLStringQueries;

public abstract class Displays extends SQLStringQueries{

	private String fullName = "";
	private String classInfo = "";
	private String message = "";
	private String studentId = "";
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void setClassInfo(String classInfo){
		this.classInfo = classInfo;
	}
	
	public String getClassInfo(){
		return this.classInfo;
	}		
	
	public void setFullName(String lastName, String firstName, String middleName, String studentId, String studentAddress, String studentContactNumber){	
		lastName = lastName.trim();																																									
		firstName = firstName.trim();																																									
		middleName = middleName.trim();																																							
		
		studentId = studentId.trim();																																									
		studentAddress = studentAddress.trim();																																					
		studentContactNumber = studentContactNumber.trim();																																
		
		if(studentId.equals("")){																																										
			setMessage("error adding new student: please indicate your student id");																										
			return;																																															
		} else if(lastName.equals("") || firstName.equals("") || middleName.equals("")){																								
			setMessage("error setting full name of student: please indicate your last, first, and middle name");																	
			return;																																															
		} else if(studentAddress.equals("")){																																						
			setMessage("error adding new student: please indicate your current address");																								
			return;																																															
		} else if(studentContactNumber.equals("")){																																				
			setMessage("error adding new student: please indicate your contact details");																								
			return;																																															
		}																																																		
			
		lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);																									
		firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);																								
		middleName = middleName.substring(0, 1).toUpperCase() + middleName.substring(1);																						
			
		this.fullName = lastName + ", " + firstName + " " + middleName;
	}	
	
	public String getFullName(){
		return this.fullName;
	}
	
	public void setStudent(String studentId){
		this.studentId = studentId;
	}
	
	public String getStudent(){
		return this.studentId;
	}
}
