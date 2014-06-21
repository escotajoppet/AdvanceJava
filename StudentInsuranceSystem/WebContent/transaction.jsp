<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Insurance System</title>
</head>

<jsp:useBean id="sis" class="student.information.system.StudentInfomationSystem" scope="session"/>

<%
	sis.clearTransactionInformation();
	sis.setAllTransactions();
%>

<body>
<div id="main">
		<div id="form1">
			<div id="title"><p>STUDENT INSURANCE SYSTEM</p></div>
			
			WELCOME, <strong><%=sis.getAdminUsername().toUpperCase() %></strong><br><br><br>
			
			<table border="2" cellpadding="5">
				<tr>
					<td>Transaction Date</td>
					<td>Administrator Username</td>
					<td>Action Committed</td>
					<td>Account # Committed</td>
				</tr>
				
				<%
					for(int i = 0; i<sis.getTransactionDate().size(); i++){
				%>
					<tr>
						<td><%=sis.getTransactionDate().get(i) %></td>
						<td><%=sis.getTransactionAdmin().get(i) %></td>
						<td><%=sis.getTransactionAction().get(i) %></td>
						<td><%=sis.getTransactionAccount().get(i) %></td>
					</tr>
				<%
					}
				%>
			</table>
			
			<br />
			
			<form action="hrcontroller" method = "Post">							
				<button name="button" value="transactionBack">Back</button>
				<button name="button" value="logout">Log Out</button>
			</form>
			
			<br /><br />
			
			<%=sis.getMessage() %>
			<%sis.setMessage(""); %>
		</div>
	</div>
</body>
</html>