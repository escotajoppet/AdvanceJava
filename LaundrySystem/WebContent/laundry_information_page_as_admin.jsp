<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="laundrySystem" class="laundry.system.LaundrySystem" scope="session"/>

<%!
	String updateValue = "Update Status";
%>

<%	
	boolean flagUpdate = false;
	
	String[] status = request.getParameterValues("status");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("de ")){
		laundrySystem.removeTransaction(request.getParameter("btn").substring(3));
		updateValue = "Update Status";
		flagUpdate = false;
	} else if(request.getParameter("btn")!=null && (request.getParameter("btn").equals("Update Status") || request.getParameter("btn").equals("Confirm Update"))){
		if(updateValue.equals("Update Status")){
			flagUpdate = true;
			updateValue = "Confirm Update";
		} else{
			laundrySystem.setRecentTransaction("1");
			laundrySystem.updateStatus(status);
			laundrySystem.clearRecentTransaction();
			updateValue = "Update Status";
		}
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").equals("adminlogout")){
		updateValue = "Update Status";
		flagUpdate = false;
		request.getRequestDispatcher("/laundry_login_page_as_admin.jsp").forward(request, response);
	}
	
	laundrySystem.setRecentTransaction("1");
%>

<body>
	<center>
		<h2>All Transactions</h2>
		<form action="PageController">		
			<table border="2" cellpadding="3">
				<tr>
					<th>Transaction Date</th>
					<th>Email Address</th>
					<th># of Clothes</th>
					<th># of Kilo</th>
					<th>Amount</th>
					<th>Type of Wash</th>
					<th>Mode of Payment</th>
					<th>Type of Service</th>
					<th>Status</th>
					<th colspan="2"></th>
				</tr>
				
				<%
					for(int i = 0; i<laundrySystem.getRecentTypeOfService().size(); i++){
				%>
					<tr>
						<td><%=laundrySystem.getRecentDate().get(i) %></td>
						<td><%=laundrySystem.getRecentEmail().get(i) %></td>
						<td><%=laundrySystem.getRecentTotalNumberOfClothes().get(i) %></td>
						<td><%=laundrySystem.getRecentKilo().get(i) %></td>
						<td><%=laundrySystem.getRecentAmount().get(i) %></td>
						<td><%=laundrySystem.getRecentTypeOfWash().get(i) %></td>
						<td><%=laundrySystem.getRecentModeOfPayment().get(i) %></td>
						<td><%=laundrySystem.getRecentTypeOfService().get(i) %></td>
						<td><input type="text" name="status" value="<%=laundrySystem.getRecentStatus().get(i) %>" <%=flagUpdate==true ? "" : "DISABLED" %>/></td>
						<td><button type="submit" name="btn" value="de <%=laundrySystem.getRecentDate().get(i) %>">Delete Transaction</button></td>
					</tr>
				<%
					} 	
				%>
			</table>
			
			<br /><br />
	
			<button type="submit" name="btn" value="<%=updateValue %>" <%=laundrySystem.getRecentDate().size()==0 ? "DISABLED" : "" %>><%=updateValue %></button>
			<button type="submit" name="btn" value="adminlogout">Log Out</button>
			
			<br /><br />
			
			<%=laundrySystem.getMessage() %>
			<%laundrySystem.setMessage(""); %>
			<%laundrySystem.clearRecentTransaction(); %>
		</form>
	</center>
</body>
</html>