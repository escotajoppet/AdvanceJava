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

<jsp:useBean id="classrecord" class="classes.record.ClassRecord" scope="session"/>

<%!
	String section = "";
%>

<%
	String message = "";

	String getClassInfo = request.getParameter("getclassinfo");
	String[] classSection = request.getParameterValues("classes");
	String addNewClass = request.getParameter("addnewclass");
	String deleteClass = request.getParameter("deleteclass");
	
	if(getClassInfo!=null){
		section = getClassInfo != null ? getClassInfo.substring(0, 3) : "";
		classrecord.setClassSection(section);
		classrecord.clearLists();
		%><jsp:forward page="StudentList"/><%
	} else if(addNewClass!=null){
		%><jsp:forward page="AddClass"/><%
	} else if(deleteClass!=null){
		classrecord.deleteClass(classSection);
	}
	
	message = classrecord.getMessage();
	
	classrecord.setClass();
	classrecord.setNumberOfStudents();
%>

<body>
	<center>
		<div class="panel panel-primary tabled">
			<div class="panel-heading">
				<h4>Class List</h4>
			</div>
			
			<div class="panel-body">
				<form action="ClassList">
					<table class="table table-bordered table-hover">
						<tr class="active">
							<th><input type="checkbox" id="checkAllClasses" <%=classrecord.getClassRow()<1 ? "DISABLED" : "" %>/></th>
							<th>List of Students</th>
							<th>Number of Students</th>
							<th>Class Schedule</th>
						</tr>
						
						<%for(int i = 0; i<classrecord.getClasses().size(); i++){	
								String newSchedule = classrecord.getClassSchedule().get(i);
						%>
							<tr>
								<td class="active"><input type="checkbox" name="classes" value="<%=classrecord.getClasses().get(i) %>" /></td>
								<td><input type="submit" name="getclassinfo" value="<%=classrecord.getClasses().get(i) %> Students" class="btn btn-success btn-sm buton-class"/></td>
								<td><%=!classrecord.getNumberOfStudents().isEmpty() ? classrecord.getNumberOfStudents().get(i) : 0%> Student(s)</td>
								<td><%=newSchedule.contains("/ ") ? newSchedule.replace("/ ", "<br />") : newSchedule %></td>
							</tr>
						<%}
							classrecord.clearLists();
						%>	
									
					</table>
					
					<hr />
					
					<input type="submit" name="addnewclass" value="Add New Class" class="btn btn-primary buton"/>
					<input type="submit" name="deleteclass" value="Delete Class" <%=classrecord.getClassRow()==0 ? "DISABLED" : "" %> class="btn btn-danger buton" id="btndel"/>
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
		window.onload = function(){
			checkAll();
		}
	
		function checkAll(){			
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