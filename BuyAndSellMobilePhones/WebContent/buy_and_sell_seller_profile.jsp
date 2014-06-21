<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="buyAndSell" class="buy.and.sell.BuyAndSell" scope="session"/>

<%
	buyAndSell.clearSellerProfile();
	buyAndSell.setSellerProfile();
%>

<body>
	<center>
		<h3><%=buyAndSell.getName() %>'s Profile</h3>
		
		<strong>Contact Number: </strong><%=buyAndSell.getContactNumber() %> <br />
		<strong>Email Address: </strong><%=buyAndSell.getEmailAddress() %> <br />
		<strong>Facebook Account: </strong><%=buyAndSell.getFbAccount() %>
		
		<br /><br />
		
		<table border="2" cellpadding="10">
			<tr>
				<th>Device Model</th>
				<th>Date Posted</th>
				<th>Description</th>
				<th>Price</th>
			</tr>
			
			<%
				for(int i = 0; i<buyAndSell.getSellerPhones().size(); i++){
			%>
				<tr>
					<td><%=buyAndSell.getSellerPhones().get(i) %></td>
					<td><%=buyAndSell.getSellerDates().get(i) %></td>
					<td><%=buyAndSell.getSellerDescription().get(i) %></td>
					<td><%=buyAndSell.getSellerPrices().get(i) %></td>					
				</tr>
			<%
				} buyAndSell.clearSellerProfile();
			%>
		</table>
		
		<br /><br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtoresult">Back to Result Page</button>
		</form>
	</center>
</body>
</html>