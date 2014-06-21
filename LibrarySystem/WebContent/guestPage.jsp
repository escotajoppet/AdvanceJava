<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Library System</title>
	<link rel="stylesheet" href="css/main.css" />
	<link rel="stylesheet" href="css/guestlogin.css" />
</head>

<jsp:useBean id="librarySystem" class="library.system.LibrarySystem" scope="session"/>

<%
	String guestsearch = request.getParameter("guestSearch");
	String category = request.getParameter("category");
	String btn = request.getParameter("btn");
	
	String[] bookstoborrow = request.getParameterValues("checkedborrow");
	
	if(btn != null && btn.equals("guestsearch")){
		librarySystem.search(guestsearch, category);
	}else if(btn != null && btn.equals("borrowbook")){
		librarySystem.clear();
		librarySystem.setBooksToBorrow(bookstoborrow);
		request.getRequestDispatcher("/borrowBook.jsp").forward(request, response);
	}else if(btn != null && btn.equals("viewallbooksguest")){
		librarySystem.viewAllBooks();
	}
%>

<body>
	<div id="main">
	<div id="header">
		<img src="img/logo.png" alt="" />
		<h1>Library</h1>
	</div>
	<div id="GuestLoggedIn">
		<h1>Welcome Guest! </h1> <br />
		<form action="Controller" method="get" id="guest1">
		<input type="text" class="guestSearch" name="guestSearch" placeholder="Search Book" REQUIRED/>
		<select name="category" id="category">
			<option value="control_number">Control Number</option>
			<option value="book_title" SELECTED>Book Title</option>
			<option value="author">Author</option>
			<option value="year_published">Year Published</option>
		</select>
		<button type="submit" name="btn" value="guestsearch" class="guestsearch"></button>
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
					for(int i = 0; i<librarySystem.getControlNumber().size(); i++){
						String ifAvailable = librarySystem.getAvailability().size()==0 ? "" : librarySystem.getAvailability().get(i);
				%>
					<tr>
						<td><input type="checkbox" name="checkedborrow" value="<%=librarySystem.getControlNumber().get(i)%>" <%=ifAvailable.equals("Available") ? "" : "DISABLED" %>/></td>
						<td><%=librarySystem.getControlNumber().get(i) %></td>
						<td><%=librarySystem.getBook_title().get(i) %></td>
						<td><%=librarySystem.getAuthor().get(i) %></td>
						<td><%=librarySystem.getYear_published().get(i) %></td>
						<td><%=ifAvailable %></td>
					</tr>
				<%
					} librarySystem.setMessage(""); librarySystem.clear();
				%>
	
			</table>
		
		
		<center>
			<button type="submit" name="btn" value="borrowbook" class="borrowbook"></button>
	</center>
		</form>
		<center>
		<form action="Controller" method="get" id="guest1">
		<button type="submit" name="btn" value="viewallbooksguest" class="viewallbooks" ></button>
			<button type="submit" name="btn" value="returnbook" class="returnbook"></button><br /> <br />
			<span><a href="index.jsp" class="backtomainpage">Back to Main Page</a></span>
			</center>
		</form>
		
	</div>
	<div id="footer">
		<%=librarySystem.getMessage() %>
		<%librarySystem.setMessage(""); %>
	</div>
	<script type="text/javascript">
		window.onload = function(){
			checkAll();
		}
	
		function checkAll(){
			var classes = document.getElementsByName("checkedborrow");
			
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
</div>
</body>
</html>