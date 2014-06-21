<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="loanSystem" class="loan.system.LoanSystem" scope="session"/>

<%
	String btn = request.getParameter("btn");
	String username = request.getParameter("customerusername");

	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("setcustomer")){
		loanSystem.setUsername(username);
		request.getRequestDispatcher("/choose_options.jsp").forward(request, response);
	}
%>

<body>
	<center>
		<h1>Loan System</h1>
		<h3>Set Customer</h3>
		
		<form action="Controller">
			Customer Username: <input type="text" name="customerusername"/>
			<br /><br />
			<button type="submit" name="btn" value="setcustomer">Set Customer</button>			
		</form>
		
		<br />
		
		<form action="Controller">
			<button type="submit" name="btn" value="signup">Register New Customer</button>
			<br /><br />
			<button type="submit" name="btn" value="logout">LOG OUT</button>
		</form>
	</center>
</body>
</html>