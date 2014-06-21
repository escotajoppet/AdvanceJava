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

	if(request.getParameter("button")!=null && request.getParameter("button").equals("searchNext")){
		sis.setTransactionCommited("Search Account");
		sis.setTransactionAccountNumber(Integer.parseInt(accountNumber));
		sis.viewAllMembers(request.getParameter("insuranceType"), accountNumber);
	}
%>

<body style =background-image:url(img/bg.png);>
	<div id="main">
		<div id="form1"><div id="title"><p>STUDENT INSURANCE SYSTEM</p></div>
			
			WELCOME, <strong><%=sis.getAdminUsername().toUpperCase() %></strong><br>
			<div id="title"><p>VIEW ACCOUNTS</p></div><br />
			<form action="hrcontroller" method = "Post">
				<label for="" class = "label">Insurance Type: </label>
				<select name="insuranceType" class = "name4">
					<option value="carinsurance">Car Insurance</option>
					<option value="healthinsurance">Health Insurance</option>
					<option value="lifeinsurance">Life Insurance</option>
					<option value="travelinsurance">Travel Insurance</option>
				</select>	
				 <br><br>
				 
				<label for="" class = "label">Enter Account Number: </label><input type="text" name="code" class="name1" required /> <br><br>	
				
				<button name="button" value = "searchNext">Search</button>	
				
				<br /><br />
				
				<%
					if(request.getParameter("button")!=null && request.getParameter("button").equals("searchNext") && sis.getAccountNumber().size()>0){
				%>
						Account Number: <%=sis.getAccountNumber().get(0) %> <br /> 
						Name: <%=sis.getName().get(0) %> <br />
						Starting Date: <%=sis.getStartingDate().get(0) %> <br />
						Expiration Date:  <%=sis.getExpirationDate().get(0) %> <br /><br />
				<%
					} sis.clearCustomers();
				%>
			</form>
			<form action="hrcontroller" method = "Post">	
				<button name="button" value = "searchBack">Back</button>	
				<button name="button" value = "logout">Log Out</button>								
			</form>
		</div>
	</div>
</body>
</html>	