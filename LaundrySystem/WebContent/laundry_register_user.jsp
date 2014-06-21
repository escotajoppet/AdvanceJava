<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="laundrySystem" class="laundry.system.LaundrySystem" scope="session"/>

<%
	String lastName = request.getParameter("lastname");
	String firstName = request.getParameter("firstname");
	String address = request.getParameter("address");
	String contactNo = request.getParameter("contactno");
	String emailAdd = request.getParameter("emailaddress");
	String password = request.getParameter("password");
	String confirmPassword = request.getParameter("confirmpassword");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("registeruser")){
		laundrySystem.registerNewMember(lastName, firstName, address, contactNo, emailAdd, password, confirmPassword);
	}
%>

<body>
	<center>
		<h2>Secure Order Form</h2>
		<form action="PageController">
			Last Name: <input type="text" name="lastname" REQUIRED/><br />
			First Name: <input type="text" name="firstname" REQUIRED/><br />
			Address: <input type="text" name="address" REQUIRED/><br />
			Contact No.: <input type="text" name="contactno" REQUIRED/><br />
			Email Address: <input type="text" name="emailaddress" REQUIRED/><br />
			Password: <input type="password" name="password" REQUIRED/><br />
			Retype Password: <input type="password" name="confirmpassword" REQUIRED/><br /><br />
			
			<button type="submit" value="registeruser" name="btn">Register New User</button>
			<input type="reset" value="Reset Fields"/><br /><br />
			
			<%=laundrySystem.getMessage() %>
			<%laundrySystem.setMessage(""); %>
			
			<br /><br />
		</form>
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtologinuser">Back to Login Page</button>
		</form>
	</center>
</body>
</html>