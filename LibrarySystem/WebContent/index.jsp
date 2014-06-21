<%@page import="library.system.LibrarySystem"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Library System</title>
	<link rel="stylesheet" href="css/main.css" />
	<link rel="stylesheet" href="css/login.css" /> 
</head>

<jsp:useBean id="librarySystem" class="library.system.LibrarySystem" scope="session"/>

<%
 String username = request.getParameter("username");
 String password = request.getParameter("password");
 
 String btn = request.getParameter("btn");

 if(btn!=null && btn.equals("foradmin")){
	 if(librarySystem.logIn(username, password)){
		 request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
	 }
 }
%>

<body>
<div id="main">
	<div id="header">
		<img src="img/logo.png" alt="" />
		<h1>Library</h1>
	</div>
	<div id="LogIn">
		<h2>Log In As:</h2>	
		<input type="button" class="myButton2" id="admin" value=""/>
		
		<form action="Controller" method="get" id="guest1">
			<button type="submit" name="btn" value="forguest" class="myButton"></button>
		</form>
		
		<br />
		
		<div id="AdminLogIn">
			<form action="Controller">
				<label for="" class="label1">Username: </label><input type="text" name="username" class="username adminForm" /><br /> <br />
				<label for="" class="label1">Password: </label><input type="password" name="password" class="password" /><br />
				<button type="submit" name="btn" value="foradmin" class="login"></button>
			</form>
		</div>
	</div>
	
	<div id="footer">
		<%=librarySystem.getMessage() %>
		<%librarySystem.setMessage(""); %>
	</div>
</div>
</body>
<script type="text/javascript">	
	document.getElementById("admin").onclick = function(){
		document.getElementById("AdminLogIn").style.display = "block";
	}; 
		
	document.getElementById("AdminLogIn").style.display = "none";	
</script>
</html>