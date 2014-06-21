<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/main.css" />
<title>Class Record Project: Add New Student</title>
</head>

<jsp:useBean id="classrecord" class="classes.record.ClassRecord" scope="session"/>

<%
	String message = "";

	String studentId = request.getParameter("studentid");
	String lastName = request.getParameter("lastname");
	String firstName = request.getParameter("firstname");
	String middleName = request.getParameter("middlename");
	String address = request.getParameter("address");
	String contact = request.getParameter("contact");
	String gender = request.getParameter("gender");
	
	String addNewStudent = request.getParameter("addstudent");
	String backToClassList = request.getParameter("backtoclasslist");
	
	if(addNewStudent!=null){
		classrecord.setFullName(lastName, firstName, middleName, studentId, address, contact);
		
		message = classrecord.getMessage();
		
		if (message.equals("")){
			classrecord.addNewStudent(studentId, classrecord.getFullName(), address, contact, gender);
			classrecord.clearLists();
			
			message = classrecord.getMessage();
		
			%><jsp:forward page="StudentList"/><%
		}
	} else if(backToClassList!=null){
		classrecord.clearLists();
		%><jsp:forward page="StudentList"/><%
	}
%>

<body>
	<center>
		<div class="panel panel-info adding">
			<div class="panel-heading">
				<h4>Add New Student</h4>
			</div>
			
			<div class="panel-body">
				<form action="AddNewStudent">
					<input type="text" name="studentid" placeholder="Student ID" class="form-control"/><br />
					<input type="text" name="lastname" placeholder="Last Name" class="form-control" id="lastname"/>
					<input type="text" name="firstname" placeholder="First Name" class="form-control" id="firstname"/>
					<input type="text" name="middlename" placeholder="Middle Name" class="form-control" id="middlename"/><br />
					<input type="text" name="address" placeholder="Address" class="form-control"/><br />
					<input type="text" name="contact" placeholder="Contact Details" class="form-control"/><br />
					
					<label class="radio-inline">
						<input type="radio" name="gender" value="Male" id="male" CHECKED/> Male
					</label>
					
					<label class="radio-inline">
						<input type="radio" name="gender" value="Female"/> Female
					</label>
					
					<br /><hr />
					
					<input type="submit" name="addstudent" value="Add New Student" class="btn btn-primary"/>
					<input type="submit" name="backtoclasslist" value="Back to Class List" class="btn btn-info"/>
				</form>
				
				<br />
				
				<%if(!message.equals("")){%>
					<div class="alert alert-danger">
						<%=message %>
					</div>		
				<%
						classrecord.setMessage("");
					}
				%>
			</div>
		</div>
	</center>
</body>
</html>