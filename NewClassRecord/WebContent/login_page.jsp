<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>

<jsp:useBean id="classRecord" class="classes.record.ClassRecordManager" scope="session"/>

<%
	String facultyId = request.getParameter("loginfacultyid");
	String password = request.getParameter("loginpassword");
	String btn = request.getParameter("btn");
	
	if(session.getAttribute("id")!=null){
		request.getRequestDispatcher("/class_list_page.jsp").forward(request, response);
	}
	
	if(btn!=null && btn.equals("facultylogin")){
		if(classRecord.login("faculty", facultyId, password)){
			session.setAttribute("id", facultyId);
			classRecord.clearFacultyInfo();
			request.getRequestDispatcher("/class_list_page.jsp").forward(request, response);
		}
	}
%>

<body>
	<center>
		<h1>Class Record</h1>
		<h3>Login Information</h3>
		<form action="ClassController" method="post">
			<label for="">Faculty Id: <input type="text" name="loginfacultyid"/></label><br />
			<label for="">Password: <input type="password" name="loginpassword"/></label><br /><br />
			<button type="submit" name="btn" value="facultylogin">Log In</button>
		</form>
		
		<br />
		
		<form action="ClassController" method="post">
			<button type="submit" name="btn" value="facultyregister">Register New Faculty</button>
		</form>
		<br /><br />
		<%=classRecord.getMessage() %>
		<%classRecord.setMessage(""); %>
	</center>
</body>
</html>