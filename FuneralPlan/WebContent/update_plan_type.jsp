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
	String updatedPlanType = request.getParameter("updateplantype");
	String updatedDescription = request.getParameter("updatedescription");
	String updatedContractPrice = request.getParameter("updatecontractprice");
	String updatedAnnual = request.getParameter("annualprice");
	String updatedSemiAnnual = request.getParameter("semiannualprice");
	String updatedQuarterly = request.getParameter("quarterlyprice");
	String updatedMonthly = request.getParameter("monthlyprice");

	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("updateplantype")){
		funeralPlan.updatePlanTypes(updatedPlanType, updatedDescription, updatedContractPrice, updatedAnnual, updatedSemiAnnual, updatedQuarterly, updatedMonthly);
		request.getRequestDispatcher("/selected_plan_type_table.jsp").forward(request, response);
	}
	
	funeralPlan.setUpdateFields();
%>

<body>
	<center>
		<form action="PageController">
			Plan Type: <input type="text" name="updateplantype" value="<%=funeralPlan.getPlanTypes().get(0)%>"/><br /><br />
			Description: <textarea name="updatedescription" cols="30" rows="10"><%=funeralPlan.getDescriptions().get(0)%></textarea><br /><br />
			Contract Price: <input type="text" name="updatecontractprice" value="<%=funeralPlan.getContractPrices().get(0)%>"/><br /><br />
			Annual: <input type="text" name="annualprice" value="<%=funeralPlan.getAnnuals().get(0)%>"/><br /><br />
			SemiAnnual: <input type="text" name="semiannualprice" value="<%=funeralPlan.getSemiAnnuals().get(0)%>"/><br /><br />
			Quarterly: <input type="text" name="quarterlyprice" value="<%=funeralPlan.getQuarterlys().get(0)%>"/><br /><br />
			Monthly: <input type="text" name="monthlyprice" value="<%=funeralPlan.getMonthlys().get(0)%>"/><br /><br /><br />
			
			<button type="submit" name="btn" value="updateplantype">Update</button>
			<button type="submit" name="btn" value="cancelupdate">Cancel</button>
			
			<%funeralPlan.clearPlanTable(); %>
		</form>
	</center>
</body>
</html>