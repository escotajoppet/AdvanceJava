<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="funeralPlan" class="funeral.plan.FuneralPlan" scope="session"/>

<%
	String planType = request.getParameter("plantype");
	String description = request.getParameter("description");
	String contractPrice = request.getParameter("contractprice");
	String annual = request.getParameter("annualprice");
	String semiAnnual = request.getParameter("semiannualprice");
	String quarterly = request.getParameter("quarterlyprice");
	String monthly = request.getParameter("monthlyprice");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("addplantype")){
		funeralPlan.addNewPlanType(planType, description, contractPrice, annual, semiAnnual, quarterly, monthly);
		request.getRequestDispatcher("/selected_plan_type_table.jsp").forward(request, response);
	}
%>

<body>
	<center>
		<form action="PageController">
			Plan Type: <input type="text" name="plantype"/><br /><br />
			Description: <textarea name="description" cols="30" rows="10"></textarea><br /><br />
			Contract Price: <input type="text" name="contractprice" /><br /><br />
			Annual: <input type="text" name="annualprice"/><br /><br />
			SemiAnnual: <input type="text" name="semiannualprice"/><br /><br />
			Quarterly: <input type="text" name="quarterlyprice"/><br /><br />
			Monthly: <input type="text" name="monthlyprice"/><br /><br /><br />
			
			<button type="submit" name="btn" value="addplantype">Add</button>
			<button type="submit" name="btn" value="canceladd">Cancel</button>
		</form>
	</center>
</body>
</html>