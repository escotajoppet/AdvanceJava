<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Report Page: Subscriber Info</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/main.css" />
</head>

<jsp:useBean id="smart" class="advance.java.Smart" scope="session"/>

<%
	String[] info = new String[6];
	
	String inputForm = request.getParameter("change");
	String usage = request.getParameter("usage");
	String monthlyUsageBtn = request.getParameter("monthlyUsage");
	
	if(request.getAttribute("source").equals("InputForm")){
		smart.setAccountNumber(request.getParameter("accountno"));
	}
	
	request.setAttribute("source", "SubscriberInformation");
	
	if(inputForm!=null){
		%><jsp:forward page="InputForm"/><%
	} else if(usage!=null){
		request.setAttribute("source", "SubscriberMonthlyUsage");
		%><jsp:forward page="SubscriberUsage"/><%
	} else if(monthlyUsageBtn!=null){
		request.setAttribute("source", "SubscriberMonthlyUsage");
		%><jsp:forward page="SubscriberMonthlyUsage"/><%
	}
	
	info = smart.subscriberInfo(smart.getAccountNumber());
	
	if(info==null){
		%><jsp:forward page="/sub_info_no_data.html"/><%
	}
%>

<body>
	<center>
		<div class="panel panel-primary mainDiv">
			<div class="panel-heading">Report Page: subscriber_info</div>
			<div class="panel-body">
				<table class="table table-bordered table-hover">
					<tr>
						<th class="subscriberTH">Subscriber Name:</th>
						<td><%=info[0]%></td>
					</tr>
					<tr>
						<th class="subscriberTH">MSISDN:</th>
						<td><%=info[1]%></td>
					</tr>
					<tr>
						<th class="subscriberTH">IMSI:</th>
						<td><%=info[2]%></td>
					</tr>
					<tr>
						<th class="subscriberTH">Account Number:</th>
						<td><%=info[3]%></td>
					</tr>
					<tr>
						<th class="subscriberTH">Birthday (YYYY-MM-DD):</th>
						<td><%=info[4]%></td>
					</tr>
					<tr>
						<th class="subscriberTH">Mother's Maiden Name:</th>
						<td><%=info[5]%></td>
					</tr>
				</table>
				<form action="SubscriberInformation">
					<input type="submit" class="btn btn-primary button" value="Change Account" name="change"/>
					<input type="submit" class="btn btn-primary button" value="Get Subscriber Usage" name="usage"/>
					<input type="submit" class="btn btn-primary button" value="Get Subscriber Monthly Usage" name="monthlyUsage"/>
				</form>
			</div>
		</div>
	</center>
</body>
</html>