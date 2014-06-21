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
	String emailAdd = request.getParameter("emailaddress");
	String password = request.getParameter("password");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("login")){
		if(flightReservation.logIn(emailAdd, password)){
			flightReservation.setUser(emailAdd);
			request.getRequestDispatcher("/book_a_flight.jsp").forward(request, response);
		}		
	}
%>

<body>
	<center>
		<form action="PageController">
			<h1>Z-Airlines</h1>
			<h3>Login to use your saved details</h3>
			Email Address: <input type="text" name="emailaddress"/><br />
			Password: <input type="password" name="password"/><br /><br />
			<button type="submit" name="btn" value="login">Log In</button>
		</form>
		<form action="PageController">
			<button type="submit" name="btn" value="register">Not Yet A Member?</button><br />
			<button type="submit" name="btn" value="logasadmin">Log As Administrator</button>
		</form>
		
		<br /><br />
		
		<%=flightReservation.getMessage() %>
		<%flightReservation.setMessage(""); %>
	</center>
</body>
</html>