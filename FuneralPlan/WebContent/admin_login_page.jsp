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
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("adminlogin")){
		System.out.println("asdasd");
		if(funeralPlan.logIn(username, password, "admin")){
			funeralPlan.setUser("admin");
			funeralPlan.setName("admin");
			request.getRequestDispatcher("/admin_page.jsp").forward(request, response);
		}		
	}
	
	funeralPlan.setName("");
%>

<body>
	<center>
		<form action="PageController">
			<h1>Funeral Plan</h1>
			<h3>Login As Administrator</h3>
			Username: <input type="text" name="username"/><br />
			Password: <input type="password" name="password"/><br /><br />
			<button type="submit" name="btn" value="adminlogin">Log In</button>
		</form>
		<form action="PageController">
			<button type="submit" name="btn" value="logascustomer">Log In As Customer</button>
		</form>
		
		<br /><br />
		
		<%=funeralPlan.getMessage() %>
		<%funeralPlan.setMessage(""); %>
	</center>
</body>
</html>