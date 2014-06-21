<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library System</title>
<link rel="stylesheet" href="css/main.css" />
	<link rel="stylesheet" href="css/guestlogs.css" /> 
</head>

<jsp:useBean id="librarySystem" class="library.system.LibrarySystem" scope="session"/>

<%
	librarySystem.clearLogs();
	librarySystem.viewGuestLogs();
%>

<body>
	<div id="main">
	<div id="header">
		<img src="img/logo.png" alt="" />
		<h1>Library</h1>
	</div>
		<div id="table">
		<h1>Guests Logs</h1> <br />
		<table border="1" cellpadding="5" >
			<tr>
				<th>Transaction Date</th>
				<th>Student ID</th>
				<th>Student Name</th>
				<th>Transaction</th>
			</tr>
			
			<%
				for(int i = 0; i<librarySystem.getLogsDateTime().size(); i++){
			%>
				<tr>
					<td><%=librarySystem.getLogsDateTime().get(i) %></td>
					<td><%=librarySystem.getLogsStudentNumber().get(i) %></td>
					<td><%=librarySystem.getLogsName().get(i) %></td>
					<td><%=librarySystem.getLogsTransaction().get(i) %></td>
				</tr>
			<%
				}
			%>
		</table>
		</div>
		<br /><br />
		<center>
		<form action="Controller"><button type="submit" name="btn" value="back" class="back"></button></form>
		</center>
<div id="footer">
	</div>
</div>
</body>
</html>