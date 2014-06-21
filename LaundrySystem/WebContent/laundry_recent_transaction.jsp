<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="laundrySystem" class="laundry.system.LaundrySystem" scope="session"/>

<body>
	<center>
		<h2><%=laundrySystem.getUserEmailAdd() %></h2>
		<table border="2" cellpadding="3">
			<tr>
				<th>Transaction Date</th>
				<th>Number of Clothes</th>
				<th>Number of Kilos</th>
				<th>Amount</th>
				<th>Type of Wash</th>
				<th>Mode of Payment</th>
				<th>Type of Service</th>
			</tr>
			
			<%
				for(int i = 0; i<laundrySystem.getRecentTypeOfService().size(); i++){
			%>
				<tr>
					<td><%=laundrySystem.getRecentDate().get(i) %></td>
					<td><%=laundrySystem.getRecentTotalNumberOfClothes().get(i) %></td>
					<td><%=laundrySystem.getRecentKilo().get(i) %></td>
					<td><%=laundrySystem.getRecentAmount().get(i) %></td>
					<td><%=laundrySystem.getRecentTypeOfWash().get(i) %></td>
					<td><%=laundrySystem.getRecentModeOfPayment().get(i) %></td>
					<td><%=laundrySystem.getRecentTypeOfService().get(i) %></td>
				</tr>
			<%
				} laundrySystem.clearRecentTransaction();	
			%>
		</table>
		
		<br /><br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtoinformationpage">Back to Information Page</button>
		</form>
	</center>
</body>
</html>