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
	String selectedPlan = request.getParameter("plan");

	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("next")){
		if(selectedPlan.equals("Cremation Plan")){
			funeralPlan.setPlan("cremationplans");
		} else if(selectedPlan.equals("Life Plans with Money Back")){		
			funeralPlan.setPlan("lifeplanswithmoneyback");	
		} else if(selectedPlan.equals("Traditional Life Plan")){
			funeralPlan.setPlan("traditionallifeplans");
		}
		
		funeralPlan.setSelectedPlanType(selectedPlan);
		request.getRequestDispatcher("/selected_plan_type_table.jsp").forward(request, response);
	}
	
	funeralPlan.setPlans();
%>

<body>
	<center>
		<h1>Select your plan</h1>
		<form action="PageController">
			<table border="2" cellpadding="10" style="width: 1000px;">
				<tr>
					<td colspan="7">Hello, <strong><%=funeralPlan.getName() %></strong></td>
				</tr>
			
				<tr>
					<th>#</th>
					<th>Plan</th>
					<th>Description</th>
				</tr>
				
				<%
					for(int i = 0; i<funeralPlan.getPlans().size(); i++){
				%>
					<tr>
						<td><input type="radio" name="plan" value="<%=funeralPlan.getPlans().get(i) %>" <%=funeralPlan.getPlans().get(i).contains("Traditional") ? "CHECKED" : ""%>/></td>
						<td><%=funeralPlan.getPlans().get(i) %></td>
						<td><%=funeralPlan.getDescription().get(i) %></td>
					</tr>
				<%
					} funeralPlan.clearPlans();
				%>
			</table>
			
			<br /><br />
			
			<button type="submit" name="btn" value="next">Next --></button><br /><br /><br />
		</form>
		<form action="PageController">	
			<button type="submit" name="btn" value="logout">Log Out</button>
			<%if(funeralPlan.getName().equals("admin")){%> <br /><br /><button type="submit" value="backtoadminpage" name="btn">Back to Admin Page</button><%} %>
		</form>	
	</center>
</body>
</html>