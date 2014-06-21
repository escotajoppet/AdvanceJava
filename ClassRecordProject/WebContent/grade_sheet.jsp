<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/main.css" />
<title>Class Record Project: Grade Sheet Page</title>
</head>

<jsp:useBean id="classrecord" class="classes.record.ClassRecord" scope="session"/>

<%!
	boolean DISABLED = true;
%>

<%
	String updateGrades = request.getParameter("updategradesheet");
	String back = request.getParameter("backtostudentlist");
	String setForm = request.getParameter("setform");

	String quiz1 = request.getParameter("quiz1");
	String quiz2 = request.getParameter("quiz2");
	String midtermExam = request.getParameter("midtermexam");
	String midtermProject = request.getParameter("midtermproject");
	String quiz3 = request.getParameter("quiz3");
	String quiz4 = request.getParameter("quiz4");
	String finalExam = request.getParameter("finalexam");
	String finalProject = request.getParameter("finalproject");
	
	if(back!=null){
		classrecord.clearLists();
		%><jsp:forward page="StudentList"/><%
	} else if(setForm!=null){
		DISABLED = false;
	} else if(updateGrades!=null){
		classrecord.updateGradeSheet(quiz1, quiz2, midtermExam, midtermProject, quiz3, quiz4, finalExam, finalProject);
		DISABLED = true;
	}
	
	classrecord.setGrades();
%>

<body>
	<center>
		<div class="panel panel-info tabled">
			<div class="panel-heading">
				<h4><%=classrecord.getStudent() %> : <%=classrecord.getNameOfStudent() %></h4>
			</div>
			
			<div class="panel-body">
				<form action="GradeSheet">
					<table class="table table-bordered table-hover">
						<tr>
							<th colspan="4">Midterms</th>
						</tr>
						
						<tr>
							<th>Quiz no. 1</th>
							<th>Quiz no. 2</th>
							<th>Mid Exam</th>
							<th>Mid Project</th>
							
						</tr>
						
						<tr>
							<td><input type="text" name="quiz1" value="<%=classrecord.getQuiz1() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="quiz2" value="<%=classrecord.getQuiz2() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="midtermexam" value="<%=classrecord.getMidtermExam() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="midtermproject" value="<%=classrecord.getMidtermProject() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
						</tr>
					</table>
					
					<table class="table table-bordered table-hover">
						<tr>
							<th colspan="4">Finals</th>						
						</tr>
						
						<tr>
							<th>Quiz no. 3</th>
							<th>Quiz no. 4</th>
							<th>Final Exam</th>
							<th>Final Project</th>
						</tr>
						
						<tr>
							<td><input type="text" name="quiz3" value="<%=classrecord.getQuiz3() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="quiz4" value="<%=classrecord.getQuiz4() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="finalexam" value="<%=classrecord.getFinalExam() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="finalproject" value="<%=classrecord.getFinalProject() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
						</tr>
					</table>
					
					<hr />
					
					<input type="submit" name="setform" value="Set Forms" <%=DISABLED==false ? "DISABLED" : "" %> class="btn btn-warning buton"/>
					<input type="submit" name="updategradesheet" value="Update Grade Sheet" <%=DISABLED==true ? "DISABLED" : "" %> class="btn btn-success buton"/>
					<input type="submit" name="backtostudentlist"  value="Back to Student List" class="btn btn-info buton"/>
				
					<%classrecord.clearLists();%>
				</form>
			</div>
		</div>
	</center>
</body>
</html>