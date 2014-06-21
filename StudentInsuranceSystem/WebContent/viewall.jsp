<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Student Insurance System</title>
	<link rel="stylesheet" href="css/all.css" />
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/name.css" />
</head>

<jsp:useBean id="sis" class="student.information.system.StudentInfomationSystem" scope="session"/>

<%
	sis.clearCustomers();
	sis.viewAllMembers("", "all");
%>

<body style =background-image:url(img/bg.png);>
	<div id="main">
		<div id="form1">
			<div id="title"><p>STUDENT INSURANCE SYSTEM</p></div>
			
			WELCOME, <strong><%=sis.getAdminUsername().toUpperCase() %></strong><br>
			<div id="title"><p>ALL MEMBERS</p></div><br />	
			<form action="hrcontroller" method = "Post">	
				<table border ="1" cellpadding="10">
					<tr>
						<td>Account #</td>
						<td>Name</td>
						<td>Starting Date</td>
						<td>Expiration Date</td>
						<td>Insurance Type</td>
					</tr>
					
					<%
						for(int i = 0; i<sis.getAccountNumber().size(); i++){
					%>
							<tr>
								<td><%=sis.getAccountNumber().get(i) %></td>
								<td><%=sis.getName().get(i) %></td>
								<td><%=sis.getStartingDate().get(i) %></td>
								<td><%=sis.getExpirationDate().get(i) %></td>
								<td><%=sis.getInsuranceType().get(i) %></td>
							</tr>
					<%
						}
					%>
				</table>	
				<br />								
				<button name="button" value = "viewAllBack">Back</button>
				<button name="button" value = "logout">Log Out</button>
			</form>
			
			<br /><br />
			
			<%=sis.getMessage() %>
			<%sis.setMessage(""); %>			
		</div>
	</div>
</body>
</html>	