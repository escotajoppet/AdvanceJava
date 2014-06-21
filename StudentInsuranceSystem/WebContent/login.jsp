<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="sis" class="student.information.system.StudentInfomationSystem" scope="session"/>

<%
	String button = request.getParameter("button");
	
	String username = request.getParameter("username");
	String password= request.getParameter("password");

	if(button!=null && button.equals("login")){
		if(sis.login(username, password)){
			sis.setAdminUsername(username);
			request.getRequestDispatcher("/mainpage.jsp").forward(request, response);
		}
	}
%>

<body>
	<h2>Login Information</h2>
	<form action="hrcontroller" method = "Post">
		Username: <input type="text" name="username" REQUIRED/><br />
		Password: <input type="password" name="password" REQUIRED/><br /><br />
		<button name="button" value="login">Log In</button>
	</form>
	
	<br />
	
	<form action="hrcontroller" method="Post">
		<button name="button" value="signup">Sign Up </button>
	</form>
	
	<br /><br />
			
	<%=sis.getMessage() %>
	<%sis.setMessage(""); %>	
</body>
</html>