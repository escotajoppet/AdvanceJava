<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library System</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/borrowbook.css" />
</head>

<jsp:useBean id="librarySystem" class="library.system.LibrarySystem" scope="session"/>

<%
	String studentName = request.getParameter("studentname");
	String studentNumber = request.getParameter("studentnumber");
	String[] bookstoborrow = request.getParameterValues("checkedborrow");

	String btn = request.getParameter("btn");
	
	if(btn!=null && btn.equals("borrow")){
		librarySystem.clear();
		librarySystem.borrowBooks(studentName, studentNumber, "Borrow Book(s)", bookstoborrow);
		request.getRequestDispatcher("/guestPage.jsp").forward(request, response);
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
		<label for="" class="text2">Student Number: </label><input type="text" name="studentnumber" class="input2"  REQUIRED/>
		<label for="" class="text1">Student Name: </label><input type="text" name="studentname" class="input1"  REQUIRED/> <br />
	</div>
	
	<table border="1">
		<tr>
			<th><input type="checkbox" id="checkall" /></th>
			<th>Control No.</th>
			<th>Book Title</th>
			<th>Author</th>
			<th>Year Published</th>
		</tr>
		<%
			
			for(int i = 0; i<librarySystem.getControlNumber().size(); i++){
		%>
			<tr>
				<td><input type="checkbox" name="checkedborrow" value="<%=librarySystem.getControlNumber().get(i)%>" CHECKED/></td>
				<td><%=librarySystem.getControlNumber().get(i)%></td>
				<td><%=librarySystem.getBook_title().get(i)%></td>
				<td><%=librarySystem.getAuthor().get(i)%></td>
				<td><%=librarySystem.getYear_published().get(i)%></td>
			</tr>
		<%		
			}
		%>	
	</table>
			<button type="submit" name="btn" value="borrow" class="borrow" ></button>
		</form>
		<form action="Controller">
			<button type="submit" name="btn" value="back2" class="back"></button>
		</form>
	<div id="footer">
	</div>
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
</body>
</html>