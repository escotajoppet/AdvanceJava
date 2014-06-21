<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students List</title>
</head>

<jsp:useBean id="classRecord" class="classes.record.ClassRecordManager" scope="session"/>

<%
	if(session.getAttribute("id")==null || classRecord.getLoggedId().equals("")){
		session.invalidate();
		request.getRequestDispatcher("/login_page.jsp").forward(request, response);
	}

	String btn = request.getParameter("btn");

	if(btn!=null && btn.equals("studentlogout")){
		session.invalidate();
		request.getRequestDispatcher("/login_page.jsp").forward(request, response);
	} else if(btn!=null && btn.startsWith("dls")){
		classRecord.delete("student", btn.substring(4));
	} else if(btn!=null && btn.startsWith("grd")){
		String[] students = btn.split("/");
		String selectedSubjectCode = students[0].substring(4);
		String selectedStudentId = students[1];
		String selectedStudentName = students[2];
		
		classRecord.setGradeSelectedSubjectCode(selectedSubjectCode);
		classRecord.setGradeSelectedStudentId(selectedStudentId);
		classRecord.setGradeSelectedStudentName(selectedStudentName);
		request.getRequestDispatcher("/grade_sheet_page.jsp").forward(request, response);
	}
	
	classRecord.clearStudentInfo();
	classRecord.setTable("student");
%>

<body>
	<center>
		<h1>Class Record</h1>
		<h2>Student List</h2>
		<h3>Faculty: <%=classRecord.getLoggedName() %></h3>
		<form action="ClassController" method="post">
			<table border="1" cellpadding="5">
				<tr>
					<th>Subject Code</th>
					<th>Student Id</th>
					<th>Student Name</th>
					<th>Year And Section</th>
					<th colspan="2">Actions</th>
				</tr>

				<%
					for(int i = 0; i<classRecord.getStudentEntryNumber().size(); i++){
				%>
					<tr>
						<td><%=classRecord.getStudentSubjectCode().get(i) %></td>
						<td><%=classRecord.getStudentId().get(i) %></td>
						<td><%=classRecord.getStudentName().get(i) %></td>
						<td><%=classRecord.getStudentYearAndSection().get(i) %></td>
						<td><button type="submit" name="btn" value="grd <%=classRecord.getStudentSubjectCode().get(i) %>/<%=classRecord.getStudentId().get(i) %>/<%=classRecord.getStudentName().get(i) %>">View Grades</button></td>
						<td><button type="submit" name="btn" value="dls <%=classRecord.getStudentEntryNumber().get(i) %>">Delete</button></td>
					</tr>
				<%	
					}				
				%>
			</table>
			
			<br />
			
			<button type="submit" name="btn" value="backtoclasslist">Back</button>
			<button type="submit" name="btn" value="addnewstudent">Add New Student</button>
			<button type="submit" name="btn" value="studentlogout">Log Out</button>
		</form>
		
		<br /><br />
		
		<%=classRecord.getMessage() %>
		<%classRecord.setMessage(""); %>
	</center>
</body>
</html>