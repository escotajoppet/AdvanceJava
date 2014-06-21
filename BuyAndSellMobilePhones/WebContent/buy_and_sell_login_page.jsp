<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="buyAndSell" class="buy.and.sell.BuyAndSell" scope="session"/>

<%
	String emailAddress = request.getParameter("emailaddress");
	String password = request.getParameter("password");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("login")){
		if(buyAndSell.login(emailAddress, password)){
			if(!emailAddress.equals("admin")){
				buyAndSell.setEmailAddress(emailAddress);
				buyAndSell.setMemberName(emailAddress);
				request.getRequestDispatcher("/buy_and_sell_member_page.jsp").forward(request, response);
			} else{
				request.getRequestDispatcher("/buy_and_sell_admin_page.jsp").forward(request, response);
			}			
		}
	}
%>

<body>
	<center>
		<h1>Buy And Sell</h1>
		<h3>Sign Up New Member</h3>
		
		<form action="PageController">
			<input type="text" name="emailaddress" placeholder="Email Address"/><br />
			<input type="password" name="password" placeholder="Password"/><br /><br />
			
			<button type="submit" name="btn" value="login">Log In</button>
		</form>
		
		<br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtosearch">Back</button>
		</form>
		
		<br /><br />
		
		<%=buyAndSell.getMessage() %>
		<%buyAndSell.setMessage(""); %>
	</center>
</body>
</html>