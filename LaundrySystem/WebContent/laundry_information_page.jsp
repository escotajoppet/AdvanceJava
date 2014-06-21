<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="laundrySystem" class="laundry.system.LaundrySystem" scope="session"/>

<%
	String countTShirt = request.getParameter("tshirt");
	String countShort = request.getParameter("short");
	String countPants = request.getParameter("pants");
	String countUnderwear = request.getParameter("underwear");
	String countOthers = request.getParameter("others");
	String countKilo = request.getParameter("kilo");
	String typeOfWash = request.getParameter("typeofwash");
	String typeOfService = request.getParameter("typeofservice");
	String modeOfPayment = request.getParameter("modeofpayment");

	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("confirmorder")){
		laundrySystem.setTransactionConfirmation(countTShirt, countShort, countPants, countUnderwear, countOthers, countKilo, typeOfWash, modeOfPayment, typeOfService);
		request.getRequestDispatcher("/laundry_transaction_summary.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").equals("ibacktologinuser")){
		laundrySystem.setUserEmailAdd("");
		request.getRequestDispatcher("/laundry_login_page_as_user.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").equals("userrecenttransactions")){
		laundrySystem.setRecentTransaction("`emailadd`='"+laundrySystem.getUserEmailAdd()+"'");
		request.getRequestDispatcher("/laundry_recent_transaction.jsp").forward(request, response);
	}
%>

<body>
	<center>
		<h2>Enter Number of Clothes</h2>
		<h3><%=laundrySystem.getUserEmailAdd() %></h3>
		<form action="PageController">
			T-Shirt: <input type="text" name="tshirt"/><br />
			Short: <input type="text" name="short"/><br />
			Pants: <input type="text" name="pants"/><br />
			Underwear: <input type="text" name="underwear"/><br />
			Others: <input type="text" name="others"/><br /><br />
			
			Number of Kilos: <input type="text" name="kilo" REQUIRED/><br /><br />
			
			<select name="typeofwash" id="">
				<option value="">Type of Wash...</option>			
				<option value="Washing Machine">Washing Machine</option>
				<option value="Hand Wash">Hand Wash</option>
				<option value="Dry Clean">Dry Clean</option>
			</select>
			
			<hr />
			
			<select name="modeofpayment" id="">
				<option value="">Mode of Payment...</option>
				<option value="Cash">Cash</option>
				<option value="Cheque">Cheque</option>
			</select>
			
			<br /><br />
			
			<select name="typeofservice" id="">
				<option value="">Type of Service...</option>
				<option value="Delivery">Delivery</option>
				<option value="Pick Up">Pick Up</option>
			</select>
			
			<hr />
			
			<button type="submit" name="btn" value="confirmorder">Confirm Order</button>
			<input type="reset" value="Reset Fields"/>
		</form>
		
		<form action="PageController">
			<button type="submit" name="btn" value="userrecenttransactions">View Recent Transactions</button>
			<button type="submit" name="btn" value="ibacktologinuser">Log Out</button>
		</form>
		
		<br />
		
		<%=laundrySystem.getMessage() %>
		<%laundrySystem.setMessage(""); %>
	</center>
</body>
</html>