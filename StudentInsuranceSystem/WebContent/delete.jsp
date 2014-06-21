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
	String accountNumber = request.getParameter("code");
	
	if(request.getParameter("button")!=null && request.getParameter("button").equals("deleteDelete")){
		sis.setTransactionAccountNumber(Integer.parseInt(accountNumber));
		sis.setTransactionCommited("Delete Account");
		sis.deleteAccount(request.getParameter("insuranceType"));
	}
%>

<body>
	<div id="main">
		<div id="form1">
			<div id="title"><p>STUDENT INSURANCE SYSTEM</p></div>
			
			WELCOME, <strong><%=sis.getAdminUsername().toUpperCase() %></strong><br>
			<div id="title"><p>DELETE MEMBER</p></div><br />
			<form action="hrcontroller" method = "Post">
				 <label for="" class = "label">Insurance Type: </label>
				<select name="insuranceType" class = "name4">
					<option value="carinsurance">Car Insurance</option>
					<option value="healthinsurance">Health Insurance</option>
					<option value="lifeinsurance">Life Insurance</option>
					<option value="travelinsurance">Travel Insurance</option>
				</select>
				<br /><br />
				<label for="" class = "label">Enter Account Number: </label><input type="text" name="code" class="name1" required /> <br><br>	
				<button name="button" value = "deleteDelete">Delete</button>
			</form>
			<form action="hrcontroller" method = "Post">
				<button name="button" value = "deleteBack">Back</button>	
				<button name="button" value = "logout">Log Out</button>							
			</form>
			
			<br /><br />
			
			<%=sis.getMessage() %>
			<%sis.setMessage(""); %>
		</div>
	</div>
</body>
</html>	