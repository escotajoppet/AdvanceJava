<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="funeralPlan" class="funeral.plan.FuneralPlan" scope="session"/>

<% funeralPlan.clearCustomerView(); funeralPlan.setCustomersView();%>

<body>
	<center>
		<table border="2" cellpadding="10">
			<tr>
				<th>Customer Name</th>
				<th>Address</th>
				<th>Contact Number</th>
				<th>Email Address</th>
				<th>Birth Date</th>
				<th>Gender</th>
				<th>Civil Status</th>
				<th>Username</th>
				<th>Password</th>
			</tr>
			
			<%for(int i = 0; i<funeralPlan.getCustomerUsername().size(); i++) {%>
				<tr>
					<td><%=funeralPlan.getCustomerName().get(i) %></td>
					<td><%=funeralPlan.getCustomerAddress().get(i) %></td>
					<td><%=funeralPlan.getCustomerContact().get(i) %></td>
					<td><%=funeralPlan.getCustomerEmailAdd().get(i) %></td>
					<td><%=funeralPlan.getCustomerBday().get(i) %></td>
					<td><%=funeralPlan.getCustomerGender().get(i) %></td>
					<td><%=funeralPlan.getCustomerCivilStatus().get(i) %></td>
					<td><%=funeralPlan.getCustomerUsername().get(i) %></td>
					<td><%=funeralPlan.getCustomerPassword().get(i) %></td>
				</tr>
			<%}%>
		</table>
		
		<br /><br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtoadminpage">Back to Admin Page</button>
		</form>
	</center>
</body>
</html>