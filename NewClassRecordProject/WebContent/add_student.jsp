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

<jsp:useBean id="classRecord" class="classes.record.NewClassRecord" scope="session"/>

<%
	String message = "";
	String btn = request.getParameter("btn");

	String studentId = request.getParameter("studentid");
	String lastName = request.getParameter("lastname");
	String firstName = request.getParameter("firstname");
	String middleName = request.getParameter("middlename");
	String address = request.getParameter("address");
	String contact = request.getParameter("contact");
	String gender = request.getParameter("gender");
	
	if(btn!=null && btn.equals("addstudent")){
		classRecord.setFullName(lastName, firstName, middleName, studentId, address, contact);
		String[] values = {studentId, address, contact, gender};

		message = classRecord.getMessage();
		
		if(message.equals("")){
			out.println(classRecord.getFullName());
			classRecord.add(values, "students");
			request.getRequestDispatcher("/StudentList").forward(request, response);
		}
	}
%>

<body>
	<center>
		<div class="panel panel-info adding">
			<div class="panel-heading">
				<h4>Add New Student</h4>
			</div>
			
			<div class="panel-body">
				<form action="MainPageController">
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
					
					<button type="submit" name="btn" value="addstudent" class="btn btn-primary">Add New Student</button>
					<button type="submit" name="btn" value="backtostudentlist" class="btn btn-info">Back to Student List</button>
				</form>
				
				<br />
				
				<%if(!message.equals("")){%>
					<div class="alert alert-danger">
						<%=message %>
					</div>		
				<%
						classRecord.setMessage("");
					}
				%>
			</div>
		</div>
	</center>
</body>
</html>