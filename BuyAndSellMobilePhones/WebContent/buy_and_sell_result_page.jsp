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
	if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith(".. ")){
		buyAndSell.setEmailAddress(request.getParameter("btn").substring(3));
		buyAndSell.setMemberName(request.getParameter("btn").substring(3));
		request.getRequestDispatcher("/buy_and_sell_seller_profile.jsp").forward(request, response);
	}
%>

<body>
	<center>
		<h2>Result For Search</h2>
		
		<form action="PageController">
			<table border="2" cellpadding="10">
				<tr>
					<th>Device Model</th>
					<th>Date Posted</th>
					<th style="width: 240px;">Description</th>
					<th>Price</th>
					<th colspan="2">Seller Name</th>
				</tr>
				
				<%
					for(int i = 0; i<buyAndSell.getEntryNumber().size(); i++){
				%>
					<tr>
						<td><%=buyAndSell.getDeviceModel().get(i) %></td>
						<td><%=buyAndSell.getDatePosted().get(i) %></td>
						<td><%=buyAndSell.getDescription().get(i) %></td>
						<td><%=buyAndSell.getPrice().get(i) %></td>
						<td><%=buyAndSell.getSeller().get(i) %></td>
						<td><button style="width: 100%;" type="submit"  name="btn" value=".. <%=buyAndSell.getSeller().get(i) %>">View Profile</button></td>
					</tr>
				<%
					}
				%>
			</table>
			
			<br />
			
			<button type="submit" name="btn" value="backtosearch">Back to Search Page</button>
		</form>
		
		<br /><br />
		
		<%=buyAndSell.getMessage() %>
		<%buyAndSell.setMessage(""); %>
	</center>
</body>
</html>