<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="artgallery" class="art.gallery.ArtGallery" scope="session"/>

<%
	String firstName = request.getParameter("firstname");
	String lastName = request.getParameter("lastname");
	String penName = request.getParameter("penname");
	String password = request.getParameter("password");
	String retypePassword = request.getParameter("retypepassword");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("confirmsignup")){
		artgallery.signUp(firstName, lastName, penName, password, retypePassword);
	}
%>

<body>
	<center>
		<h1>Art Gallery</h1>
		<h3>Sign Up</h3>
		
		<form action="Controller">
			Last Name: <input type="text" name="lastname" REQUIRED/><br />
			First Name: <input type="text" name="firstname" REQUIRED/><br />
			Pen Name: <input type="text" name="penname" REQUIRED/><br />
			Password: <input type="password" name="password" REQUIRED/><br />
			Retype Password: <input type="password" name="retypepassword" REQUIRED/><br /><br />
			
			<button type="submit" name="btn" value="confirmsignup">Sign Up</button>
		</form>
		
		<form action="Controller">
			<button type="submit" name="btn" value="backtologin">Back to Login Page</button>
		</form>
		
		<br /><br />
		
		<%=artgallery.getMessage() %>
		<%artgallery.setMessage(""); %>
	</center>
</body>
</html>