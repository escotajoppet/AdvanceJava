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
	String category = request.getParameter("category");
	String artTitle = request.getParameter("arttitle");
	String artLocation = request.getParameter("artlocation");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("addart")){
		artgallery.addNewArt(category, artTitle, artLocation);
	}
%>

<body>
	<center>
		<h1>Art Gallery System</h1>
		<h3>Add An Art</h3>
		
		<form action="Controller">
			<select name="category" id="">
				<option value="">Category...</option>
				<option value="Painting">Painting</option>
				<option value="Craft">Craft</option>
				<option value="Sculpture">Sculpture</option>
				<option value="Photograph">Photograph</option>
			</select>
			
			<br /><br />
			
			Art Title: <input type="text" name="arttitle" REQUIRED/><br />
			Art Location: <input type="text" name="artlocation" REQUIRED/><br /><br />
			
			
			<button type="submit" name="btn" value="addart">Add New Art</button>
		</form>
		
		<br />
		
		<form action="Controller">
			<button type="submit" name="btn" value="backtoauthor">Back</button>
			<button type="submit" name="btn" value="logout">Log Out</button>
		</form>
		
		<br /><br />
		
		<%=artgallery.getMessage() %>
		<%artgallery.setMessage(""); %>
	</center>
</body>
</html>