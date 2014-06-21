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

<jsp:useBean id="classRecord" class="classes.record.NewClassRecord" scope="session"/>

<%
	boolean DISABLED = true;

	String btn = request.getParameter("btn");

	String quiz1 = request.getParameter("quiz1");
	String quiz2 = request.getParameter("quiz2");
	String midtermExam = request.getParameter("midtermexam");
	String midtermProject = request.getParameter("midtermproject");
	String quiz3 = request.getParameter("quiz3");
	String quiz4 = request.getParameter("quiz4");
	String finalExam = request.getParameter("finalexam");
	String finalProject = request.getParameter("finalproject");

	if(btn!=null && btn.equals("setforms")){
		DISABLED = false;
	} else if(btn!=null && btn.equals("updategradesheet")){
		classRecord.updateGradeSheet(quiz1, quiz2, midtermExam, midtermProject, quiz3, quiz4, finalExam, finalProject);
		DISABLED = true;
	}
	
	classRecord.clearGrades();
	classRecord.setList("grades");
%>

<body>
	<center>
		<div class="panel panel-info tabled">
			<div class="panel-heading">
				<h4><%=classRecord.getStudent() %> : <%=classRecord.getStudentsName() %></h4>
			</div>
			
			<div class="panel-body">
				<form action="MainPageController">
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
							<td><input type="text" name="quiz1" value="<%=classRecord.getQuiz1() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="quiz2" value="<%=classRecord.getQuiz2() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="midtermexam" value="<%=classRecord.getMidtermExam() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="midtermproject" value="<%=classRecord.getMidtermProject() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
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
							<td><input type="text" name="quiz3" value="<%=classRecord.getQuiz3() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="quiz4" value="<%=classRecord.getQuiz4() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="finalexam" value="<%=classRecord.getFinalExam() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
							<td><input type="text" name="finalproject" value="<%=classRecord.getFinalProject() %>" <%=DISABLED==true ? "DISABLED" : "" %> class="form-control"/></td>
						</tr>
					</table>
					
					<hr />
					
					<button type="submit" name="btn" value="setforms" class="btn btn-warning buton" <%=DISABLED==false ? "DISABLED" : "" %>>Set Forms</button>
					<button type="submit" name="btn" value="updategradesheet" class="btn btn-success buton" <%=DISABLED==true ? "DISABLED" : "" %>>Update Grade Sheet</button>
					<button type="submit" name="btn" value="backtostudentlist" class="btn btn-info buton">Back to Student List</button>
				</form>
			</div>
		</div>
	</center>
</body>
</html>