<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="funeralPlan" class="funeral.plan.FuneralPlan" scope="session"/>

<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("customerlogin")){
		if(funeralPlan.logIn(username, password, "customers")){
			funeralPlan.setUser(username);
			funeralPlan.setName(username);
			request.getRequestDispatcher("/plan_list.jsp").forward(request, response);
		}		
	}
	
	funeralPlan.setName("");
%>

<body>
	<center>
		<form action="PageController">
			<h1>Funeral Plan</h1>
			<h3>Login to use your saved details</h3>
			Username: <input type="text" name="username"/><br />
			Password: <input type="password" name="password"/><br /><br />
			<button type="submit" name="btn" value="customerlogin">Log In</button>
		</form>
		<form action="PageController">
			<button type="submit" name="btn" value="register">Not Yet A Member?</button><br />
			<button type="submit" name="btn" value="logasadmin">Log In As Admin</button>
		</form>
		
		<br /><br />
		
		<%=funeralPlan.getMessage() %>
		<%funeralPlan.setMessage(""); %>
	</center>
</body>
</html>