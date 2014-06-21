<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%
	String addNewTitle = request.getParameter("add");
	String checkStatus = request.getParameter("check");
	
	if(addNewTitle!=null){
		%><jsp:forward page="AddTitle"/><%
	} else if(checkStatus!=null){
		%><jsp:forward page="CheckStatus"/><%
	}	
%>

<body>
	<center>
		<h1>Thesis Management System</h1>
		<h2>Log In As Guest</h2>
		
		<form action="PageController">
			<button type="submit" name="btn" value="add">Add New Thesis Title</button><br />
			<button type="submit" name="btn" value="guestcheck">Check Status</button>
		
			<br /><br />
		
			<button type="submit" name="btn" value="backtomainpage">Back to Main Page</button>
		</form>	
	</center>	
</body>
</html>