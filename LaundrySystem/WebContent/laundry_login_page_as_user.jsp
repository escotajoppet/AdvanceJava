<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="laundrySystem" class="laundry.system.LaundrySystem" scope="session"/>

<%
	boolean logInFlag = false;
	
	String email = request.getParameter("loginemailadd");
	String password = request.getParameter("loginpassword");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("userlogin")){
		logInFlag = laundrySystem.logInMember(email, password, "members");
		
		if(logInFlag){
			laundrySystem.setUserEmailAdd(email);
			request.getRequestDispatcher("laundry_information_page.jsp").forward(request, response);
		}		
	} 
%>

<body>
	<center>
		<h2>User Login</h2>
		<form action="PageController">
			Email Address: <input type="text" name="loginemailadd"/><br />
			Password: <input type="password" name="loginpassword"/><br /><br />
			<button type="submit" name="btn" value="userlogin">Log In</button><br />			
			<button type="submit" name="btn" value="register">Sign Up New User</button>
			
			<br /><br />
			
			<button type="submit" name="btn" value="backtomain">Back to Main Menu</button>		
		</form>
		
		<br />
		<%=laundrySystem.getMessage() %>
		<%laundrySystem.setMessage(""); %>
	</center>
</body>
</html>