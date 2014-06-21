<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="loanSystem" class="loan.system.LoanSystem" scope="session"/>

<%
	String firstName = request.getParameter("firstname");
	String lastName = request.getParameter("lastname");
	String gender = request.getParameter("gender");
	String age = request.getParameter("age");
	String address = request.getParameter("address");
	String emailAddress = request.getParameter("emailaddress");
	String mobileNumber = request.getParameter("mobile");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String retypePass = request.getParameter("retypepassword");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("registeruser")){
		loanSystem.registerUser(firstName, lastName, gender, age, address, emailAddress, mobileNumber,  username);
	}
%>

<body>
	<center>
		<h1>Funeral Plan</h1>
		<h3>Sign Up</h3>
		
		<form action="Controller">
			Last Name: <input type="text" name="lastname" REQUIRED/><br />
			First Name: <input type="text" name="firstname" REQUIRED/><br />
			Gender: <label for=""><input type="radio" name="gender" value=Male CHECKED/>Male</label>
			<label for=""><input type="radio" name="gender" value="Female"/>Female</label><br />	
			Age: <input type="text" name="age" REQUIRED/><br />
			Address: <input type="text" name="address" REQUIRED/><br />
			Email Address: <input type="text" name="emailaddress" REQUIRED/><br />
			Mobile Number: <input type="text" name="mobile" REQUIRED/><br />
			Username: <input type="text" name="username" REQUIRED/><br /><br />
			
			
			<button type="submit" name="btn" value="registeruser">Sign Up</button>
		</form>
		
		<form action="Controller">
			<button type="submit" name="btn" value="backtologin">Back to Login Page</button>
		</form>
		
		<br /><br />
		
		<%=loanSystem.getMessage() %>
		<%loanSystem.setMessage(""); %>
	</center>
</body>
</html>