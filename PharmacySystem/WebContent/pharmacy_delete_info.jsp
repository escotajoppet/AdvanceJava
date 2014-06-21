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
    background: #9c1f1e;
    background-image: url('Pills.jpg')
    }
    .container
    {
    margin:10px;
    color:white;
    font-style: italic;
    }
    span.bodyDiv
    {
     opacity:1;  
     color: white;
    }
    div.bodyBG
    {
    width:600px;
  	height:150px;
  	margin:30px 50px;
    border:1px solid black;
  	background-color: rgba(2,2,2,0.3); // Sets to 50% transparent
    }
    
    </style>
<jsp:useBean id="pharmacy" class="pharmacy.system.PharmacySystem" scope="session"/>

<%
	String txtDeleteBrandName = request.getParameter("deletebrandname");
	
	if(session.getAttribute("username")== null) {
		pharmacy.setLogOut(1);
		request.getRequestDispatcher("/signIn.jsp").forward(request, response);
	} else {
		if(request.getParameter("btn")!=null && request.getParameter("btn").equals("sign_out_delete")) {
			session.removeAttribute("username");
			session.invalidate();
			request.getRequestDispatcher("/signIn.jsp").forward(request, response);			
		}		
	}
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("deleteinfo")){
		pharmacy.deleteInfo(txtDeleteBrandName);
		request.getRequestDispatcher("/pharmacy_main_page.jsp").forward(request, response);
	}
%>

<body>
	<form action="Controller" method="post">
	<center>
	
		<nav class="navbar navbar-inverse" role="navigation">
				<ul class="nav navbar-nav">
  					<a class="navbar-brand" href="#">Pharmacy</a>
  						<li><button type="submit" name="btn" value="home">Home</button></li>
						  <li><button type="submit" name="btn" value="add_info">Add</button></li>
						  <li class="active"><button type="submit" name="btn" value="delete_info">Delete</button></li>
						  <li><button type="submit" name="btn" value="view">View</button></li>
						  <li><button type="submit" name="btn" value="search">Search</button></li> 
				</ul>
				<p class="navbar-text navbar-right">
	<button type="submit" class="btn btn-default btn-danger btn-sm" name="btn" value="sign_out_delete">Sign Out</button></p>
			</nav>
			<br>
			<br> <br> <br>
			<br>
			<div style="position: absolute; left: 250px; top: 40px;"> 
			<img src="delete.png" alt="" >
			</div>
			<div style="position: absolute; left: 595px; top: 400px;"> 
			<img src="redcross.png" alt="" >
			</div>
			<div class="bodyBG">
		
			<span class="bodyDiv">
			<br><br>
			Brand Name: <i><font color="black"><input size="50" type="text" placeholder=" Input Brand Name" name="deletebrandname"/></i></font>
			<button type="submit" class="btn btn-default navbar-btn btn-danger" name="btn" value="deleteinfo">Delete</button><br /><br />
			</span>
			</div>
			<nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
  			<div class="container">
  			Copyright 2014. Polytechnic University of the Philippines. "The Country's First Polytechnic U"
  			</div>
			
		</form>
	</center>
</body>
</html>