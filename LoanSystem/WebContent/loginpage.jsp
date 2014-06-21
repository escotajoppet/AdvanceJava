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
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("signin")){
		if(loanSystem.logIn(username, password)){
			request.getRequestDispatcher("/set_customer.jsp").forward(request, response);
		}
	}
%>

<body>
	<center>
		<form action="Controller">
			<h1>Loan System</h1>
			Username: <input type="text" name="username"/><br />
			Password: <input type="password" name="password"/><br /><br />
			<button type="submit" name="btn" value="signin">Sign In</button>
		</form>
		
		<br /><br />
		
		<%=loanSystem.getMessage() %>
		<%loanSystem.setMessage(""); %>
	</center>
</body>
</html>