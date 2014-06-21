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
	String[] status = request.getParameterValues("status");

	if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("del")){
		System.out.println("delete");
		flightReservation.deleteTransaction(request.getParameter("btn").substring(4));
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").equals("updatetransaction")){
		System.out.println("update");
		flightReservation.updateTransaction(status);
	}

	flightReservation.clearTransactionInfo();
	flightReservation.setTransactionInformation();
%>

<body>
	<center>
		<form action="PageController">
			<h1>Z-Airlines</h1>
			<h3>Login Administrator</h3>
			
			<table border="1" cellpadding="5">
				<tr>
					<th>FROM</th>
					<th>TO</th>
					<th>DEPARTURE</th>
					<th>RETURN</th>
					<th>STATUS</th>
					<th></th>
				</tr>
				
				<%
					for(int i = 0; i<flightReservation.getTransactionEmailAddress().size(); i++){
				%>
					<tr>
						<td><%=flightReservation.getTransactionFromLocation().get(i) %></td>
						<td><%=flightReservation.getTransactionToLocation().get(i) %></td>
						<td><%=flightReservation.getTransactionDeparture().get(i) %></td>
						<td><%=flightReservation.getTransactionArrival().get(i) %></td>
						<td>
							<select name="status" id="">
								<option value="Cancelled" <%=flightReservation.getTransactionStatus().get(i).equals("Confirmed") ? "SELECTED" : "" %>>Confirmed</option>
								<option value="Cancelled" <%=flightReservation.getTransactionStatus().get(i).equals("Cancelled") ? "SELECTED" : "" %>>Cancelled</option>
								<option value="Boarding" <%=flightReservation.getTransactionStatus().get(i).equals("Boarding") ? "SELECTED" : "" %>>Boarding</option>
								<option value="On Board" <%=flightReservation.getTransactionStatus().get(i).equals("On Board") ? "SELECTED" : "" %>>On Board</option>
								<option value="Arrived" <%=flightReservation.getTransactionStatus().get(i).equals("Arrived") ? "SELECTED" : "" %>>Arrived</option>
								<option value="Departed" <%=flightReservation.getTransactionStatus().get(i).equals("Departed") ? "SELECTED" : "" %>>Departed</option>
							</select>						
						</td>
						<td><button type="submit" name="btn" value="del <%=flightReservation.getTransactionTimeOfBooking().get(i) %>">DELETE TRANSACTION</button></td>
					</tr>
				<%
					}
				%>	
				
			</table>	
			
			<br /><br />
			
			<button type="submit" name="btn" value="adminback">Back</button>
			<button type="submit" name="btn" value="updatetransaction">Update Transaction</button>
			<button type="submit" name="btn" value="adminlogout">Log Out</button>
		</form>
	</center>
</body>
</html>