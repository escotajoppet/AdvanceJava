<%@ page import = "java.text.*" %>
<jsp:useBean id="link" class="HotelReservation.HotelRoomRes" scope="session" />
<%
link.clearArr();
 link.viewAllGeneralInfo();
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
			<div id="title"><p>All Reservations</p></div>
			<form action="hrcontroller" method = "Post">	
				<table border ="1">
					<tr>
						<td>Code</td>
						<td>Room Type</td>
						<td>Number of Rooms</td>
						<td>Check-In</td>
						<td>Check-Out</td>
						<td>Number of Days</td>
					</tr>
				
			<%for(int i = 0; i < link.getArrNumCode().size(); i++) { %>
					<tr>
						<td><%=link.getArrNumCode().get(i) %></td>
						<td><%=link.getArrRoomType().get(i)%></td>
						<td><%=link.getArrRooms().get(i)%></td>
						<td><%=link.getArrCheckIn().get(i)%></td>
						<td><%=link.getArrCheckOut().get(i)%></td>
						<td><%=link.getArrDays().get(i)%></td>
										
					</tr>
				<%}
				%>	
				</table>									
				<button name="button" value = "viewAllBack">Back</button>
			</form>
		</div>
	</div>
</body>
</html>	