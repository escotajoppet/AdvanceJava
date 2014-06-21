<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Pet Shopping Cart</title>
<link rel="stylesheet" href="css/all.css" />
</head>

<jsp:useBean id="petShop" class="online.pet.shop.OnlinePetShop" scope="session"/>

<%
	boolean logFlag = false;

	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("asadmin")){
		logFlag = petShop.logIn(username, password);		
		
		if(logFlag){
			petShop.setLoggedAs("admin");		
			request.getRequestDispatcher("/main_page.jsp").forward(request, response);
		}
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").equals("ascustomer")){
		petShop.setLoggedAs("customer");
		request.getRequestDispatcher("/main_page.jsp").forward(request, response);
	}
%>

<body>
	<center>
		<h1>Online Pet Shop</h1>
		<h2>Log In Page</h2>
		<form action="PageController">
			Username <input type="text" name="username" REQUIRED/><br />
			Password <input type="password" name="password" REQUIRED/><br /><br />
			<button type="submit" name="btn" value="asadmin">Log In</button>
		</form>
		
		<br /><br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="ascustomer">Log In As Customer</button>
		</form>
	</center>
</body>
</html>