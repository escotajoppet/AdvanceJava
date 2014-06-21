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

	String adminUsername = request.getParameter("username");
	String password = request.getParameter("password");
	String retypePass = request.getParameter("retypepass");
	
	if(button!=null && button.equals("confirmsignup")){
		sis.signUp(adminUsername, password, retypePass);
	}
%>

<body>
	<form action="hrcontroller" method="Post">
		<h2>New Admin User Information</h2>
		Admin Username: <input type="text" name="username" REQUIRED/><br /><br />
		Password: <input type="password" name="password" REQUIRED/><br /><br />
		Retype Password: <input type="password" name="retypepass" REQUIRED /><br /><br />
		
		<button name="button" value="confirmsignup">Sign Up</button>
	</form>
	
	<br />
	
	<form action="hrcontroller" method="Post">
		<button name="button" value="backtologin">Back to login</button>
	</form>
			
	<br /><br />
	
	<%=sis.getMessage() %>
	<%sis.setMessage(""); %>	
</body>
</html>