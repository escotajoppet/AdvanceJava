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
	String loanAmount = request.getParameter("loanamount");
	String btn = request.getParameter("btn");
	
	try{
		if(btn.equals("getloan")){
			loanSystem.getLoan(loanAmount);
			request.getRequestDispatcher("/choose_options.jsp").forward(request, response);
		}
	} catch(Exception e){
		
	}
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
		
		<h3>LOAN PAGE</h3>
		<form action="Controller">
			<input type="text" name="loanamount"/>
			<button type="submit" name="btn" value="getloan">Get Loan</button>
		</form>
		
		<br /><br />
		
		<%=loanSystem.getMessage() %>
		<%loanSystem.setMessage(""); %>
	</center>
</body>
</html>