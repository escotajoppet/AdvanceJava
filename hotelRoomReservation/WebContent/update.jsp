<jsp:useBean id="link" class="HotelReservation.HotelRoomRes" scope="session" />

<%!String err = "";%>

<%
	err = "";
	if(request.getParameter("button").equals("updateChange")) {	
		try{
			link.setfName(request.getParameter("firstName"));
			link.setlName(request.getParameter("lastName"));
			link.setAddress(request.getParameter("address"));
			link.setContact(Integer.parseInt(request.getParameter("contactNum")));
			link.setEmail(request.getParameter("emailAdd"));
			link.setRoomType(request.getParameter("roomType"));
			link.setRooms(Integer.parseInt(request.getParameter("roomNumber")));
			link.setCheckIn(request.getParameter("dateCheckIn"));
			link.setCheckOut(request.getParameter("dateCheckOut"));
					
			int checkIn1 = Integer.parseInt(link.getCheckIn().replaceAll("-", ""));
			int checkOut1 = Integer.parseInt(link.getCheckOut().replaceAll("-", ""));
			int day =0;
			String checkDate = link.checkAvailability(link.getCheckIn(), link.getRoomType(), link.getRooms());
			if(checkOut1 < checkIn1) {
				err = "Invalid Date";
			} else if(checkDate.equals("error")) {
				err = "The room is already reserved.";		
			} else {
				if(link.getCheckIn().equals(link.getCheckOut())) {
					day = 1;	
				} else {
					long days = link.numberOfDays(link.getCheckIn(),link.getCheckOut());
					day = (int)days;										
				}
				link.setNumberOfDays(day);
				int code = link.updateResCustomer();
				link.updateResGeneral();
				link.updateResBalance();				
				err = "Reservation successfully updated.";	
			}			
		} catch(NumberFormatException e) {
			err = "Invalid Input!!!";
		}
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
			
			<h2>Customer Information</h2>
			<form action="hrcontroller" method = "Post">	
				<label for="" class = "label">First Name: </label><input type="text" name="firstName" class="name1" required /> <br><br>	
				<label for="" class = "label">Last Name: </label><input type="text" name="lastName" class="name1" required /> <br><br>
				<label for="" class = "label">Address: </label><input type="text" name="address" class="name1" required /> <br><br>
				<label for="" class = "label">Contact No.: </label><input type="text" name="contactNum" class="name1" required /> <br><br>
				<label for="" class = "label">Email Address: </label><input type="text" name="emailAdd" class="name1" required /> <br><br>
				
			<h2>General Information</h2>
				<label for="" class = "label">Room Type: </label>
				<select name="roomType" class = "name4">
					<option value="standardRoom">Standard Room</option>
					<option value="familyRoom">Family Room</option>
					<option value="suite">Suite</option>
				</select><br><br>
				<label for="" class = "label">Number of Rooms: </label>
				<select name="roomNumber" class = "name4">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select><br><br>								
				<label for="" class = "label">Check In: </label><input type="date" name="dateCheckIn" /><br><br>
				<label for="" class = "label">Check Out: </label><input type="date" name="dateCheckOut" /><br><br>
				<button name="button" value = "updateChange">Change</button>
			</form>
			<form action="hrcontroller" method = "Post">	
				<button name="button" value = "updateBack">Back</button>							
			</form>	
		</div>
	</div>
	<%if(!err.equals("")) {%>
		<script type="text/javascript">alert("<%=err%>");</script>
	
	<%} %>
</body>
</html>	