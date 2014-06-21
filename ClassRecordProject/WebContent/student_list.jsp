<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/main.css" />
<title>Class Record Project: Students Page</title>
</head>

<jsp:useBean id="classrecord" class="classes.record.ClassRecord" scope="session"/>

<%
	String message = "";

	String[] students = request.getParameterValues("students");
	String getStudent = request.getParameter("getstudent");
	String back = request.getParameter("back");
	String addNewStudent = request.getParameter("addnewstudent");
	String deleteStudent = request.getParameter("deletestudent");
	
	if(back!=null){
		%><jsp:forward page="ClassList"/><%
	} else if(getStudent!=null){
		classrecord.setNameOfStudent(getStudent);
		classrecord.setStudent(getStudent);
		%><jsp:forward page="GradeSheet"/><%
	} else if(addNewStudent!=null){
		%><jsp:forward page="AddNewStudent"/><%
	} else if(deleteStudent!=null){
		classrecord.deleteStudent(students);
	}
	
	message = classrecord.getMessage();
	
	classrecord.setStudents();
%>

<body>
	<center>
		<div class="panel panel-info tabled">
			<div class="panel-heading">
				<h4>Class <%=classrecord.getClassSection() %></h4>			
			</div>
			
			<div class="panel-body">
				<form action="StudentList">
					<table class="table table-bordered table-hover">
						<tr class="active">
							<th><input type="checkbox" id="checkAllStudents" <%=classrecord.getStudentRow()==0 ? "DISABLED" : "" %>/></th>
							<th>Student ID</th>
							<th>Name</th>
							<th>Address</th>
							<th>Gender</th>
							<th>Contact</th>
						</tr>
						
						<%for(int i = 0; i<classrecord.getStudentId().size(); i++){%>
							<tr>
								<td class="active"><input type="checkbox" name="students" value="<%=classrecord.getStudentId().get(i) %>" class="checkbox"/></td>
								<td><input type="submit" name="getstudent" value="<%=classrecord.getStudentId().get(i)%>" class="btn btn-success buton-class"/></td>
								<td><%=classrecord.getStudentName().get(i) %></td>
								<td><%=classrecord.getStudentAddress().get(i) %></td>
								<td><%=classrecord.getStudentGender().get(i) %></td>
								<td><%=classrecord.getStudentContact().get(i) %></td>
							</tr>
						<%}
							classrecord.clearLists();
						%>
							
					</table>
					
					<hr />
					
					<input type="submit" name="addnewstudent" value="Add New Student" class="btn btn-primary buton"/>
					<input type="submit" name="back" value="Back to Class List" class="btn btn-info buton"/>
					<input type="submit" name="deletestudent" value="Delete Student" <%=classrecord.getStudentRow()==0 ? "DISABLED" : "" %> class="btn btn-danger buton"/>
				</form>
				
				<br />
				
				<%if(!message.equals("")){%>
					<div class="alert alert-danger">
						<%=message %>
					</div>		
				<%
						classrecord.setMessage("");
					}
				%>
			</div>
		</div>
		
	</center>
	
	<script type="text/javascript">
		document.getElementById("checkAllStudents").onclick = function(){
			var classes = document.getElementsByName("students");
			
			if(document.getElementById("checkAllStudents").checked){
				for(var i = 0; i< classes.length; i++){
					classes[i].checked  = true;
				}
			} else{			
				for(var i = 0; i< classes.length; i++){
					classes[i].checked  = false;
				}
			}
		};
	</script>
</body>
</html>