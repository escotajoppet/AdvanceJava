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

	if(btn!=null && btn.equals("customer")){
		hotelReservation.setLoggedIn("");
		request.getRequestDispatcher("/main_page.jsp").forward(request, response);
	}
%>

<body>
	<center>
		<form action="Controller">
			<h1>Hotel Accommodation System</h1>
			<button name="btn" value="customer">View Accommodations</button><br /><br />
			<button name="btn" value="admin">Log As Admin</button>
		</form>
	</center>
</body>
</html>