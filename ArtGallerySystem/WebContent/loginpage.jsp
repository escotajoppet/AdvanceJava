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
	String penName = request.getParameter("penname");
	String password = request.getParameter("password");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("signin")){
		if(artgallery.logIn(penName, password)){
			artgallery.setPenName(penName);
			request.getRequestDispatcher("/authors_page.jsp").forward(request, response);
		}		
	}
%>

<body>
	<center>
		<form action="Controller">
			<h1>Art Gallery System</h1>
			Pen Name: <input type="text" name="penname"/><br />
			Password: <input type="password" name="password"/><br /><br />
			<button type="submit" name="btn" value="signin">Sign In</button>
		</form>
		<form action="Controller">
			<button type="submit" name="btn" value="signup">Sign Up</button><br />
			<button type="submit" name="btn" value="backtomain">Back to Main Page</button>
		</form>
		
		<br /><br />
		
		<%=artgallery.getMessage() %>
		<%artgallery.setMessage(""); %>
	</center>
</body>
</html>