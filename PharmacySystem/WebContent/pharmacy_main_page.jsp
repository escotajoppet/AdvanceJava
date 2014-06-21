
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pharmacy System</title>
    <script src = 'js/jquery.js'></script>
    <script src = 'js/bootstrap.js'></script>
    <script src = 'js/handlebars.js'></script>
    <script src = 'js/app.js'></script>   
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
</head>
<style type="text/css">
   body
    {
    padding-top: 0px;
    padding-bottom: 70px;
    background-image: url('Pills.jpg')
    }
    .container
    {
    margin:10px;
    color:white;
    font-style: italic;
    }
    
    </style>

<jsp:useBean id="pharmacy" class="pharmacy.system.PharmacySystem" scope="session"/>

<%!
	byte count = 0;
%>

<%
	if(count==0){
		pharmacy.getConnection();
		count++;
	}

	String btnAdd = request.getParameter("add");
	String btnDel = request.getParameter("del");
	String btnView = request.getParameter("view");
	String btnSearch = request.getParameter("search");
	String signout = request.getParameter("sign_out");
	
	if(session.getAttribute("username")== null) {
		pharmacy.setLogOut(1);
		request.getRequestDispatcher("/signIn.jsp").forward(request, response);
	} else {
		pharmacy.clearArr();
		pharmacy.medicineList();
		if(request.getParameter("btn") != null && request.getParameter("btn").equals("sign_out_main")) {
			session.removeAttribute("username");
			session.invalidate();
			request.getRequestDispatcher("/signIn.jsp").forward(request, response);			
		}		
	}
%>

<body>

	<form action="Controller" method="post">
		<nav class="navbar navbar-inverse" role="navigation">
		<ul class="nav navbar-nav">
		
 <button type="submit" name="btn" value="pharmacysignin" class="navbar-brand">Pharmacy</button>
  
  <li class="active"><button type="submit" name="btn" value="home">Home</button></li>
  <li><button type="submit" name="btn" value="add_info">Add</button></li>
  <li><button type="submit" name="btn" value="delete_info">Delete</button></li>
  <li><button type="submit" name="btn" value="view">View</button></li>
  <li><button type="submit" name="btn" value="search">Search</button></li>
  <li><button type="submit" name="btn" value="order">Order</button></li>
   
 		
		</ul>
	<p class="navbar-text navbar-right">
	<button type="submit" class="btn btn-default btn-danger btn-sm" name="btn" value="sign_out_main">Sign Out</button></p>	
		</nav>
			<center>
				<nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
  			<div class="container">
 
  			Copyright 2014. Polytechnic University of the Philippines. "The Country's First Polytechnic U"
  				</nav>
  			</center>
  			</div>
  			<center><img src="title2.png" alt="" ></center>
  			<br>
  			<center><img src="symbol.png" alt="" width="300" height="300"></center>
  			
	</form>
</body>
</html>