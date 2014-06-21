<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Pet Shopping Cart</title>
</head>

<jsp:useBean id="petShop" class="online.pet.shop.OnlinePetShop" scope="session"/>

<%petShop.setReservationTable();%>

<body>
	<center>
		<h1>View All Reservations</h1>
		
		<table border="2" cellpadding="10">
			<tr>
				<th>Transaction Date</th>
				<th>Name</th>
				<th>Address</th>
				<th>Contact Number</th>
				<th>Order Information</th>
			</tr>
			
			<%
				for(int i = 0; i<petShop.getTransactionDate().size(); i++){
			%>
				<tr>
					<td><%=petShop.getTransactionDate().get(i) %></td>
					<td><%=petShop.getReservedName().get(i) %></td>
					<td><%=petShop.getReservedAddress().get(i) %></td>
					<td><%=petShop.getReservedContactNumber().get(i) %></td>
					<td><%=petShop.getOrder().get(i) %></td>
				</tr>
			<%
				} petShop.clearReservationTable();			
			%>
		</table>
		
		<br /><br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtomainpage">Back to Main Page</button>
		</form>
	</center>
</body>
</html>