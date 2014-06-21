
<jsp:useBean id="pharmacy" class="pharmacy.system.PharmacySystem" scope="session"/>
<%!
	String err = "";
%>
<%
	String username = request.getParameter("userName");
	String password = request.getParameter("password");

	if(request.getParameter("btn") != null && request.getParameter("btn").equals("signup")) {
		String stat = pharmacy.checkUser(username);
		if(stat.equals("error")) {
			err = "This username is already in use.";
		} else {
			pharmacy.createAccount(username, password);
				request.getRequestDispatcher("/signIn.jsp").forward(request, response);
		}
	}
	

%>

<!DOCTYPE HTML>
<html lang="en-US">
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
    div.main
    {
    
    }
    </style>
    </head>
<body>
	<form action="Controller" method = "Post">
	<nav class="navbar navbar-inverse" role="navigation">
		<ul class="nav navbar-nav">
  <a class="navbar-brand" href="#">Pharmacy</a>
  <li class="active"><button type="submit" name="btn" value="signupp" class="active">Sign Up</button></li>
  <li><button type="submit" value="signinn" name="btn">Sign In</button></li>
  		</ul>
	<div id="main">
		<div id="form1">
			
			<div class="navbar-text navbar-right">
					<label for="" class = "label"><%=err%></label>
					<label for="" class = "label">Username: </label><input type="text" name="userName" class="name1" required/> 
					<label for="" class = "label">Password: </label><input type="password" name="password" class="name2" required /> 			
					
					<button type="submit" value="signup" name="btn" class="btn btn-default navbar-btn btn-primary btn-sm submit1">Sign Up</button>
				</div>	
			</form>
		</div>
	</div>
	<center>
				<nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
  			<div class="container">
 
  			Copyright 2014. Polytechnic University of the Philippines. "The Country's First Polytechnic U"
  				</nav>
  			</center>
  			</div>
</body>
</html>	



