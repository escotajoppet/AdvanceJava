<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Class List</title>
</head>

<jsp:useBean id="classRecord" class="classes.record.ClassRecordManager" scope="session"/>

<%
	if(session.getAttribute("id")==null || classRecord.getLoggedId().equals("")){
		session.invalidate();
		request.getRequestDispatcher("/login_page.jsp").forward(request, response);
	}

	String btn = request.getParameter("btn");

	if(btn!=null && btn.startsWith("vcs ")){
		classRecord.setSelectedClassSchedule(btn.substring(4).split("#")[1]);
		classRecord.setSelectedClassSubjectCode(btn.substring(4).split("#")[0]);
		classRecord.setSelectedClassSubjectName(btn.substring(4).split("#")[2]);
		request.getRequestDispatcher("/student_list_page.jsp").forward(request, response);
	} else if(btn!=null && btn.startsWith("del ")){
		classRecord.delete("class", btn.substring(4));
	} else if(btn!=null && btn.equals("classlogout")){
		session.invalidate();
		request.getRequestDispatcher("/login_page.jsp").forward(request, response);
	}

	classRecord.clearClassInfo();
	classRecord.setTable("class");
%>

<body>
	<center>
		<h1>Class Record</h1>
		<h2>Class List</h2>
		<h3>Faculty: <%=classRecord.getLoggedName() %></h3>
		<form action="ClassController" method="post">
			<table border="1" cellpadding="5">
				<tr>
					<th>Year and Section</th>
					<th>Subject Code</th>
					<th>Subject Name</th>
					<th>School Year</th>
					<th>Semester</th>
					<th>Schedule</th>
					<th colspan="2">Actions</th>
				</tr>
				
				<%
					for(int i = 0; i < classRecord.getClassSubjectCode().size(); i++){
				%>
					<tr>
						<td><%=classRecord.getClassYearAndSection().get(i) %></td>
						<td><%=classRecord.getClassSubjectCode().get(i) %></td>
						<td><%=classRecord.getClassSubjectName().get(i) %></td>
						<td><%=classRecord.getClassSchoolYear().get(i) %></td>
						<td><%=classRecord.getClassSemester().get(i) %></td>
						<td><%=classRecord.getClassSchedule().get(i).replace("/", "<br />") %></td>
						<td><button type="submit" name="btn" value="vcs <%=classRecord.getClassSubjectCode().get(i) %>#<%=classRecord.getClassSchedule().get(i) %>#<%=classRecord.getClassSubjectName().get(i) %>">View</button></td>
						<td><button type="submit" name="btn" value="del <%=classRecord.getClassEntryNumber().get(i) %>">Remove</button></td>
					</tr>
				<%
					}
				%>
			</table>
			
			<br />
			
			<button type="submit" name="btn" value="addnewclass">Add New Class</button>
			<button type="submit" name="btn" value="classlogout">Log Out</button>
		</form>
		
		<br /><br />
		
		<%=classRecord.getMessage() %>
		<%classRecord.setMessage(""); %>
	</center>
</body>
</html>