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
	artgallery.clearComments();
	artgallery.viewComments();
%>

<body>
	<center>
		<h1>Art Gallery System</h1>
		Comments for <strong><%=artgallery.getSelectedArtTitle() %></strong>
		
		<br /><br />
		
		<table border="2" cellpadding="5">
			<tr>
				<th>Comment Id</th>
				<th>Comment</th>
			</tr>
			
			<%
				for(int i = 0; i<artgallery.getCommentArtId().size(); i++){
			%>
				<tr>
					<td><%=artgallery.getCommentArtId().get(i) %></td>
					<td><%=artgallery.getCommentComments().get(i) %></td>
				</tr>
			<%
				}
			%>
		</table>
		
		<br /><br />
		
		<form action="Controller"><button type="submit" name="btn" value="backcomment">Back</button></form>
	</center>
</body>
</html>