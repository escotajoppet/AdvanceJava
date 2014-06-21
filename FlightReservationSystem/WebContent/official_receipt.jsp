<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="flightReservation" class="flight.reservation.FlightReservation" scope="session"/>

<body>
	<center>
		<h1>Z-Airlines</h1>
		<h3>Thank you for choosing to fly with us!</h3>
		
		Guest Details: <%=flightReservation.getUser() %>
		
		<br /><br />
		
		Flight Details: <br />
		
		<%=flightReservation.getFrom() %> to <%=flightReservation.getTo() %> <br />
		
		Departure:
		<%=flightReservation.getDepartureDateTime() %> <br />
		Arrival:
		<%=flightReservation.getArrivalDateTime() %>
		
		<br /><br />
		
		RETURN <br />
		<%=flightReservation.getTo() %> to <%=flightReservation.getFrom() %> <br />
		Departure:
		<%=flightReservation.getDepartureDateTime() %> <br />
		Arrival:
		<%=flightReservation.getArrivalDateTime() %>
		
		<br /><hr /><br />
		
		FLIGHT DETAILS
		<br /><br />
		BASE FARE: <br />
		# of Persons: <%=flightReservation.getNumberOfPersons() %>
		
		<hr />
		SUBTOTAL: 
		<hr />
		ADD ONS: <br />
			Travel Insurance: 325.00 <br />
			Baggage Allowance: 360.00 <br />
			Seat Reservation: 260.00 <br />
		<hr />
		SUBTOTAL: 945.00
		<hr />
		TAXES AND FEES: 1422.56
		<hr />
		TOTAL: <%=flightReservation.getTotalAmount() %>
		<hr />
		Payment Status <br /><br />
		Payment Type: Credit Card <br />
		Status: CONFIRMED <br />
		Date: <%=flightReservation.getBookingDate() %> <br />
		Amount: <%=flightReservation.getTotalAmount() %> <br /><br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtoflightreservation">Back</button>
			<button type="submit" name="btn" value="logout">Log Out</button>
		</form>
	</center>
</body>
</html>