<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="loanSystem" class="loan.system.LoanSystem" scope="session"/>

<%
	loanSystem.clearBalance();
	loanSystem.setBalance();
%>

<body>
	<center>
		<h1>SELECT AN OPTION</h1>
		<h3>Welcome, <%=loanSystem.getUsername() %></h3>
		<form action="Controller">
			<button type="submit" value="loan" name="btn" <%=loanSystem.getRB()>0 ? "DISABLED" : "" %>>LOAN</button>
			<button type="submit" value="payment" name="btn">PAYMENT</button>
			<button type="submit" value="balance" name="btn">BALANCE</button>
			<button type="submit" value="setanothercustomer" name="btn">SET CUSTOMER</button>
		</form>
		
		<h3>BALANCE PAGE</h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>Balance As Of</th>
				<th>Loan Amount</th>
				<th>Loan Interest</th>
				<th>Principal Amount</th>
				<th>Payment</th>
				<th>Remaining Balance</th>
			</tr>
			
			<%
				for(int i = 0; i<loanSystem.getTransactionDates().size(); i++){
			%>
				<tr>
					<td><%=loanSystem.getTransactionDates().get(i) %></td>
					<td><%=loanSystem.getLoanAmount().get(i) %></td>
					<td><%=loanSystem.getLoanInterest().get(i) %></td>
					<td><%=loanSystem.getTotalAmount().get(i) %></td>
					<td><%=loanSystem.getPayments().get(i) %></td>
					<td><%=loanSystem.getRemainingBalance().get(i) %></td>
				</tr>
			<%
				}
			%>
		</table>
		
		<br /><br />
		
		<%=loanSystem.getMessage() %>
		<%loanSystem.setMessage(""); %>
	</center>
</body>
</html>