<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library System</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/returnbook.css" />
</head>

<jsp:useBean id="librarySystem" class="library.system.LibrarySystem" scope="session"/>

<%
	String studentName = request.getParameter("studentname");
	String studentNumber = request.getParameter("studentnumber");
	String[] bookstoreturn= request.getParameterValues("checkedreturn");

	String btn = request.getParameter("btn");
	
	if(btn!=null && btn.equals("return2")){
		librarySystem.clear();	
		librarySystem.returnBooks("Returned Book(s)", bookstoreturn);
		request.getRequestDispatcher("/guestPage.jsp").forward(request, response);
	} else if(btn!=null && btn.equals("setid")){
		librarySystem.setId(studentNumber);
		librarySystem.setName(studentName);
		librarySystem.setBooksToReturn();	
	}	
%>

<body>
	<div id="main">
	<div id="header">
		<img src="img/logo.png" alt="" />
		<h1>Library</h1>
	</div>
	<h3>Borrower's Information</h3>
	
	<form action="Controller">
		<div id="Info">
			<label for="" class="text2">Student Number: </label><input type="text" name="studentnumber" class="input2" REQUIRED/>
			<label for="" class="text1">Student Name: </label><input type="text" name="studentname" class="input1" REQUIRED/><br /><br />
			<button type="submit" value="setid" name="btn">Set Student</button>
		</div>
		</form>
		<form action="Controller">
		<table border="1">
			<tr>
				<th><input type="checkbox" id="checkall" /></th>
				<th>Control No.</th>
				<th>Book Title</th>
				<th>Author</th>
				<th>Year Published</th>
			</tr>
			<%
				for(int i = 0; i<librarySystem.getBorrowedControlNumber().size(); i++){
			%>
				<tr>
					<td><input type="checkbox" name="checkedreturn" value="<%=librarySystem.getBorrowedControlNumber().get(i)%>" CHECKED/></td>
					<td><%=librarySystem.getBorrowedControlNumber().get(i)%></td>
					<td><%=librarySystem.getBorrowedBookTitle().get(i)%></td>
					<td><%=librarySystem.getBorrowedAuthor().get(i)%></td>
					<td><%=librarySystem.getBorrowedYearPublished().get(i)%></td>
				</tr>
			<%		
				} librarySystem.clearBorrowed();
			%>
		</table>
		<button type="submit" name="btn" value="return2" class="return" ></button>
	</form>
	
	<form action="Controller">
		<button type="submit" name="btn" value="back2" class="back"></button>
	</form>
	
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
			var classes = document.getElementsByName("checkedreturn");
			
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