<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/main.css" />
<title>Class Record Project: Classes Page</title>
</head>

<jsp:useBean id="classRecord" class="classes.record.NewClassRecord" scope="session"/>

<%
	String message = "";
	String btn = request.getParameter("btn");
	
	String[] classes = request.getParameterValues("classes");
	
	if(btn!=null && btn.startsWith("std ")){
		classRecord.setClassInfo(btn.substring(4));
		request.getRequestDispatcher("/StudentList").forward(request, response);		
	} else if(btn!=null && btn.equals("deleteclass")){
		classRecord.delete(classes, "classes");
	}

	message = classRecord.getMessage();
	classRecord.clearClassLists();
	classRecord.setList("classes");
%>

<body>
	<center>
		<div class="panel panel-primary tabled">
			<div class="panel-heading">
				<h4>Class List</h4>
			</div>
			
			<div class="panel-body">
				<form action="MainPageController">
					<table class="table table-bordered table-hover">
						<tr class="active">
							<th><input type="checkbox" id="checkAllClasses" <%=classRecord.getRow("classes")<1 ? "DISABLED" : "" %>/></th>
							<th>List of Students</th>
							<th>Number of Students</th>
							<th>Class Schedule</th>
							<th></th>
						</tr>
						<%
							for(int i = 0;i<classRecord.getClassYearSection().size(); i++){
								String classSchedule = classRecord.getClassSchedule().get(i).replace("/", "<br />");
						%>
							<tr>
								<td class="active"><input type="checkbox" name="classes" value="<%=classRecord.getClassYearSection().get(i) %>" /></td>
								<td><%=classRecord.getClassYearSection().get(i) %></td>
								<td><%=classRecord.getNumberOfStudents().get(i) %></td>
								<td><%=classSchedule %></td>
								<td><button type="submit" name="btn" value="std <%=classRecord.getClassYearSection().get(i) %>" class="btn btn-success btn-sm buton-class">View Students</button></td>
							</tr>
						<%	
							}
						%>
									
					</table>
					
					<hr />
					
					<button type="submit" name="btn" value="addnewclass" class="btn btn-primary buton">Add New Class</button>
					<button type="submit" name="btn" value="deleteclass" class="btn btn-danger buton" id="btndel" <%=classRecord.getRow("classes")==0 ? "DISABLED" : "" %>>Delete Class</button>
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
		window.onload = function(){
			checkAll();
		}
	
		function checkAll(){
			var classes = document.getElementsByName("classes");
			
			document.getElementById("checkAllClasses").onclick = function(){				
				if(document.getElementById("checkAllClasses").checked){
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