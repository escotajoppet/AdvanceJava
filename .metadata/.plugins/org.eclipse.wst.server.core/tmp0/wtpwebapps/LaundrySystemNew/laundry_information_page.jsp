<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Hey Wash Up?!</title>
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/login.css" /> 
<link rel="stylesheet" href="css/registeruser.css" /> 
<link rel="stylesheet" href="css/informationpage.css" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
		request.getRequestDispatcher("/laundry_recent_transaction.jsp").forward(request, response);
	}
%>

<body>
	<center>
		<div id="main_container">
		<div id="header">
		<img src="img/logo.png" alt="" />
		</div>	
		<div id="background">
		<img src="img/bg.png" alt="" />
	</div>
		<div id="numberofclothes">
		<img src="img/numberOfClothes.png" alt="" />
		</div>
		<h3><%=laundrySystem.getUserEmailAdd() %></h3>
		<div id="information">
		<form action="PageController">
		<label for="" class="text">
			T-Shirt:</label> <input type="text" name="tshirt" class="count"/>
			Short: <input type="text" name="short" class="count"/>
			Pants: <input type="text" name="pants" class="count"/>
			Underwear: <input type="text" name="underwear" class="count"/>
			Others: <input type="text" name="others" class="count"/><br /><br />
			
			Number of Kilos: <input type="text" name="kilo" class="count" REQUIRED/><br /><br />
			
			
			<div id="typesofwashes">
			<img src="img/typesOfWashes.png" alt="" />
			<select name="typeofwash" id="washesdropdown">	
				<option value="">Type of Wash...</option>			
				<option value="Washing Machine">Washing Machine</option>
				<option value="Hand Wash">Hand Wash</option>
				<option value="Dry Clean">Dry Clean</option>
			</select>
			</div>
			
			<div id="modeofpayment">
			<img src="img/modeOfPayment.png" alt="" />
			<select name="modeofpayment" id="paymentdropdown">
				<option value="">Mode of Payment...</option>
				<option value="Cash">Cash</option>
				<option value="Cheque">Cheque</option>
			</select>
			</div>
			
			<div id="modeofservices">
			<img src="img/modeOfService.png" alt="" />
			<select name="typeofservice" id="servicedropdown">
				<option value="">Type of Service...</option>
				<option value="Delivery">Delivery</option>
				<option value="Pick Up">Pick Up</option>
			</select>
			</div>
		
			<br></br>
			<button type="submit" name="btn" value="confirmorder">Confirm Order</button>
			<input type="reset" value="Reset Fields"/>
		</form>
		
		<form action="PageController">
			<button type="submit" name="btn" value="userrecenttransactions">View Recent Transactions</button>
			<button type="submit" name="btn" value="ibacktologinuser">Log Out</button>
		</form>
		</center>
		<br />
		 <h3 class="success"><%=laundrySystem.getMessage() %>
		<%laundrySystem.setMessage(""); %></h3> 
		
	
	</div>
		<div id="footer"></div>
</body>
</html>