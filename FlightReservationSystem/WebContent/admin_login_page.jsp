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
	String username = request.getParameter("admin");
	String password = request.getParameter("password");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("adminlogin")){
		if(flightReservation.logInAdmin(username, password)){
			flightReservation.setUser(username);
			request.getRequestDispatcher("/admin_page.jsp").forward(request, response);
		}		
	}
%>

<body>
	<center>
		<form action="PageController">
			<h1>Z-Airlines</h1>
			<h3>Login Administrator</h3>
			Username: <input type="text" name="admin"/><br />
			Password: <input type="password" name="password"/><br /><br />
			<button type="submit" name="btn" value="adminlogin">Log In</button><br />
			<button type="submit" name="btn" value="adminback">Back</button>
		</form>
		
		<br /><br />
		
		<%=flightReservation.getMessage() %>
		<%flightReservation.setMessage(""); %>
	</center>
</body>
</html>