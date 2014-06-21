<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hey Wash Up?!</title>
<title>Hey Wash Up?!</title>
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/login.css" /> 
<link rel="stylesheet" href="css/registeruser.css" /> 
<link rel="stylesheet" href="css/informationpage.css" /> 
<link rel="stylesheet" href="css/recenttransaction.css" /> 
</head>

<jsp:useBean id="laundrySystem" class="laundry.system.LaundrySystem" scope="session"/>

<%
	laundrySystem.clearRecentTransaction();
	laundrySystem.setRecentTransaction("");
%>

<body>
	<center>
	<center>
	<div id="main_container">
		<div id="header">
		<img src="img/logo.png" alt="" />
		</div>	
		<div id="background">
	<img src="img/bg.png" alt="" />
	</div>
		<h2><%=laundrySystem.getUserEmailAdd() %></h2>
		<table border="2" cellpadding="5">
			<tr>
				<th>Transaction Date</th>
				<th># of TShirts</th>
				<th># of Shorts</th>
				<th># of Pants</th>
				<th># of Underwear</th>
				<th># of Others</th>
				<th># of Clothes</th>
				<th># of Kilos</th>
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
					<td><%=laundrySystem.getRecentNumberOfTShirts().get(i) %></td>
					<td><%=laundrySystem.getRecentNumberOfShorts().get(i) %></td>
					<td><%=laundrySystem.getRecentNumberOfPants().get(i) %></td>
					<td><%=laundrySystem.getRecentNumberOfUnderwear().get(i) %></td>
					<td><%=laundrySystem.getRecentNumberOfOthers().get(i) %></td>
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
	</div>
		<div id="footer"></div>
	</center>
</body>
</html>