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
	String selectedPlanType = request.getParameter("selectedplantype");
	String selectedPaymentType = request.getParameter("selectedpaymenttype");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("submit")){
		funeralPlan.submitSelectedPlan(selectedPlanType, selectedPaymentType);
		funeralPlan.addToTransactionLog();
		request.getRequestDispatcher("/submitted_data.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("udtpln ")){
		funeralPlan.setPlanType(request.getParameter("btn").substring(7));
		request.getRequestDispatcher("/update_plan_type.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("rmvpln ")){
		funeralPlan.removePlanType(request.getParameter("btn").substring(7));
	}
	
	funeralPlan.clearPlanTable();
	funeralPlan.setSelectedPlan();
%>

<body>
	<center>
		<h1><%=funeralPlan.getSelectedPlanType() %></h1>
		<table border="2" cellpadding="10" style="width: 1000px;">
			<tr>
				<td colspan="8">Hello, <strong><%=funeralPlan.getName() %></strong></td>
			</tr>
			
			<tr>
				<th>Plan Type</th>
				<th>Description </th>
				<th>Contract Price</th>
				<th>Annual</th>
				<th>SemiAnnually</th>
				<th>Quarterly</th>
				<th>Monthly</th>
				<%if(funeralPlan.getName().equals("admin")){%><th></th><%}%>
			</tr>
			
			<%
				for(int i = 0; i<funeralPlan.getPlanTypes().size(); i++){
			%>
				<tr>
					<td><%=funeralPlan.getPlanTypes().get(i) %></td>
					<td><%=funeralPlan.getDescriptions().get(i).replace(", ", "<br />") %></td>
					<td><%=funeralPlan.getContractPrices().get(i) %></td>
					<td><%=funeralPlan.getAnnuals().get(i) %></td>
					<td><%=funeralPlan.getSemiAnnuals().get(i) %></td>
					<td><%=funeralPlan.getQuarterlys().get(i) %></td>
					<td><%=funeralPlan.getMonthlys().get(i) %></td>
					<td><form action="PageController"><%if(funeralPlan.getName().equals("admin")){%> <button type="submit" name="btn" value="udtpln <%=funeralPlan.getPlanTypes().get(i) %>">Update Plan</button><br /><button type="submit" name="btn" value="rmvpln <%=funeralPlan.getPlanTypes().get(i) %>">Delete Plan</button><%}%></form></td>
				</tr>
			<%
				} 
			%>
		</table>
		
		<br /><br />
		
		<form action="PageController">
			<%
				if(!funeralPlan.getName().equals("admin")){
			%>
				<select name="selectedplantype" id="">
					<option value="">Type of Plan...</option>
					<%
						for(int i = 0; i<funeralPlan.getPlanTypes().size(); i++){
					%>
						<option value="<%=funeralPlan.getPlanTypes().get(i) %>"><%=funeralPlan.getPlanTypes().get(i) %></option>
					<%
						}
					%>
				</select>
				
				<select name="selectedpaymenttype" id="">
					<option value="">Type of Payment...</option>
					<option value="contract_price">Full Payment</option>
					<option value="annual">Annual</option>
					<option value="semi_annual">Semi Annual</option>
					<option value="quarterly">Quarterly</option>
					<option value="monthly">Monthly</option>
				</select>
				
				<br /><br />
				
				<button type="submit" name="btn" value="submit">Submit</button><br />
			<%
				} else if(funeralPlan.getName().equals("admin")){
			%>
				<button type="submit" name="btn" value="addnewplantype">Add New Plan Type</button><br />
			<%
				}
			%>
			<button type="submit" name="btn" value="back">Back to Plan List</button>
		</form>
	</center>
</body>
</html>