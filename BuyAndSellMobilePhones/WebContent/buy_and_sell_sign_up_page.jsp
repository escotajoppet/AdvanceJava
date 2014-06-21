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
	String sellerName = request.getParameter("sellername");
	String number = request.getParameter("sellernumber");
	String emailAddress = request.getParameter("emailaddress");
	String fbAccount = request.getParameter("fbaccount");
	String password = request.getParameter("password");
	String retypePass = request.getParameter("retypepass");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("signup")){
		buyAndSell.addNewEntrySeller(sellerName, number, emailAddress, fbAccount, password, retypePass);
	}	
%>

<body>
	<center>
		<h1>Buy And Sell</h1>
		<h3>Sign Up New Member</h3>
		
		<h3>Enter Seller's Information</h3>
		<form action="PageController">
			<input type="text" name="sellername" placeholder="Name" size="25" REQUIRED/><br /><br />
			<input type="text" name="sellernumber" placeholder="Contact Number" size="25"REQUIRED/><br /><br />
			<input type="text" name="emailaddress" placeholder="Email Address" size="25" REQUIRED/><br /><br />
			<input type="text" name="fbaccount" placeholder="Facebook Account" size="25"/><br /><br />
			<input type="password" name="password" placeholder="Password" size="25" REQUIRED/><br /><br />
			<input type="password" name="retypepass" placeholder="Retype Password" size="25" REQUIRED/><br /><br /><br />
			
			
			<button type="submit" name="btn" value="signup">Sign Up</button>
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