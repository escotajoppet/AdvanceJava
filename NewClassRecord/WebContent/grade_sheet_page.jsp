<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grade Sheet</title>
</head>

<jsp:useBean id="classRecord" class="classes.record.ClassRecordManager" scope="session"/>

<%!
	String[] grades = {"", "1.0", "1.25", "1.5", "1.75", "2.0", "2.25", "2.5", "2.75", "3.0", "4.0", "5.0"};
%>

<%
	String updateValue = "Update Grade(s)";
	String isDisabled = "DISABLED";

	String btn = request.getParameter("btn");
	String[] grade = request.getParameterValues("grades");

	if(session.getAttribute("id")==null || classRecord.getLoggedId().equals("")){
		request.getRequestDispatcher("/login_page.jsp").forward(request, response);
	}

	if(btn!=null && btn.equals("gradelogout")){
		session.invalidate();
		request.getRequestDispatcher("/login_page.jsp").forward(request, response);
	} else if(btn!=null && (btn.equals("Update Grade(s)") || btn.equals("Confirm Update"))){
		if(btn.equals("Update Grade(s)")){
			isDisabled = "";
			updateValue = "Confirm Update";
		} else {
			classRecord.update(grade);
			isDisabled = "DISABLED";
			updateValue = "Update Grade(s)";
		}
	}
	
	classRecord.setTable("grade");
%>

<body>
	<center>
		<h1>Class Record</h1>
		<h2>Grade Sheet</h2>
		<h3>Student Information</h3>
		<h4><%=classRecord.getGradeSelectedStudentId() %></h4>
		<h4><%=classRecord.getGradeSelectedStudentName() %></h4>
		<form action="ClassController" method="post">
			<table border="1" cellpadding="5">
				<tr>
					<th colspan="4">Mid-Term Period</th>
				</tr>
				<tr>
					<th>Q1</th>
					<th>Q2</th>
					<th>MTE</th>
					<th>MTP</th>
				</tr>

				<tr>
					<td>
						<select name="grades" id="" <%=isDisabled %>>
							<%for(int i = 0; i<grades.length; i++){%> <option value="<%=grades[i]%>" <%=classRecord.getGradeMidtermQuiz1().equals(grades[i]) ? "SELECTED" : "" %>><%=grades[i]%></option><%}%>						
						</select>
					</td>
					<td>
						<select name="grades" id="" <%=isDisabled %>>
							<%for(int i = 0; i<grades.length; i++){%> <option value="<%=grades[i]%>" <%=classRecord.getGradeMidtermQuiz2().equals(grades[i]) ? "SELECTED" : "" %>><%=grades[i]%></option><%}%>						
						</select>
					</td>
					<td>
						<select name="grades" id="" <%=isDisabled %>>
							<%for(int i = 0; i<grades.length; i++){%> <option value="<%=grades[i]%>" <%=classRecord.getGradeMidtermExam().equals(grades[i]) ? "SELECTED" : "" %>><%=grades[i]%></option><%}%>						
						</select>
					</td>
					<td>
						<select name="grades" id="" <%=isDisabled %>>
							<%for(int i = 0; i<grades.length; i++){%> <option value="<%=grades[i]%>" <%=classRecord.getGradeMidtermProject().equals(grades[i]) ? "SELECTED" : "" %>><%=grades[i]%></option><%}%>						
						</select>
					</td>
				</tr>
			</table>
			
			 <br /><br />
			
			<table border="1" cellpadding="5">
				<tr>
					<th colspan="4">Final Period</th>
				</tr>
				<tr>
					<th>Q3</th>
					<th>Q4</th>
					<th>FE</th>
					<th>FP</th>
				</tr>
				
				<tr>
					<td>
						<select name="grades" id="" <%=isDisabled %>>
							<%for(int i = 0; i<grades.length; i++){%> <option value="<%=grades[i]%>" <%=classRecord.getGradeFinalQuiz3().equals(grades[i]) ? "SELECTED" : "" %>><%=grades[i]%></option><%}%>						
						</select>
					</td>
					<td>
						<select name="grades" id="" <%=isDisabled %>>
							<%for(int i = 0; i<grades.length; i++){%> <option value="<%=grades[i]%>" <%=classRecord.getGradeFinalQuiz4().equals(grades[i]) ? "SELECTED" : "" %>><%=grades[i]%></option><%}%>						
						</select>
					</td>
					<td>
						<select name="grades" id="" <%=isDisabled %>>
							<%for(int i = 0; i<grades.length; i++){%> <option value="<%=grades[i]%>" <%=classRecord.getGradeFinalExam().equals(grades[i]) ? "SELECTED" : "" %>><%=grades[i]%></option><%}%>						
						</select>
					</td>
					<td>
						<select name="grades" id="" <%=isDisabled %>>
							<%for(int i = 0; i<grades.length; i++){%> <option value="<%=grades[i]%>" <%=classRecord.getGradeFinalProject().equals(grades[i]) ? "SELECTED" : "" %>><%=grades[i]%></option><%}%>						
						</select>
					</td>
				</tr>
			</table>
			
			<br />
			
			<button type="submit" name="btn" value="<%=updateValue %>"><%=updateValue %></button>
			<button type="submit" name="btn" value="backtostudentlist">Back</button>
			<button type="submit" name="btn" value="gradelogout">Log Out</button>
		</form>
		
		<br /><br />
		
		<%=classRecord.getMessage() %>
		<%classRecord.setMessage(""); %>
	</center>
</html>