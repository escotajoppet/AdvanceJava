<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title></title>
</head>

<jsp:useBean id="thesisManagement" class="thesis.management.ThesisManagement" scope="session"/>

<%
	boolean flag = false;

	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("panelistsignin")){
		flag = thesisManagement.logIn(username, password, "panelists");
		
		if(flag){
			session.setAttribute("username", username);
			thesisManagement.setUserName(username);
			request.getRequestDispatcher("/panelist.jsp").forward(request, response);
		}
	}
%>

<body>
	<center>
		<h1>Thesis Management System</h1>
		<h2>Log In As Panelist</h2>
		
		<form action="PageController">
			<label for="">Username</label>
			<input type="textbox" name="username"/>
			<br />
			<label for="">Password</label>
			<input type="password" name="password"/>
			<br />
			<button type="submit" name="btn" value="panelistsignin">Sign in</button>
			
			<br /><br />
			
			<button type="submit" name="btn" value="backtomainpage">Back to Main Page</button>
		</form>
		
		<br /><br />
		
		<%=thesisManagement.getMessage() %>
		<%thesisManagement.setMessage(""); %>
	</center>
</body>
</html>