<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
</head>

<jsp:useBean id="classRecord" class="classes.record.ClassRecordManager" scope="session"/>

<%
	if(session.getAttribute("id")==null || classRecord.getLoggedId().equals("")){
		session.invalidate();
		request.getRequestDispatcher("/login_page.jsp").forward(request, response);
	}

	String btn = request.getParameter("btn");

	String studentId = request.getParameter("studentid");
	String lastName = request.getParameter("lastname");
	String firstName = request.getParameter("firstname");
	String middleName = request.getParameter("middlename");
	String studentYear = request.getParameter("studentyear");
	String studentSection = request.getParameter("studentsection");
	
	if(btn!=null && btn.equals("addstudent")){
		String[] fieldValues = {studentId, firstName + " " + middleName + " " + lastName, studentYear + "-" + studentSection};
		classRecord.add("student", fieldValues);
	}
%>

<body>
	<center>
		<h1>Class Record</h1>
		<h3>Add New Student</h3>
		
		<form action="ClassController" method="post">
			Student ID: <input type="text" name="studentid"/><br /><br /><br />
		
			Last Name: <input type="text" name="lastname"/><br /><br />
			First Name: <input type="text" name="firstname"/><br /><br />
			Middle Name: <input type="text" name="middlename"/><br /><br /><br />
			
			<select name="studentyear" id="">
				<option value="">Student Year...</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
			
			<span> - </span>
			
			<select name="studentsection" id="">
				<option value="">Student Section...</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
			
			<br /><br />
			
			<button type="submit" name="btn" value="addstudent">Add Student</button>			
		</form>
		
		<br />
		
		<form action="ClassController" method="post">
			<button type="submit" name="btn" value="backtostudentlist">Back</button>
		</form>
		
		<br /><br />
		
		<%=classRecord.getMessage() %>
		<%classRecord.setMessage(""); %>
	</center>
</body>
</html>