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

<jsp:useBean id="classrecord" class="classes.record.ClassRecord" scope="session"/>

<%!
	String schedule = "";
%>

<%
	String message = "";

	String addClass = request.getParameter("addclass");
	String back = request.getParameter("back");

	String classYear = request.getParameter("classyear");
	String classSection = request.getParameter("classsection");
	
	String[] days = request.getParameterValues("days");
	String[] fromTime0 = request.getParameterValues("fromtime0");
	String[] fromTime1 = request.getParameterValues("fromtime1");
	String[] from = request.getParameterValues("from");
	String[] toTime0 = request.getParameterValues("totime0");
	String[] toTime1 = request.getParameterValues("totime1");
	String[] to = request.getParameterValues("to");

	if(back!=null){
		classrecord.clearLists();
		classrecord.setMessage("");
		%><jsp:forward page="ClassList"/><%
	} else if(addClass!=null){
		schedule = classrecord.getScheduleOfNewClass(days, fromTime0, fromTime1, from, toTime0, toTime1, to);
		classrecord.addNewClass(classYear, classSection,  schedule);
		classrecord.clearLists();
		
		message = classrecord.getMessage();
		
		if (message.equals("")){
			%><jsp:forward page="ClassList"/><%
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
				<form action="AddClass">
					<div class="form-inline">
						<select name="classyear" id="" class="btn btn-default">
							<option value="">Class Year...</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
						
						<span> - </span>
						
						<select name="classsection" id="" class="btn btn-default">
							<option value="">Section...</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
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
									<option value="01">01</option>
									<option value="02">02</option>
									<option value="03">03</option>
									<option value="04">04</option>
									<option value="05">05</option>
									<option value="06">06</option>
									<option value="07">07</option>
									<option value="08">08</option>
									<option value="09">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>
								
								<span> : </span>
	
								<select name="fromtime1" id="" class="btn btn-default">
									<option value="00">00</option>
									<option value="01">01</option>
									<option value="02">02</option>
									<option value="03">03</option>
									<option value="04">04</option>
									<option value="05">05</option>
									<option value="06">06</option>
									<option value="07">07</option>
									<option value="08">08</option>
									<option value="09">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
									<option value="32">32</option>
									<option value="33">33</option>
									<option value="34">34</option>
									<option value="35">35</option>
									<option value="36">36</option>
									<option value="37">37</option>
									<option value="38">38</option>
									<option value="39">39</option>
									<option value="40">40</option>
									<option value="41">41</option>
									<option value="42">42</option>
									<option value="43">43</option>
									<option value="44">44</option>
									<option value="45">45</option>
									<option value="46">46</option>
									<option value="47">47</option>
									<option value="48">48</option>
									<option value="49">49</option>
									<option value="50">50</option>
									<option value="51">51</option>
									<option value="52">52</option>
									<option value="53">53</option>
									<option value="54">54</option>
									<option value="55">55</option>
									<option value="56">56</option>
									<option value="57">57</option>
									<option value="58">58</option>
									<option value="59">59</option>
									<option value="60">60</option>
								</select>
	
								<select name="from" id="" class="btn btn-default">
									<option value="AM">AM</option>
									<option value="AM">PM</option>
								</select>
							</div>
							
							<br />
							
							<div>
								<span id="to">To:</span> <select name="totime0" id="" class="btn btn-default">
									<option value="01">01</option>
									<option value="02">02</option>
									<option value="03">03</option>
									<option value="04">04</option>
									<option value="05">05</option>
									<option value="06">06</option>
									<option value="07">07</option>
									<option value="08">08</option>
									<option value="09">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>
								
								<span> : </span>
	
								<select name="totime1" id="" class="btn btn-default">
									<option value="00">00</option>
									<option value="01">01</option>
									<option value="02">02</option>
									<option value="03">03</option>
									<option value="04">04</option>
									<option value="05">05</option>
									<option value="06">06</option>
									<option value="07">07</option>
									<option value="08">08</option>
									<option value="09">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
									<option value="32">32</option>
									<option value="33">33</option>
									<option value="34">34</option>
									<option value="35">35</option>
									<option value="36">36</option>
									<option value="37">37</option>
									<option value="38">38</option>
									<option value="39">39</option>
									<option value="40">40</option>
									<option value="41">41</option>
									<option value="42">42</option>
									<option value="43">43</option>
									<option value="44">44</option>
									<option value="45">45</option>
									<option value="46">46</option>
									<option value="47">47</option>
									<option value="48">48</option>
									<option value="49">49</option>
									<option value="50">50</option>
									<option value="51">51</option>
									<option value="52">52</option>
									<option value="53">53</option>
									<option value="54">54</option>
									<option value="55">55</option>
									<option value="56">56</option>
									<option value="57">57</option>
									<option value="58">58</option>
									<option value="59">59</option>
									<option value="60">60</option>
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
					
					<input type="submit" name="addclass" value="Add Class" class="btn btn-primary buton"/>
					<input type="submit" name="back" value="Back to Class List" class="btn btn-info buton"/>
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