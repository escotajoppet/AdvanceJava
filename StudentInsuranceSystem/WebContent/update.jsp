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
	boolean info = false;

	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String address = request.getParameter("address");
	String contact = request.getParameter("contactNum");
	
	String insuranceType = request.getParameter("insuranceType");
	
	String accountNumber = request.getParameter("code");
	
	if(request.getParameter("button")!=null && request.getParameter("button").equals("setaccountnumber")){
		sis.setTableName(insuranceType);
		sis.setUpdateAccountNumber(accountNumber);
		info = true;		
	} else if(request.getParameter("button")!=null && request.getParameter("button").equals("updateSubmit")){
		sis.setTransactionAccountNumber(Integer.parseInt(sis.getUpdateAccountNumber()));
		sis.setTransactionCommited("Update Account");
		sis.updateAccountInfo(firstName, lastName, address, contact, insuranceType);
	}
%>
<body style =background-image:url(img/bg.png);>
	<div id="main">
		<div id="form1">
			<div id="title"><p>STUDENT INSURANCE SYSTEM</p></div>
			
			WELCOME, <strong><%=sis.getAdminUsername().toUpperCase() %></strong><br>
			<div id="title"><p>CHANGE MEMBER DETAILS</p></div>	
				<br />
			<form action="hrcontroller" method="Post">
				<label for="" class="label">Insurance Type: </label>
				<select name="insuranceType" class = "name4">
					<option value="carinsurance">Car Insurance</option>
					<option value="healthinsurance">Health Insurance</option>
					<option value="lifeinsurance">Life Insurance</option>
					<option value="travelinsurance">Travel Insurance</option>
				</select>	
				 <br><br>
			
				<label for="" class = "label">Account Number: </label><input type="text" name="code" class="name1" required />
				<button type="submit" name="button"  value="setaccountnumber">Set Account</button>
			</form>
			
			<%
				if(info){
					String insurance =  sis.getUpdateInsuranceType();
			%>
				<h2>Customer Information</h2>
				<form action="hrcontroller" method = "Post">	
					<label for="" class = "label">First Name: </label><input type="text" name="firstName" class="name1" value="<%=sis.getUpdateFirstName() %>" required /> <br><br>	
					<label for="" class = "label">Last Name: </label><input type="text" name="lastName" class="name1" value="<%=sis.getUpdateLastName() %>" required /> <br><br>
					<label for="" class = "label">Address: </label><input type="text" name="address" class="name1" value="<%=sis.getUpdateAddress() %>" size="<%=sis.getUpdateAddress().length() %>"required /> <br><br>
					<label for="" class = "label">Contact No.: </label><input type="text" name="contactNum" class="name1" value="<%=sis.getUpdateContact() %>" required /> <br><br>	
					
					<br /><br />
					<button name="button" value = "updateSubmit">Update</button>
				</form>
			<%
				} info = false;
			%>
			
			<br />
			
			<%=sis.getMessage() %>
			<%sis.setMessage(""); %>
			<%
				sis.setUpdateAddress("");
				sis.setUpdateContact("");
				sis.setUpdateFirstName("");
				sis.setUpdateLastName("");
			%>
			
			<br />
			
			<form action="hrcontroller" method = "Post">
				<button name="button" value = "updateBack">Back</button>
				<button name="button" value = "logout">Log Out</button>							
			</form>
		</div>
	</div>
</body>
</html>	