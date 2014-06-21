<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Report Page:  Subscriber Monthly Usage</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/main.css" />
</head>

<jsp:useBean id="smart" class="advance.java.Smart" scope="session"/>

<%
	String[] monthlyUsage = new String[4];
	
	String inputForm = request.getParameter("inputform");
	String info = request.getParameter("info");
	String usage = request.getParameter("usage");
	
	System.out.println(request.getAttribute("source"));
	
	if(request.getAttribute("source").equals("InputForm")){
		smart.setAccountNumber(request.getParameter("accountno"));
	}
	
	if(inputForm!=null){
		%><jsp:forward page="InputForm"/><%
	} else if(usage!=null){
		request.setAttribute("source", "SubscriberMonthlyUsage");
		%><jsp:forward page="SubscriberUsage"/><%
	} else if(info!=null){
		request.setAttribute("source", "SubscriberMonthlyUsage");
		%><jsp:forward page="SubscriberInformation"/><%
	}
		
	monthlyUsage = smart.subscriberMonthlyUsage(smart.getAccountNumber());
	
	if(monthlyUsage==null){
		%><jsp:forward page="sub_usage_no_data.html"/><%
	}
%>

<body>
	<center>
		<div class="panel panel-primary mainDiv">
			<div class="panel-heading">Report Page: subscriber_mothly_usage</div>
			<div class="panel-body">
				<table class="table table-bordered table-hover">
					<tr>
						<th>Account Number</th>
						<th>Transaction Data [YYYMMDDHHMMSS]</th>
						<th>Number of Transactions</th>
						<th>Cost</th>
					</tr>
					<tr>
						<td><%=monthlyUsage[0]%></td>
						<td><%=monthlyUsage[1]%></td>
						<td><%=monthlyUsage[2]%></td>
						<td><%=monthlyUsage[3]%></td>
					</tr>
				</table>
				<form action="subscriber_monthly_usage.jsp">
					<input type="submit" class="btn btn-primary button" value="Input Form" name="inputform"/>
					<input type="submit" class="btn btn-primary button" value="Get Subscriber Info" name="info"/>
					<input type="submit" class="btn btn-primary button" value="Get Subscriber Usage" name="usage"/>
				</form>
			</div>
		</div>
	</center>
</body>
</html>