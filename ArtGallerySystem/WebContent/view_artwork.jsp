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
	String searchBy = request.getParameter("searchby");
	String searchKeyword = request.getParameter("searchartwork");
	String viewerComment = request.getParameter("viewercomment");
	
	if(searchBy==null || searchBy.equals("")){
		artgallery.searchArtwork("", "");
	} else if(btn!=null && btn.equals("searchart")){
		artgallery.searchArtwork(searchKeyword, searchBy);
	} 
	
	if(btn!=null && btn.startsWith("com")){
		artgallery.postComment(btn, viewerComment);
	}

	
%>

<body>
	<center>
		<h1>Art Gallery System</h1>
		<form action="Controller">
			<input type="text" size="50" name="searchartwork" placeholder="Enter Keyword Here"/>
			<select name="searchby" id="">
				<option value="arttitle">Art Title</option>
				<option value="author">Author</option>
			</select> 
			<button type="submit" name="btn" value="searchart">Search</button>
		</form>
			<br />
			
			<%
				for(int i = 0; i<artgallery.getArtEntryNumber().size(); i++){
			%>
				<table border="2">
					<tr>
						<th colspan="5"><%=artgallery.getArtEntryTitle().get(i) %></th>
					</tr>
					<tr>
						<th>Art Id</th>
						<th>Author</th>
						<th>Category</th>
						<th>Entry Date</th>
						<th>Gallery Location</th>
					</tr>
					<tr>
						<td><%=artgallery.getArtEntryNumber().get(i) %></td>
						<td><%=artgallery.getArtAuthor().get(i) %></td>
						<td><%=artgallery.getArtCategory().get(i) %></td>
						<td><%=artgallery.getArtEntryDate().get(i) %></td>
						<td><%=artgallery.getArtLocation().get(i) %></td>
					</tr>
					<tr>
						<td colspan="5"><form action="Controller"><input type="text" name="viewercomment" size="70%"/><button type="submit" name="btn" value="com/<%=artgallery.getArtEntryNumber().get(i) %>/<%=artgallery.getArtEntryTitle().get(i) %>/<%=artgallery.getArtAuthor().get(i) %>">Submit Comment</button></form></td>
					</tr>
				</table>
				<br />
			<%
				} artgallery.clearArtInfo();
			%>
		
		<br />
		
		<form action="Controller"><button type="submit" name="btn" value="backtomainpage">Back to Main Page</button></form>
		
		<br /><br />
		
		<%=artgallery.getMessage() %>
		<%artgallery.setMessage(""); %>
	</center>
</body>
</html>