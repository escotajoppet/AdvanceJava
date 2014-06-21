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
	String deviceModel = request.getParameter("devicemodel");
	String description = request.getParameter("description");
	String price = request.getParameter("price");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("add")){
		buyAndSell.addNewEntry(deviceModel, description, price);
	}
%>

<body>
	<center>
		<h2>Add New Entry</h2>
		<form action="PageController">
			<h3>Enter Device Information</h3>
			<input type="text" name="devicemodel" placeholder="Device Model" size="25" REQUIRED/><br /><br />
			<textarea name="description" placeholder="Description of the Device" rows="5" size="25" REQUIRED></textarea><br /><br />
			<input type="text" name="price" placeholder="Unit Price" size="25" REQUIRED/><br /><br />

			<button type="submit" name="btn" value="add">Add New Entry</button>
		</form>
		
		<br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtoguest">Back</button>
		</form>
		
		<br /><br />
		
		<%=buyAndSell.getMessage() %>
		<%buyAndSell.setMessage(""); %>
	</center>
</body>
</html>