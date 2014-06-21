<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Information</title>
</head>

<jsp:useBean id="employeemngr" class="employee.manager.EmployeeManager" scope="session"/>

<%
	String idno = request.getParameter("idno");
	employeemngr.setFields(idno);
%>

<body>
	<center>
		<table border="2" cellpadding="3">
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>Mobile Number</th>
			</tr>
			<tr>
				<td><%=employeemngr.getName()%></td>
				<td><%=employeemngr.getAddress() %></td>
				<td><%=employeemngr.getMobile() %></td>
			</tr>
		</table>
		<br />
		<a href="index.html">Back to Main Page</a>
	</center>
</body>
</html>