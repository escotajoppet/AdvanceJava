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
	String btn = request.getParameter("btn");

	String newArtTitle = request.getParameter("newarttitle");
	String newCategory = request.getParameter("newcategory");

	if(btn!=null && btn.equals("confirmupdate")){
		artgallery.updateArt(newArtTitle, newCategory);
		request.getRequestDispatcher("/view_contributions.jsp").forward(request, response);
	}
%>

<body>
	<center>
		<h1>Art Gallery System</h1>
		<h3>Edit Art</h3>
		<form action="Controller">
			Art Entry Date: <strong><%=artgallery.getSelectedEntryDate() %></strong> <br /><br />
			Author: <strong><%=artgallery.getPenName() %></strong> <br /><br />
			Art Title: <input type="text" name="newarttitle" value="<%=artgallery.getSelectedArtTitle() %>" size="<%=artgallery.getSelectedArtTitle().length()%>"/><br /><br />
			
			Category: 
			<select name="newcategory" id="">
				<option value="Painting" <%=artgallery.getSelectedTableName().equals("painting") ? "SELECTED" : "" %>>Painting</option>
				<option value="Craft" <%=artgallery.getSelectedTableName().equals("craft") ? "SELECTED" : "" %>>Craft</option>
				<option value="Sculpture" <%=artgallery.getSelectedTableName().equals("sculpture") ? "SELECTED" : "" %>>Sculpture</option>
				<option value="Photograph" <%=artgallery.getSelectedTableName().equals("photograph") ? "SELECTED" : "" %>>Photograph</option>
			</select>
			
			<br /><br /><br />
			
			<button type="submit" name="btn" value="confirmupdate">Update Art</button>
			<button type="submit" name="btn" value="cancel">Cancel</button>
		</form>
	</center>
</body>
</html>