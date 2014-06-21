<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="buyAndSell" class="buy.and.sell.BuyAndSell" scope="session"/>

<%!String updateValue = "Update Profile";%>
<%
	String isDisabled = "DISABLED";

	String contactNumber = request.getParameter("contact");
	String fbAccount = request.getParameter("fbaccount");

	if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("del ")){
		buyAndSell.deletePost("member", request.getParameter("btn").substring(4));
	} else if(request.getParameter("btn")!=null && (request.getParameter("btn").equals("Update Profile") || request.getParameter("btn").equals("Confirm Update"))){
		if(updateValue.equals("Update Profile")){
			isDisabled = "";
			updateValue = "Confirm Update";
		} else{
			isDisabled = "DISABLED";
			updateValue = "Update Profile";
			buyAndSell.updateProfile(contactNumber, fbAccount);
		}
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").contains("sell")){
		String sellInfo[] = request.getParameter("btn").split("#");
		buyAndSell.itemSold(sellInfo[1], sellInfo[2], sellInfo[3], sellInfo[4]);
	}

	buyAndSell.clearSellerProfile();
	buyAndSell.clearSoldItems();
	buyAndSell.setSoldItems();
	buyAndSell.setSellerProfile();
%>

<body>
	<center>
		<h1>Buy And Sell</h1>
		<h3>Welcome, <%=buyAndSell.getMemberName() %></h3>
		<h4>Email Address: <%=buyAndSell.getEmailAddress() %></h4>

		<form action="PageController">
			<strong>Contact Number: </strong><input type="text" name="contact" value="<%=buyAndSell.getContactNumber() %>" size="<%=buyAndSell.getContactNumber().length()+2 %>" <%=isDisabled %>/> <br />
			<strong>Facebook Account: </strong><input type="text" name="fbaccount" value="<%=buyAndSell.getFbAccount() %>" size="<%=buyAndSell.getFbAccount().length()+2 %>" <%=isDisabled %>/>
			
			<br /><br />
			
			<button type="submit" name="btn" value="<%=updateValue %>"><%=updateValue %></button>
		</form>
		
		<br /><br />
		
		<form action="PageController">
			<table border="2" cellpadding="5">
				<tr>
					<th colspan="6">Item List</th>	
				</tr>
				
				<tr>				
					<th>Device Model</th>
					<th>Date Posted</th>
					<th>Description</th>
					<th>Price</th>
					<th colspan="2">Action</th>
				</tr>
				
				<%
					for(int i = 0; i<buyAndSell.getSellerPhones().size(); i++){
				%>
					<tr>
						<td><%=buyAndSell.getSellerPhones().get(i) %></td>
						<td><%=buyAndSell.getSellerDates().get(i) %></td>
						<td><%=buyAndSell.getSellerDescription().get(i) %></td>
						<td><%=buyAndSell.getSellerPrices().get(i) %></td>
						<td><button type="submit" name="btn" value="del <%=buyAndSell.getSellerDates().get(i) %>">Delete Post</button></td>
						<td><button type="submit" name="btn" value="sell#<%=buyAndSell.getSellerPhones().get(i) %>#<%=buyAndSell.getSellerDescription().get(i) %>#<%=buyAndSell.getSellerDates().get(i) %>#<%=buyAndSell.getSellerPrices().get(i) %>">Item Sold</button></td>					
					</tr>
				<%
					} buyAndSell.clearSellerProfile();
				%>
			</table>
			
			<br />
			
			<table border="2" cellpadding="5">
				<tr>
					<th colspan="4">Sold Items</th>	
				</tr>
				
				<tr>				
					<th>Device Model</th>
					<th>Date Sold</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
				
				<%
					for(int i = 0; i<buyAndSell.getSoldDeviceModel().size(); i++){
				%>
					<tr>
						<td><%=buyAndSell.getSoldDeviceModel().get(i) %></td>
						<td><%=buyAndSell.getSoldDate().get(i) %></td>
						<td><%=buyAndSell.getSoldDescription().get(i) %></td>
						<td><%=buyAndSell.getSoldPrice().get(i) %></td>					
					</tr>
				<%
					} 
				%>
			</table>
		
			<br /><br />
		
			<button type="submit" name="btn" value="addnew">Add New Entry</button>
			<button type="submit" name="btn" value="logout">Log Out</button>
		</form>	
		
		<br /><br />
		
		<%=buyAndSell.getMessage() %>
		<%buyAndSell.setMessage(""); %>	
	</center>
</body>
</html>