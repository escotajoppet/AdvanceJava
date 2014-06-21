<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="hotelReservation" class="hotel.reservation.HotelReservation" scope="session"/>

<%
	String btn = request.getParameter("btn");

	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	if(btn!=null && btn.equals("login")){
		if(hotelReservation.login(username, password)){
			hotelReservation.setLoggedIn(username);
			request.getRequestDispatcher("/main_page.jsp").forward(request, response);
		}
	}
%>

<body>
	<center>
		<h1>Hotel Accommodation System</h1>
		<form action="Controller">
			Username: <input type="text" name="username"/><br />
			Password: <input type="password" name="password"/><br /><br />
			<button name="btn" value="login">Log In</button>
		</form>
		
		<br />
		
		<form action="Controller">
			<button name="btn" value="adminback">Back to Main Menu</button>
		</form>
	</center>
</body>
</html>