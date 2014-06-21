<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Employee</title>
</head>

<jsp:useBean id="employeemngr" class="employee.manager.EmployeeManager" scope="session"/>

<%! 
	String idno = "";%>
<%
	String deleteEmployee = request.getParameter("deleteEmployee");
	
	idno = request.getParameter("idno")!=null ? request.getParameter("idno") : idno;

	employeemngr.setFields(idno);
	
	if(deleteEmployee!=null){
		employeemngr.deleteEmployee(idno);
		employeemngr.setFields("");
		%><jsp:forward page="index.html"/><%
	} 
%>

<body>
	<center>
		<h3>Delete Employee</h3>
		<br /><br />
		<form action="delete_employee.jsp">
			Delete Employee?<br /><br />
			Name: <%=employeemngr.getName() %> <br />
			Address: <%=employeemngr.getAddress() %> <br />
			Contact: <%=employeemngr.getMobile() %>
			<br /><br />
			<input type="submit" name="deleteEmployee" Value="Delete Employee!"/><br /><br />
			<a href="index.html">Back to Main Page</a>
		</form>
	</center>

</body>
</html>