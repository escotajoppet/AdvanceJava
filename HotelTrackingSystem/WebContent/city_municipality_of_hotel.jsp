<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose City</title>
</head>

<jsp:useBean id="hotelReservation" class="hotel.reservation.HotelReservation" scope="session"/>

<% 
	String cityMunicipality = request.getParameter("citymunicipality");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("gethotellists")){
		hotelReservation.setCityMunicipality(cityMunicipality);
		request.getRequestDispatcher("HotelsLists").forward(request, response);
	}
%>

<body>
	<center>
		<form action="Controller">
			<h1>Hotel Accommodation System</h1>
			<button type="submit" name="btn" value="accommodation">Accommodation</button>
			<button type="submit" name="btn" value="sightsandactivities">Sights and Activities</button>
			<button type="submit" name="btn" value="planyourvisit">Plan Your Visit</button>
			<button type="submit" name="btn" value="contactus">Contact Us</button>
			<%
				if(hotelReservation.getLoggedIn().equals("")){
			%>
				<button type="submit" name="btn" value="adminback">Back</button>
			<%
				} else{
			%>
				<button type="submit" name="btn" value="addnewhotel">Add New Hotel</button>
				<button type="submit" name="btn" value="logout">Log Out</button>
			<%
				}
			%>
		</form>
		
		<br /><br />
		
		<form action="Controller">
			<select name="citymunicipality" id="">
				<option value="">City/Municipality...</option>
				<option value="Caloocan">Caloocan</option>
				<option value="Las Piñas">Las Piñas</option>
				<option value="Makati">Makati</option>
				<option value="Malabon">Malabon</option>
				<option value="Mandaluyong">Mandaluyong</option>
				<option value="Manila">Manila</option>
				<option value="Marikina">Marikina</option>
				<option value="Muntinlupa">Muntinlupa</option>
				<option value="Navotas">Navotas</option>
				<option value="Parañaque">Parañaque</option>
				<option value="Pasay">Pasay</option>
				<option value="Pasig">Pasig</option>
				<option value="Pateros">Pateros</option>
				<option value="Quezon City">Quezon City</option>
				<option value="San Juan">San Juan</option>
				<option value="Taguig">Taguig</option>
				<option value="Valenzuela">Valenzuela</option>
			</select>
			
			<button type="submit" name="btn" value="gethotellists">Get List of Hotels</button>
		</form>
	</center>
</body>
</html>