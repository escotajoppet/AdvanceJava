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
	hotelReservation.clearViewLocation();
	hotelReservation.setHotelLocation();
%>

<body>
	<center>
		<form action="Controller">
			<h1>Hotel Accommodation System</h1>
			<button type="submit" name="btn" value="accommodation">Accommodation</button>
			<button type="submit" name="btn" value="sightsandactivities">Sights and Activities</button>
			<button type="submit" name="btn" value="planyourvisit">Plan Your Visit</button>
			<button type="submit" name="btn" value="contactus">Contact Us</button>
			<%
				if(hotelReservation.getLoggedIn().equals("")){
			%>
				<button type="submit" name="btn" value="adminback">Back</button>
			<%
				} else{
			%>
				<button type="submit" name="btn" value="addnewhotel">Add New Hotel</button>
				<button type="submit" name="btn" value="logout">Log Out</button>
			<%
				}
			%>
		</form>
		
		<h2>Hotel Location And Contact Information</h2>
		
		<strong>Hotel Name:</strong> <%=hotelReservation.getViewHotelName() %> <br /><br />
		<strong>Hotel Location:</strong> <%=hotelReservation.getViewHotelLocation() %><br /><br />
		<strong>Hotel Address:</strong> <%=hotelReservation.getViewHotelAddress() %><br /><br />
		<strong>Hotel Contact:</strong> <%=hotelReservation.getViewHotelContact() %><br /><br />
		
		<br /><br />
		<form action="Controller"><button name="btn" value="customerback">Back</button></form>
	</center>
</body>
</html>