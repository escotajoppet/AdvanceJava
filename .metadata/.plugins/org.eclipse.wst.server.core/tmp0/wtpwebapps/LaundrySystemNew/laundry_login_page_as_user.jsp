<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hey Wash Up?!</title>
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/login.css" /> 
</head>

<jsp:useBean id="laundrySystem" class="laundry.system.LaundrySystem" scope="session"/>

<%
	boolean logInFlag = false;
	
	String email = request.getParameter("loginemailadd");
	String password = request.getParameter("loginpassword");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("userlogin")){
		logInFlag = laundrySystem.logInMember(email, password, "members");
		
		if(logInFlag){
			laundrySystem.setUserEmailAdd(email);
			request.getRequestDispatcher("laundry_information_page.jsp").forward(request, response);
		}		
	} 
%>

<body>
<center>

	<div id="main_container">
	<div id="header">
		<img src="img/logo.png" alt="" />
	</div>
	<div id="background">
	<img src="img/bg.png" alt="" />
	</div>
	<div id="user_login">
		<form action="PageController">
			<p>Email Id: </p><input type="text" name="loginemailadd" class="emailbox"/><br/>
			<p>Password: </p><input type="password" name="loginpassword" class="passwordbox"/><br /><br /><br /><br />
			<button type="submit" name="btn" value="userlogin">Log In</button>			
			<button type="submit" name="btn" value="register">Sign Up New User</button>
			
			<br /><br />
			
			<button type="submit" name="btn" value="backtomain">Back to Main Menu</button>		
		</form>
		<div id="footer"></div>
		<%=laundrySystem.getMessage() %>
		<%laundrySystem.setMessage(""); %>
	
	</div>
	</div>
	</center>
</body>
</html>