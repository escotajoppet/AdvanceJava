<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Data Entry Page</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/main.css" />
</head>

<jsp:useBean id="smart" class="advance.java.Smart" scope="session"/>

<%
	String accountno = request.getParameter("accountno");
	String submit = request.getParameter("submit");
	
	if(submit!=null){
		smart.setAccountNumber(accountno);
		smart.setIMSI(accountno);
	}
%>

<body>
	<center>
		<div class="panel panel-primary mainDiv">
			<div class="panel-heading">Data Entry Page: input_form</div>
			<div class="panel-body">
				<form action="PageController" method="get">
					<input type="text" class="form-control" name="accountno" placeholder="Subscriber Account Number" id="input"/>
					<select name="page" class="btn btn-default">
						<option value="none">Choose Page...</option>
						<option value="subinfo">Subscriber Information</option>
						<option value="submonuse">Subscriber Monthly Usage</option>
						<option value="subuse">Subscriber Usage</option>
					</select>
					<input type="submit" class="btn btn-primary" name="submit" value="Submit!" id="submit"/>
				</form>
			</div>
		</div>
	</center>
</body>
</html>