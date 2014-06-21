<jsp:useBean id="pharmacy" class="pharmacy.system.PharmacySystem" scope="session"/>


<%!
	String err = "";
%>

<%
	String user =  (String)session.getAttribute("username");
	if(pharmacy.getLogOut() == 1) {
		err = "Not logged in. Please Login.";
		pharmacy.setLogOut(0);
	} else {
		err = "";
	}
	if(user!=null) {
		request.getRequestDispatcher("/pharmacy_main_page.jsp").forward(request, response);
	} else {
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		pharmacy.setUser(username);
		pharmacy.setPassword(password);
		if(request.getParameter("btn") != null && request.getParameter("btn").equals("sign_In")) {
			String stat = pharmacy.loginAccount(username);
			if(stat.equals("error")) {
				err = "Invalid Username or Password.";
			} 
			stat = pharmacy.checkPassword(username,password);
			if(stat.equals("error")) {
				err = "Invalid Username or Password";
			} else {
				session.setAttribute("username",username);
				request.getRequestDispatcher("/pharmacy_main_page.jsp").forward(request, response);		
			}	
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
<body>
	<form action="Controller" method = "Post">
		<nav class="navbar navbar-inverse" role="navigation">
		<ul class="nav navbar-nav">
  <a class="navbar-brand" href="#">Pharmacy</a>
  <li><button type="submit" name="btn" value="signupp" class="active">Sign Up</button></li>
  		</ul>
	<div id="main">
		<div id="form1">
			
			
			
				<div class="navbar-text navbar-right">
				
					<label for="" class = "label"><%=err%></label>
					<label for="" class = "label">Username: </label><input type="text" name="userName" class="name1" /> 
					<label for="" class = "label">Password: </label><input type="password" name="password" class="name2"  /> 			
				
					<button type="submit" class="btn btn-default navbar-btn btn-primary btn-sm submit1" name="btn" value="sign_In">Sign In</button>
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



