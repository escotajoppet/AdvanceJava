<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Library System</title>
	<link rel="stylesheet" href="css/main.css" />
	<link rel="stylesheet" href="css/adminaddbook.css" />
</head>
<jsp:useBean id="librarySystem" class="library.system.LibrarySystem" scope="session"/>
<%
	String controlnumber = request.getParameter("controlnumber");
	String booktitle = request.getParameter("booktitle");
	String author= request.getParameter("author");
	String yearpublished = request.getParameter("yearpublished");
	String btn = request.getParameter("btn");
	
	if(btn != null && btn.equals("add")){
		librarySystem.addbook(controlnumber, booktitle, author, yearpublished);
	}
%>
<body>
	<div id="main">
	<div id="header">
		<img src="img/logo.png" alt="" />
		<h1>Library</h1>
	</div>
	<div id="AdminLoggedIn">
		<h1>Logged In as Admin,</h1>
		<form action="Controller" method="get" id="guest1">
		<button type="submit" name="btn" value="adminlogout" class="logout"></button><br />
		</form>
		<form action="Controller" method="get" id="guest1">
		<label for="" class="label">Control Number: </label><input type="text" name="controlnumber" class="controlnumber" /><br />
		<label for="" class="label">Book Title: </label><input type="text" name="booktitle" class="booktitle" /><br /> 
		<label for="" class="label">Author: </label><input type="text" name="author" class="author" /><br /> 
		<label for="" class="label">Year Published: </label><input type="text" name="yearpublished" class="yearpublished" /><br /> 
		<button type="submit" name="btn" value="add" class="add"></button>
		</form>
		<form action="Controller" method="get" id="guest1">
		<button type="submit" name="btn" value="back" class="back"></button>
		</form>
	</div>
	<div id="footer">
		<%=librarySystem.getMessage() %>
		<%librarySystem.setMessage(""); %>
	</div>
	</div>
</body>
</html>