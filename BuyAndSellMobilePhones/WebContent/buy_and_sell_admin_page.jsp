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
	if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("adl ")){
		buyAndSell.deletePost("admin", request.getParameter("btn").substring(4));
	}

	buyAndSell.clearResults();
	buyAndSell.setAdminView();
%>

<body>
	<center>
		<h1>Buy And Sell</h1>
		<h3>Administrator</h3>
		
		<form action="PageController">
			<table border="1" cellpadding="5">
				<tr>
					<td>Entry #</td>
					<td>Device Model</td>
					<td>Date Posted</td>
					<td>Description</td>
					<td>Seller</td>
					<td>Price</td>
					<td>Action</td>
				</tr>
				
				<%
					for(int i = 0; i<buyAndSell.getEntryNumber().size(); i++){
				%>
					<tr>
						<td><%=buyAndSell.getEntryNumber().get(i) %></td>
						<td><%=buyAndSell.getDeviceModel().get(i) %></td>
						<td><%=buyAndSell.getDatePosted().get(i) %></td>
						<td><%=buyAndSell.getDescription().get(i) %></td>
						<td><%=buyAndSell.getSeller().get(i) %></td>
						<td><%=buyAndSell.getPrice().get(i) %></td>
						<td><button type="submit" name="btn" value="adl <%=buyAndSell.getEntryNumber().get(i) %>">Delete</button></td>
					</tr>
				<%
					}
				%>
			</table>
			
			<br />
			
			<button type="submit" name="btn" value="logout">Log Out</button>
		</form>
	</center>
</body>
</html>