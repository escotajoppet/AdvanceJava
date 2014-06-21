<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>

<jsp:useBean id="classRecord" class="classes.record.ClassRecordManager" scope="session"/>

<%
	String btn = request.getParameter("btn");
	
	String lastName = request.getParameter("facultylastname");
	String firstName = request.getParameter("facultyfirstname");
	String middleName = request.getParameter("facultymiddlename");
	String password = request.getParameter("facultypassword");
	String retypePassword = request.getParameter("facultyretypepassword");

	String[] fieldValues = {lastName, firstName, middleName, password, retypePassword};
	
	if(btn!=null && btn.equals("register")){
		classRecord.add("faculty", fieldValues);
	}
%>

<body>
	<center>
		<h1>Class Record</h1>
		<h3>Faculty Registration</h3>
		
		<form action="ClassController" method="post">
			Last Name: <input type="text" name="facultylastname" REQUIRED/><br />
			First Name: <input type="text" name="facultyfirstname" REQUIRED/><br />
			Middle Name: <input type="text" name="facultymiddlename"/><br />
			Password: <input type="password" name="facultypassword" REQUIRED/><br />
			Retype Password: <input type="password" name="facultyretypepassword" REQUIRED/><br /><br />
			
			<button type="submit" name="btn" value="register">Submit!</button>			
		</form>
		
		<br />
		
		<form action="ClassController" method="post">
			<button type="submit" name="btn" value="backtologin">Back To Login Page</button>
		</form>
		
		<br /><br />
		
		<%=classRecord.getMessage() %>
		<%classRecord.setMessage(""); %>
	</center>
</body>
</html>