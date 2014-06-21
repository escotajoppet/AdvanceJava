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
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	String departureDateTime = request.getParameter("departuredate");
	String arrivalDateTime = request.getParameter("arrivaldate");
	String numberOfPersons = request.getParameter("personsno");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("booknow")){
		flightReservation.bookFlight(from, to, departureDateTime, arrivalDateTime, Integer.parseInt(numberOfPersons));
		request.getRequestDispatcher("/official_receipt.jsp").forward(request, response);
	}
%>

<body>
	<center>
		<h1>Z-Airlines</h1>
		<h3>Book A Flight</h3>
		
		<form action="PageController">
			From: <select name="from" id="">
				<option value="China">China</option>
				<option value="Japan">Japan</option>
				<option value="Korea">Korea</option>
				<option value="Malaysia">Malaysia</option>
				<option value="Philippines">Philippines</option>
				<option value="Singapore">Singapore</option>
				<option value="Thailand">Thailand</option>
				<option value="UAE">UAE</option>
			</select>
			
			<br />
			
			To: <select name="to" id="">
				<option value="China">China</option>
				<option value="Japan">Japan</option>
				<option value="Korea">Korea</option>
				<option value="Malaysia">Malaysia</option>
				<option value="Philippines">Philippines</option>
				<option value="Singapore">Singapore</option>
				<option value="Thailand">Thailand</option>
				<option value="UAE">UAE</option>			
			</select>
			
			<br /><br />
			
			Departure: <input type="datetime-local" name="departuredate"/><br />
			Arrival: <input type="datetime-local" name="arrivaldate"/><br /><br />
			
			Number of Persons: <select name="personsno" id="">
				<%
					for(int i = 1; i<11; i++){
				%>
					<option value="<%=i%>"><%=i %></option>
				<%		
					}
				%>
			</select>
			
			<br /><br />
			<button type="submit" name="btn" value="booknow">Book Now</button>
		</form>
		
		<br /><br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="logout">Log Out</button>
		</form>
	</center>
</body>
</html>