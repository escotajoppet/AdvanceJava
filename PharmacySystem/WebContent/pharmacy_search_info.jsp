
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    padding-top: 70px;
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
     div.bodyBG
    {
   	margin:70px;
    font-style: bold;
  	color: white;
  	background-color: rgba(2,2,2,0.6);
    }
   
    </style>
<jsp:useBean id="pharmacy" class="pharmacy.system.PharmacySystem" scope="session"/>

<%
	ResultSet rs = null;

	String txtSearchBrandName = request.getParameter("searchinfoname");
	
	if(session.getAttribute("username")== null) {
		pharmacy.setLogOut(1);
		request.getRequestDispatcher("/signIn.jsp").forward(request, response);
	} else {
		if(request.getParameter("btn") != null && request.getParameter("btn").equals("sign_out_search")) {
			session.removeAttribute("username");
			session.invalidate();
			request.getRequestDispatcher("/signIn.jsp").forward(request, response);			
		}		
	}
	if(request.getParameter("btn") != null && request.getParameter("btn").equals("searchinfo")){
		rs = pharmacy.searchInfo(txtSearchBrandName);
	}
%>

<body>
	<form action="Controller" method="post">
	<center>
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
				<ul class="nav navbar-nav">
  					<a class="navbar-brand" href="#">Pharmacy</a>
  						<li><button type="submit" name="btn" value="home">Home</button></li>
						  <li><button type="submit" name="btn" value="add_info">Add</button></li>
						  <li><button type="submit" name="btn" value="delete_info">Delete</button></li>
						  <li><button type="submit" name="btn" value="view">View</button></li>
						  <li class="active"><button type="submit" name="btn" value="search">Search</button></li>
 
				</ul>
				<p class="navbar-text navbar-right">
			<button type="submit" class="btn btn-default btn-danger btn-sm" name="btn" value="sign_out_view">Sign Out</button>
		</nav>	
		<br />
		<div class="bodyBG">
		<div style="position: absolute; left: 280px; top: 40px;"> 
	<img src="search.png" alt="" >
	</div>
		<br><br>
		
			Search Brand Name: <font color="black"><i><input type="text" size="30" placeholder="Input Brand Name" name="searchinfoname"/></font></i>
			<button type="submit" class="btn btn-default navbar-btn btn-warning" name="btn" value="searchinfo">Search</button>
		</form>
		<table class="table table"cellpadding="3" border="5">
			<tr>
				<b><th>Generic Name</th>
				<th>Brand Name</th>
				<th>Manufacturer</th>
				<th>Amount</th>
				</b>
			</tr>
			
			<%
				while(rs!=null && rs.next()){
			%>
				<tr>
					<td><%=rs.getString("generic_name") %></td>
					<td><%=rs.getString("brand_name") %></td>
					<td><%=rs.getString("manufacturer") %></td>
					<td><%=rs.getString("amount") %></td>
				</tr>		
			<%
				}
			%>
			
		</table>
		</div>
		<br /><br />
			
		<nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
  			<div class="container">
  			Copyright 2014. Polytechnic University of the Philippines. "The Country's First Polytechnic U"
  			</div>
	</center>
	
</body>
</html>