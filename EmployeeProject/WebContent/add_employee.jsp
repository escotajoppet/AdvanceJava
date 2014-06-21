<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>

<jsp:useBean id="employeemngr" class="employee.manager.EmployeeManager" scope="session"/>

<%
	String idno = request.getParameter("id");
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String number = request.getParameter("number");
	
	String addEmployee = request.getParameter("addEmployee");
	
	if(addEmployee!=null){
		employeemngr.addEmployee(idno, name, address, number);
		%><jsp:forward page="index.html"/><%
	}
%>

<body>
	<center>
		<h3>Add Employee</h3>
		<br /><br />
		<form action="add_employee.jsp">
			ID Number: <input type="text" name="id"/><br /><br />
			Employee Name: <input type="text" name="name"/><br /><br />
			Employee Address: <input type="text" name="address"/><br /><br />
			Employee Number: <input type="text" name="number"/>
			<br /><br />
			<input type="submit" name="addEmployee" Value="Add Employee!"/>
		</form>
		<br />
		<a href="index.html">Back to Main Page</a>
	</center>
</body>
</html>