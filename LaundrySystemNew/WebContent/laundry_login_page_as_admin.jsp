<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hey Wash Up?!</title>
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/login.css" /> 
<link rel="stylesheet" href="css/registeruser.css" /> 
<link rel="stylesheet" href="css/informationpage.css" /> 
<link rel="stylesheet" href="css/transactionsummary.css" /> 
<link rel="stylesheet" href="css/informationadmin.css" /> 
</head>

<jsp:useBean id="laundrySystem" class="laundry.system.LaundrySystem" scope="session"/>

<%
	boolean logInFlag = false;

	String email = request.getParameter("loginemailadd");
	String password = request.getParameter("loginpassword");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("adminlogin")){
		logInFlag = laundrySystem.logInMember(email, password, "admin");
		
		if(logInFlag){
			laundrySystem.setUserEmailAdd(email);
			request.getRequestDispatcher("/laundry_information_page_as_admin.jsp").forward(request, response);
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
		<div id="summaryoftransaction">
		<img src="img/admin.png" alt="" />
		</div>
		<div id="transactionsummary">
		<form action="PageController">
			Email Address: <input type="text" name="loginemailadd"/><br />
			Password: <input type="password" name="loginpassword"/><br /><br />		
			<button type="submit" name="btn" value="adminlogin" class="loginbutton">Log In</button>	
			
			<br />	
				
			<button type="submit" name="btn" value="backtomain">Back to Main Menu</button>
		</form>
		<br />
		<%=laundrySystem.getMessage() %>
		<%laundrySystem.setMessage(""); %>
	</div>
		<div id="footer"></div>
	</center>
</body>
</html>