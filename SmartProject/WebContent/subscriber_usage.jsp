<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Report Page: Subscriber Usage</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/main.css" />
</head>

<jsp:useBean id="smart" class="advance.java.Smart" scope="session"/>

<%

	String[] usage = new String[5];

	String inputForm = request.getParameter("inputform");
	String info = request.getParameter("info");
	String monthlyUsage = request.getParameter("monthlyUsage");
	
	if(request.getAttribute("source").equals("InputForm")){
		smart.setAccountNumber(request.getParameter("accountno"));
		smart.setIMSI(request.getParameter("accountno"));
	}
	
	request.setAttribute("source", "SubscriberUsage");
	
	if(inputForm!=null){
		%><jsp:forward page="InputForm"/><%
	} else if(info!=null){
		request.setAttribute("source", "SubscriberMonthlyUsage");
		%><jsp:forward page="SubscriberInformation"/><%
	} else if(monthlyUsage!=null){
		request.setAttribute("source", "SubscriberMonthlyUsage");
		%><jsp:forward page="SubscriberMonthlyUsage"/><%
	}
	
	String accountno = smart.getAccountNumber();
	String imsi = smart.getIMSI();
	
	usage = smart.subscriberUsage(accountno, imsi);
	
	if(usage==null){
		%><jsp:forward page="sub_usage_no_data.html"/><%
	}
%>

<body>
	<center>
		<div class="panel panel-primary mainDiv">
			<div class="panel-heading">Report Page: subscriber_usage</div>
			<div class="panel-body">
				<table class="table table-bordered table-hover">
					<tr>
						<th>IMSI</th>
						<th>Transaction Date [YYYMMDDHHMMSS]</th>
						<th>Usage Type</th>
						<th>Transaction ID</th>
						<th>Cost</th>
					</tr>
					<tr>
						<td><%=usage[0]%></td>
						<td><%=usage[1]%></td>
						<td><%=usage[2]%></td>
						<td><%=usage[3]%></td>
						<td><%=usage[4]%></td>
					</tr>
				</table>
				<form action="subscriber_usage.jsp">
					<input type="submit" class="btn btn-primary button" value="Input Form" name="inputform"/>
					<input type="submit" class="btn btn-primary button" value="Get Subscriber Info" name="info"/>
					<input type="submit" class="btn btn-primary button" value="Get Subscriber Monthly Usage" name="monthlyUsage"/>
				</form>
			</div>
		</div>
	</center>
</body>
</html>