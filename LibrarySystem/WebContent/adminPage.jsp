<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Library System</title>
	<link rel="stylesheet" href="css/main.css" />
	<link rel="stylesheet" href="css/adminlogin.css" />
</head>

<jsp:useBean id="librarySystem" class="library.system.LibrarySystem" scope="session"/>

<%
	String adminsearch = request.getParameter("adminsearch");
	String category = request.getParameter("category");
	String btn = request.getParameter("btn");
	
	String[] deletebooks = request.getParameterValues("checkeddelete");
	
	if(btn != null && btn.equals("adminsearch")){
		librarySystem.search(adminsearch, category);
	}else if(btn != null && btn.equals("deletebook")){
		librarySystem.deletebook(deletebooks);
	}else if(btn != null && btn.equals("viewallbooks")){
		librarySystem.viewAllBooks();
	}
	
%>
<body>
	<div id="main">
	<div id="header">
		<img src="img/logo.png" alt="" />
		<h1>Library</h1>
	</div>
	<div id="AdminLoggedIn">
		<h1>Logged In as Admin,</h1>
		<form action="Controller">
			<button type="submit" name="btn" value="adminlogout" class="logout"></button><br />
		</form>
		<form action="Controller">	
			<input type="text" class="adminSearch" value="" name="adminsearch" placeholder="Search Book" REQUIRED/>
			<select name="category" id="category">
				<option value="control_number">Control Number</option>
				<option value="book_title" SELECTED>Book Title</option>
				<option value="author">Author</option>
				<option value="year_published">Year Published</option>
			</select>
			<button type="submit" name="btn" value="adminsearch" class="adminsearch"></button>
		</form>

		<form action="Controller">
			<table border="1">
				<tr>
					<th><input type="checkbox" id="checkall" /></th>
					<th>Control No.</th>
					<th>Book Title</th>
					<th>Author</th>
					<th>Year Published</th>
					<th>Availability</th>
				</tr>
				<%
				for(int i=0; i<librarySystem.getControlNumber().size(); i++){
					%>
				<tr>
					<td><input type="checkbox" name="checkeddelete" value="<%=librarySystem.getControlNumber().get(i)%>"/></td>
					<td><%=librarySystem.getControlNumber().get(i)%></td>
					<td><%=librarySystem.getBook_title().get(i)%></td>
					<td><%=librarySystem.getAuthor().get(i)%></td>
					<td><%=librarySystem.getYear_published().get(i)%></td>
					<td><%=librarySystem.getAvailability().get(i)%></td>
				</tr>
					<%
				} librarySystem.clear(); librarySystem.clearBorrowed();
				%>
			</table>
		<center>
			<button type="submit" name="btn" value="viewallbooks" class="viewallbooks" ></button>
			<button type="submit" name="btn" value="addbook" class="addbook"></button>
			<button type="submit" name="btn" value="deletebook" class="deletebook"></button>
			<button type="submit" name="btn" value="viewguestlogs" class="viewguestlogs"></button>
			<button type="submit" name="btn" value="viewborrowedbooks" class="viewborrowedbooks"></button>
		</center>
		</form>
	</div>
	<div id="footer">
	<%=librarySystem.getMessage() %>
		<%librarySystem.setMessage(""); %>
	</div>
</div>
<script type="text/javascript">
		window.onload = function(){
			checkAll();
		}
	
		function checkAll(){
			var classes = document.getElementsByName("checkeddelete");
			
			document.getElementById("checkall").onclick = function(){				
				if(document.getElementById("checkall").checked){
					for(var i = 0; i< classes.length; i++){
						classes[i].checked  = true;
					}
				} else{			
					for(var i = 0; i< classes.length; i++){
						classes[i].checked  = false;
					}
				}
			};
		}
	</script>
</body>
</html>