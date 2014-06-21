<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/main.css" />
<title>Class Record Project: Add Class</title>
</head>

<jsp:useBean id="classRecord" class="classes.record.NewClassRecord" scope="session"/>

<%
	String message = "";
	String btn = request.getParameter("btn");

	String classYear = request.getParameter("classyear");
	String classSection = request.getParameter("classsection");
	
	String[] days = request.getParameterValues("days");
	String[] fromTime0 = request.getParameterValues("fromtime0");
	String[] fromTime1 = request.getParameterValues("fromtime1");
	String[] from = request.getParameterValues("from");
	String[] toTime0 = request.getParameterValues("totime0");
	String[] toTime1 = request.getParameterValues("totime1");
	String[] to = request.getParameterValues("to");

	if(btn!=null && btn.equals("addclass")){
		String[] values = new String[5];
		values[0] = classYear;
		values[1] = classSection;
		
		classRecord.setScheduleOfNewClass(days, fromTime0, fromTime1, from, toTime0, toTime1, to);
		classRecord.createNewClassTable(classYear, classSection);
		classRecord.add(values, "classes");
		
		message = classRecord.getMessage();
		
		if (message.equals("")){
			request.getRequestDispatcher("/ClassList").forward(request, response);
		}		
	}
%>

<body>
	<center>
		<div class="panel panel-info adding">
			<div class="panel-heading">
				<h4>Add New Class</h4>
			</div>
			
			<div class="panel-body">
				<form action="MainPageController">
					<div class="form-inline">
						<select name="classyear" id="" class="btn btn-default">
							<option value="">Class Year...</option>
							<%
								for(int i = 1; i<6; i++){
							%>
								<option value="<%=i%>"><%=i%></option>
							<%
								}
							%>
						</select>
						
						<span> - </span>
						
						<select name="classsection" id="" class="btn btn-default">
							<option value="">Section...</option>
							<%
								for(int i = 1; i<6; i++){
							%>
								<option value="<%=i%>"><%=i%></option>
							<%
								}
							%>
						</select>
					</div>
					
					<br />
					
					<div id="schedule">
						<div class="alert alert-info">Schedule for the Class</div>
						
						<div class="form-inline schedules" id="original">
							
							<select name="days" id="" class="btn btn-default">
								<option value="Monday">Monday</option>
								<option value="Tuesday">Tuesday</option>
								<option value="Wednesday">Wednesday</option>
								<option value="Thursday">Thursday</option>
								<option value="Friday">Friday</option>
								<option value="Saturday">Saturday</option>
							</select>
							
							<br /><br />
							
							<div>
								<span id="from">From:</span> <select name="fromtime0" id="" class="btn btn-default" id="from">
									<%
										for(int i = 1; i<13; i++){
									%>
										<option value="<%=i%>"><%=i<10 ? "0"+i : i %></option>
									<%
										}
									%>
								</select>
								
								<span> : </span>
	
								<select name="fromtime1" id="" class="btn btn-default">
									<%
										for(int i = 0; i<61; i++){
									%>
										<option value="<%=i%>"><%=i<10 ? "0"+i : i %></option>
									<%
										}
									%>
								</select>
	
								<select name="from" id="" class="btn btn-default">
									<option value="AM">AM</option>
									<option value="AM">PM</option>
								</select>
							</div>
							
							<br />
							
							<div>
								<span id="to">To:</span> <select name="totime0" id="" class="btn btn-default">
									<%
										for(int i = 1; i<13; i++){
									%>
										<option value="<%=i%>"><%=i<10 ? "0"+i : i %></option>
									<%
										}
									%>
								</select>
								
								<span> : </span>
	
								<select name="totime1" id="" class="btn btn-default">
									<%
										for(int i = 0; i<61; i++){
									%>
										<option value="<%=i%>"><%=i<10 ? "0"+i : i %></option>
									<%
										}
									%>
								</select>
								
								<select name="to" id="" class="btn btn-default">
									<option value="AM">AM</option>
									<option value="AM">PM</option>
								</select>
							</div>
							
						</div>
					</div>
					
					<br /><br />
					
					<input type="button" value="Add Time" class="btn btn-warning btn-sm buton" id="addschedule"/>
					<input type="button" value="Remove Time" class="btn btn-danger btn-sm buton" id="removeschedule"/>
					
					<hr />
					
					<button type="submit" name="btn" value="addclass" class="btn btn-primary buton">Add Class</button>
					<button type="submit" name="btn" value="backtoclasslist" class="btn btn-info buton">Back to Class List</button>
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
		var divCount = 1; 
		var scheduleDiv = document.getElementById("schedule");
		
		document.getElementById("addschedule").onclick = function(){
			var original = document.getElementById("original");
			
			var clone = original.cloneNode(true);
			clone.id = "duplicate" + divCount;
			
			var hr = document.createElement("hr");
			hr.id = "hr" + divCount;
			
			scheduleDiv.appendChild(hr);
			scheduleDiv.appendChild(clone);
			
			divCount++;
		};
		
		document.getElementById("removeschedule").onclick = function(){
			document.getElementById("duplicate" + (divCount - 1)).remove();
			document.getElementById("hr" + (divCount - 1)).remove();
			
			divCount--;
		};
	</script>
</body>
</html>