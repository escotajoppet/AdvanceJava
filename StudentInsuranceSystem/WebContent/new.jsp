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
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String address = request.getParameter("address");
	String contactNumber = request.getParameter("contactNum");
	String insuranceType = request.getParameter("insuranceType");
	String startingDate = request.getParameter("dateCheckIn");
	String expirationDate = request.getParameter("dateCheckOut");
	
	if(request.getParameter("button")!=null && request.getParameter("button").equals("createSubmit")){		
		sis.setTransactionCommited("Add New Account");
		sis.addNewSIS(firstName, lastName, address, contactNumber, insuranceType, startingDate, expirationDate);
	}
%>

<body style =background-image:url(img/bg.png);>
	<div id="main">
		<div id="form1">
			<div id="title"><p>STUDENT INSURANCE SYSTEM</p></div>
			
			WELCOME, <strong><%=sis.getAdminUsername().toUpperCase() %></strong><br>
			<div id="title"><p>ADD INSURANCE</p></div>			
			
			<h2>Customer Information</h2>
			<form action="hrcontroller" method = "Post">	
				<label for="" class = "label">First Name: </label><input type="text" name="firstName" class="name1" required /> <br><br>	
				<label for="" class = "label">Last Name: </label><input type="text" name="lastName" class="name1" required /> <br><br>
				<label for="" class = "label">Address: </label><input type="text" name="address" class="name1" required /> <br><br>
				<label for="" class = "label">Contact No.: </label><input type="text" name="contactNum" class="name1" required /> <br><br>
			<h2>General Information</h2>
				<label for="" class = "label">Insurance Type: </label>
				<select name="insuranceType" class = "name4">
					<option value="carinsurance">Car Insurance</option>
					<option value="healthinsurance">Health Insurance</option>
					<option value="lifeinsurance">Life Insurance</option>
					<option value="travelinsurance">Travel Insurance</option>
				</select><br><br>								
				<label for="" class = "label">Starting Date: </label><input type="date" name="dateCheckIn" /><br><br>
				<label for="" class = "label">Expiration Date: </label><input type="date" name="dateCheckOut" /><br><br>
				<button name="button" value = "createSubmit">Submit</button>
			</form>
			<form action="hrcontroller" method = "Post">
				<button name="button" value = "createBack">Back</button>
				<button name="button" value = "logout">Log Out</button>								
			</form>
			<br /><br />
			<%=sis.getMessage() %>
			<br />
			<%if(request.getParameter("button")!=null && request.getParameter("button").equals("createSubmit") && !sis.getMessage().equals("error adding new member, member already exists")){
				out.println("Your New Account Number is: " + sis.getNewAccountNumber(request.getParameter("insuranceType")));
				sis.setTransactionAccountNumber(sis.getNewAccountNumber(request.getParameter("insuranceType")));
				sis.addNewTransaction();
			} %>
			<%sis.setMessage(""); %>
		</div>
	</div>
</body>
</html>	