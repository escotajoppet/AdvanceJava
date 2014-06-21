<%@ page import = "java.text.*" %>
<jsp:useBean id="link" class="HotelReservation.HotelRoomRes" scope="session" />


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
			<div id="title"><p>Profile</p></div>
			<form action="hrcontroller" method = "Post">	
				<table border ="1">
					<tr>
						<td>Code</td>
						<td>First Name</td>
						<td>Last Name</td>
						<td>Address</td>
						<td>Contact Number</td>
						<td>Email Address</td>
					</tr>
					<tr>
						<td><%=link.getRoomCode() %></td>
						<td><%=link.getfName()%></td>
						<td><%=link.getlName()%></td>
						<td><%=link.getAddress()%></td>
						<td><%=link.getContact()%></td>
						<td><%=link.getEmail()%></td>					
					</tr>	
				</table>
				<button name="button" value = "profileBack">Back</button>
			</form>
		</div>
	</div>
</body>
</html>	