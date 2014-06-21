<jsp:useBean id="link" class="HotelReservation.HotelRoomRes" scope="session" />

<%!
	String err = "";
%>

<%
err="";
try{
	if(request.getParameter("button").equals("paymentSubmit")) {
		int code1 = link.getRoomCode();
		double amount = Double.parseDouble(request.getParameter("amount"));
		link.paymentRes(code1, amount);
		err = "Transaction success.";
	}
} catch(NumberFormatException e) {
	err = "Invalid Input.";
}
%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Online Hotel Room Reservation</title>
	<link rel="stylesheet" href="css/all.css" />
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/name.css" />
</head>
<body>
	<div id="main">
		<div id="form1">
			<div id="title"><p>Payment</p></div>
			<form action="hrcontroller" method = "Post">	
				 <br><br>
				
				<label for="" class = "label">Enter Amount: </label><input type="text" name="amount" class="name1" required /> <br><br>	
				<button name="button" value = "paymentSubmit">Submit</button>
			</form>
			<form action="hrcontroller" method = "Post">
				<button name="button" value = "paymentBack">Back</button>										
			</form>
		</div>
	</div>
	<%if(!err.equals("")) {%>
		<script type="text/javascript">alert("<%=err%>");</script>
	
	<%} %>
</body>
</html>	