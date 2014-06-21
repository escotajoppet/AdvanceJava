<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="funeralPlan" class="funeral.plan.FuneralPlan" scope="session"/>

<body>
	<center>
		<h1>Thank You, <%=funeralPlan.getName() %> For Choosing Our Company</h1>
		<h2>You Have Chosen: </h2>
		<h4>Plan Type: <%=funeralPlan.getSubmittedPlanType() %></h4>
		<h4>Description: <%=funeralPlan.getSubmittedDescription() %></h4>
		<h4>Payment Type: <%=funeralPlan.getSubmittedPaymentType() %></h4>
		<h4>Payment Amount:  <%=funeralPlan.getSubmittedPrice() %></h4>
		
		<form action="PageController">
			<button type="submit" name="btn" value="back">Back to Plan List</button>
		</form>
	</center>
</body>
</html>