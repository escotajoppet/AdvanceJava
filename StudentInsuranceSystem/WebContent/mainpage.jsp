<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Student Insurance System</title>
</head>

<jsp:useBean id="sis" class="student.information.system.StudentInfomationSystem" scope="session"/>

<body style =background-image:url(img/bg.png);>
	<div id="main">
		<div id="form1">
			<div id="title"><p>STUDENT INSURANCE SYSTEM</p></div>
			
			WELCOME, <strong><%=sis.getAdminUsername().toUpperCase() %></strong><br><br><br>
			
			<form action="hrcontroller" method = "Post">							
				<button type="submit" name="button" value = "indexCreate"> Add Member</button><br><br>
				<button name="button" value = "indexEdit"> Edit Member Information</button><br><br>
				<button name="button" value = "indexDelete"> Delete Member</button><br><br>
				<button name="button" value = "indexView"> View Member</button><br><br>
				<button name="button" value = "indexAll"> View All Members</button><br><br>
				<button name="button" value = "indexTransaction"> View All Transactions</button><br><br>
				<button name="button" value = "logout">Log Out</button>
			</form>
		</div>
	</div>
</body>
</html>	
