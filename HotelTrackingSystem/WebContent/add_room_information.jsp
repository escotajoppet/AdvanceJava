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
	String roomType = request.getParameter("roomtype");
	String roomDescription = request.getParameter("roomdescription");
	String btn = request.getParameter("btn");
	
	if(btn!=null && btn.equals("addroominformation")){
		hotelReservation.addNewRoomInformation(roomType, roomDescription);
	}
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
		
		<br />
		
		<form action="Controller">
			Room Type: <input type="text" name="roomtype"/>
			<br /><br />
			<textarea name="roomdescription" id="" cols="30" rows="10" placeholder="Description of Promo Here"></textarea>
			<br /><br />
			<button type="submit" name="btn" value="addroominformation">Add Room Information</button>
		</form>
		<br />
		<br />
		<form action="Controller"><button name="btn" value="customerback">Back</button></form>
	</center>
</body>
</html>