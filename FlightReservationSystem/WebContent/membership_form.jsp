<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="flightReservation" class="flight.reservation.FlightReservation" scope="session"/>

<%
	String firstName = request.getParameter("firstname");
	String lastName = request.getParameter("lastname");
	String address = request.getParameter("address");
	String mobile = request.getParameter("mobile");
	String emailAdd = request.getParameter("emailadd");
	String password = request.getParameter("password");
	String retypePass = request.getParameter("retypepassword");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("registeruser")){
		String fullName = lastName + ", " + firstName;
		flightReservation.registerUser(fullName, address, mobile, emailAdd, password, retypePass);
	}
%>

<body>
	<center>
		<h1>Z-Airlines</h1>
		<h3>Membership Form</h3>
		
		<form action="PageController">
			First Name: <input type="text" name="firstname" REQUIRED/><br />
			Last Name: <input type="text" name="lastname" REQUIRED/><br />
			Address: <input type="text" name="address" REQUIRED/><br />
			Mobile Number: <input type="text" name="mobile" REQUIRED/><br />
			Email Address: <input type="text" name="emailadd" REQUIRED/><br />
			Password: <input type="password" name="password" REQUIRED/><br />
			Retype Password: <input type="password" name="retypepassword" REQUIRED/><br /><br />
			<button type="submit" name="btn" value="registeruser">Sign Up</button>
			<!--  
				<button type="submit" name="" value=""></button>
			-->
		</form>
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtologin">Back to Login Page</button>
		</form>
		
		<br /><br />
		
		<%=flightReservation.getMessage() %>
		<%flightReservation.setMessage(""); %>
	</center>
</body>
</html>