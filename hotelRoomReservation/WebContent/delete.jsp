<jsp:useBean id="link" class="HotelReservation.HotelRoomRes" scope="session" />

<%!
	String err = "";
%>

<%
err= "";
try {	
	if(request.getParameter("button").equals("deleteDelete")) {
		link.setRoomCode(Integer.parseInt(request.getParameter("code")));
		String checkCode = link.checkCode(link.getRoomCode());
		if(checkCode.equals("error")) {
			err = "Invalid Code.";
		} else {
			link.deleteRes();
			err = "Successfully deleted";
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
			<div id="title"><p>Delete Reservation</p></div>
			<form action="hrcontroller" method = "Post">	
				 <br><br>
				<label for="" class = "label">Enter Code: </label><input type="text" name="code" class="name1" required /> <br><br>	
				<button name="button" value = "deleteDelete">Delete</button>
			</form>
			<form action="hrcontroller" method = "Post">
				<button name="button" value = "deleteBack">Back</button>								
			</form>
		</div>
	</div>
	<%if(!err.equals("")) {%>
		<script type="text/javascript">alert("<%=err%>");</script>
	
	<%} %>
</body>
</html>	