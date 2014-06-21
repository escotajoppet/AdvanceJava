<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="thesisManagement" class="thesis.management.ThesisManagement" scope="session"/>

<%
	String username = request.getParameter("ausername");
	String password = request.getParameter("apassword");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("adminsignin")){
		if(thesisManagement.logIn(username, password, "admindb")){
			thesisManagement.setUserName(username);
			request.getRequestDispatcher("/admin.jsp").forward(request, response);
		}
	}
%>

<body>
	<center>
	<h1>Thesis Management System</h1>
	<h2>Log In As Administrator</h2>
	
	<form action="PageController">
		<label for="">Username</label>
		<input type="text" name="ausername"/>
		<br />
		<label for="">Password</label>
		<input type="password" name="apassword"/>
		<br />
		<button type="submit" name="btn" value="adminsignin">Sign In</button>
		
		<br /><br />
		
		<button type="submit" name="btn" value="backtomainpage">Back to Main Page</button>
	</form>
	
	<br /><br />
	
	<%=thesisManagement.getMessage() %>
	<%thesisManagement.setMessage(""); %>
	</center>
</html>