<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="artgallery" class="art.gallery.ArtGallery" scope="session"/>

<%!String isDisabled = "DISABLED"; String updateValue = "naknang";%>

<%
	String btn = request.getParameter("btn");
	String[] updateCategories = request.getParameterValues("updatecategory");
	String updateValue2 = updateValue.equals("naknang") ? "Update Categories" : "Confirm Update";
	
	if(btn!=null && btn.startsWith("del ")){
		String entryNumber = btn.substring(4);
		artgallery.deleteArt(entryNumber);
		
	} else if(btn!=null && (btn.equals("naknang") || btn.equals("naknang2"))){
		if(updateValue.equals("naknang")){
			isDisabled = "";
			updateValue = "naknang2";
			updateValue2 = "Confirm Update";
		} else{
			isDisabled = "Disabled";
			updateValue = "naknang";
			updateValue2 = "Update Categories";
			
			artgallery.viewContributions();
			artgallery.confirmUpdate(updateCategories);
			artgallery.clearArtInfo();
		}
	} else if(btn!=null && btn.startsWith("vcm")){
		artgallery.setSelectedEntryId(Integer.parseInt(btn.substring(3, 4)));
		artgallery.setSelectedArtTitle(btn.substring(4));
		request.getRequestDispatcher("/view_comments.jsp").forward(request, response);
	}
	
	artgallery.viewContributions();
%>

<body>
	<center>
		<h1>Art Gallery System</h1>
		<h3>Distributions of <%=artgallery.getPenName() %></h3>
		
			<form action="Controller">
			<%
				for(int i = 0; i<artgallery.getArtEntryNumber().size(); i++){
			%>
				<table border="2" cellpadding="5">
					<tr>
						<th colspan="5"><%=artgallery.getArtEntryTitle().get(i) %></th>
					</tr>
					<tr>
						<th>Art Id</th>
						<th>Category</th>
						<th>Entry Date</th>
						<th>Gallery Location</th>
					</tr>
					<tr>
						<td><%=artgallery.getArtEntryNumber().get(i) %></td>
						<td>
							<select name="updatecategory" id="" <%=isDisabled %>>
								<option value="Painting" <%=artgallery.getArtCategory().get(i).equals("Painting") ? "SELECTED" : ""%>>Painting</option>
								<option value="Craft" <%=artgallery.getArtCategory().get(i).equals("Craft") ? "SELECTED" : ""%>>Craft</option>
								<option value="Sculpture" <%=artgallery.getArtCategory().get(i).equals("Sculpture") ? "SELECTED" : ""%>>Sculpture</option>
								<option value="Photograph" <%=artgallery.getArtCategory().get(i).equals("Photograph") ? "SELECTED" : ""%>>Photograph</option>
							</select>
						</td>
						<td><%=artgallery.getArtEntryDate().get(i) %></td>
						<td><%=artgallery.getArtLocation().get(i) %></td>
					</tr>
					<tr>
						<td colspan="5">
							<button type="submit" name="btn" value="del <%=artgallery.getArtEntryNumber().get(i) %>" style="width: 49%;">Delete Artwork</button>
							<button type="submit" name="btn" value="vcm<%=artgallery.getArtEntryNumber().get(i) %><%=artgallery.getArtEntryTitle().get(i)%>" style="width: 49%;">View Comments</button>
						</td>
					</tr>
				</table>
				
				<br />
				
			<%
				} artgallery.clearArtInfo();
			%>
			
			<button type="submit" name="btn" value="<%=updateValue%>"><%=updateValue2%></button>
		</form>
		<br />
		
		<form action="Controller">
			<button type="submit" name="btn" value="backtoauthorpage">Back</button>
			<button type="submit" name="btn" value="logout">Log Out</button>
		</form>
		
		<%=artgallery.getMessage() %>
		<%artgallery.setMessage("");  %>
	</center>
</body>
</html>