<%@ page import = "java.text.*" %>
<jsp:useBean id="link" class="HotelReservation.HotelRoomRes" scope="session" />

<%!
	String btnDisable = "";
%>
<%
 	DecimalFormat df = new DecimalFormat("0.00");
	if(link.getRemainingBalance() == 0) {
		btnDisable = "disabled";
	} else {
		btnDisable = "";
	}	
	if(request.getParameter("button").equals("viewbillProfile")) {
		link.viewCustomerInfo();
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/profile.jsp");
		reqDispatcher.forward(request, response);
	}
%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Online Hotel Room Reservation </title>
	<link rel="stylesheet" href="css/all.css" />
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/name.css" />
</head>
<body>
	<div id="main">
		<div id="form1">
			<div id="title"><p>View Bills <%=link.getRoomCode() %></p></div>
			<form action="hrcontroller" method="post">	
				<table border ="1">
					<tr>
						<td>Code</td>
						<td>Room Type</td>
						<td>Number of Rooms</td>
						<td>Number of Days</td>
						<td>Rate</td>
						<td>Total Balance</td>
						<td>Amount Paid</td>
						<td>Remaining Balance</td>
					</tr>
					<tr>
						<td><%=link.getRoomCode() %></td>
						<td><%=link.getRoomType()%></td>
						<td><%=link.getRooms()%></td>
						<td><%=link.getNumberOfDays()%></td>
						<td><%=df.format(link.getRoomRate())%></td>
						<td><%=df.format(link.getTotalBalance())%></td>
						<td><%=df.format(link.getAmountPaid() )%></td>
						<td><%=df.format(link.getRemainingBalance())%></td>						
					</tr>	
				</table>
				<button name="button" value = "viewbillPay" <%=btnDisable%>>Pay Bills</button>	
				<button name="button" value = "viewbillProfile" <%=btnDisable%>>View Profile</button>				
			</form>
			<form action="hrcontroller" method = "Post">
				<button name="button" value = "viewbillBack">Back</button>									
			</form>
		</div>
	</div>
</body>
</html>	