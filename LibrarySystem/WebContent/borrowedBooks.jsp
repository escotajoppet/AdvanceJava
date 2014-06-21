<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library System</title>
<link rel="stylesheet" href="css/main.css" />
	<link rel="stylesheet" href="css/borrowedbooks.css" /> 
</head>
<jsp:useBean id="librarySystem" class="library.system.LibrarySystem" scope="session"/>

<%
	librarySystem.viewBorrowedBooks();
%>

<body>
<div id="main">
	<div id="header">
		<img src="img/logo.png" alt="" />
		<h1>Library</h1>
	</div>
	<h3>Borrowed Books</h3>
	<center>
	
		<table border="1" cellpadding="5">
			<tr>
				<th>Control Number</th>
				<th>Book Title</th>
				<th>Author</th>
				<th>Year Published</th>
				<th>Borrower</th>
			</tr>
			
			<%
				for(int i = 0; i<librarySystem.getBorrowedControlNumber().size(); i++){
			%>
				<tr>
					<td><%=librarySystem.getBorrowedControlNumber().get(i) %></td>
					<td><%=librarySystem.getBorrowedBookTitle().get(i) %></td>
					<td><%=librarySystem.getBorrowedAuthor().get(i) %></td>
					<td><%=librarySystem.getBorrowedYearPublished().get(i) %></td>
					<td><%=librarySystem.getBorrowedBorrower().get(i) %></td>
				</tr>
			<%
				} librarySystem.clearBorrowed();
			%>
		</table>
		
		<br />
		
		<form action="Controller"><button type="submit" name="btn" value="back" class="back" ></button></form>
	</center>
	<div id="footer">
		<%=librarySystem.getMessage() %>
		<%librarySystem.setMessage(""); %>
	</div>
</div>
</body>
</html>