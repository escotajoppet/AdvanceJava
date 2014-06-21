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

<jsp:useBean id="classRecord" class="classes.record.NewClassRecord" scope="session"/>

<%
	String message = "";
	String btn = request.getParameter("btn");
	
	String[] students = request.getParameterValues("students");
	
	if(btn!=null && btn.equals("deletestudent")){
		classRecord.delete(students, "students");
	} else if(btn!=null && btn.startsWith("grd ")){
		classRecord.setStudent(btn.substring(4));
		classRecord.setStudentsName();
		request.getRequestDispatcher("/GradeSheet").forward(request, response);
	}

	message = classRecord.getMessage();
	
	classRecord.clearStudentLists();
	classRecord.setList("students");
%>

<body>
	<center>
		<div class="panel panel-info tabled">
			<div class="panel-heading">
				<h4><%=classRecord.getClassInfo() %> Class</h4>			
			</div>
			
			<div class="panel-body">
				<form action="MainPageController">
					<table class="table table-bordered table-hover">
						<tr class="active">
							<th><input type="checkbox" id="checkAllStudents" <%=classRecord.getRow("students")==0 ? "DISABLED" : "" %>/></th>
							<th>Student ID</th>
							<th>Name</th>
							<th>Address</th>
							<th>Gender</th>
							<th>Contact</th>
							<th></th>
						</tr>
						
						<%for(int i = 0; i<classRecord.getStudentId().size(); i++){%>
							<tr>
								<td class="active"><input type="checkbox" name="students" value="<%=classRecord.getStudentId().get(i) %>" class="checkbox"/></td>
								<td><%=classRecord.getStudentId().get(i) %></td>
								<td><%=classRecord.getStudentName().get(i) %></td>
								<td><%=classRecord.getStudentAddress().get(i) %></td>
								<td><%=classRecord.getStudentGender().get(i) %></td>
								<td><%=classRecord.getStudentContact().get(i) %></td>
								<td><button type="submit" name="btn" value="grd <%=classRecord.getStudentId().get(i) %>" class="btn btn-success btn-sm buton-class">View Grades</button></td>
							</tr>
						<%
							}	
						%>
							
					</table>
					
					<hr />
					
					<button type="submit" name="btn" value="addnewstudent" class="btn btn-primary buton">Add New Student</button>
					<button type="submit" name="btn" value="backtoclasslist" class="btn btn-info buton">Back to Class List</button>
					<button type="submit" name="btn" value="deletestudent" class="btn btn-danger buton" <%=classRecord.getRow("students")==0 ? "DISABLED" : "" %>>Delete Student(s)</button>
					
				</form>
				
				<br />
				
				<%if(!message.equals("")){%>
					<div class="alert alert-danger">
						<%=message %>
					</div>		
				<%
						classRecord.setMessage("");
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