<jsp:useBean id="link" class="HotelReservation.HotelRoomRes" scope="session" />
<%@ page import="hotel.room.*" %>
<%!
	String err = "";
%>

<%
err="";
try{
	if(request.getParameter("button").equals("changeNext")) {
		link.setRoomCode(Integer.parseInt(request.getParameter("code")));
		//int code1 = Integer.parseInt(code);
		String checkCode = link.checkCode(link.getRoomCode());
		if(checkCode.equals("error")) {
			err = "Invalid Code.";
		} else {
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("update.jsp");
			reqDispatcher.forward(request, response);
		}
	} 
} catch(NumberFormatException e) {
	err = "Invalid Code.";
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
			<div id="title"><p>Change Reservation</p></div>
			<form action="hrcontroller" method = "Post">	
				<br><br>
				<label for="" class = "label">Enter Code: </label><input type="text" name="code" class="name1" required /> <br><br>	
				<button name="button" value = "changeNext">Next</button>	
			</form>
			<form action="hrcontroller" method = "Post">
				<button name="button" value = "changeBack">Back</button>									
			</form>			
		</div>
	</div>
	
	<%if(!err.equals("")) {%>
		<script type="text/javascript">alert("<%=err%>");</script>	
	<%} %>
</body>
</html>	