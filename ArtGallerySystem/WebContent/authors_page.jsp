<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="artgallery" class="art.gallery.ArtGallery" scope="session"/>

<body>
	<center>
		<h1>Art Gallery System</h1>
		<h3>Welcome, <%=artgallery.getPenName() %></h3>
		<form action="Controller">
			<button type="submit" name="btn" value="addnewart">Add An Art</button>
			<button type="submit" name="btn" value="viewcontributions">View Contributions</button>
			<button type="submit" name="btn" value="logout">Log Out</button>
		</form>
	</center>
</body>
</html>