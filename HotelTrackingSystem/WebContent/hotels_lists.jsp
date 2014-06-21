<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotels Lists</title>
</head>

<jsp:useBean id="hotelReservation" class="hotel.reservation.HotelReservation" scope="session"/>

<%!
	String checkBoxValue = "";
%>

<%	
	String[] checks = request.getParameterValues("check");
	String headerVal = hotelReservation.getLoggedIn().equals("") ? "Information" : "Action";
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("remove")){
		hotelReservation.removeHotel(checks);
		checkBoxValue = "";
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("vhl")){
		hotelReservation.setEntryId(request.getParameter("btn").substring(4));
		request.getRequestDispatcher("/location_information.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("vpm")){
		hotelReservation.setEntryId(request.getParameter("btn").substring(4));		
		request.getRequestDispatcher("/promo_information.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("vri")){
		hotelReservation.setEntryId(request.getParameter("btn").substring(4));		
		request.getRequestDispatcher("/room_information.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("ari")){
		hotelReservation.setEntryId(request.getParameter("btn").substring(4));
		request.getRequestDispatcher("/add_room_information.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("apm")){
		hotelReservation.setEntryId(request.getParameter("btn").substring(4));		
		request.getRequestDispatcher("/add_promo.jsp").forward(request, response);
	}
	
	hotelReservation.clearTableData();
	hotelReservation.getHotelList();
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
			<table border="2" cellpadding="3">
				<tr>
					<%if(!hotelReservation.getLoggedIn().equals("")){%><th>#</th><%} %>
					<th>Hotel Name</th>
					<th>Location</th>
					<th>Route From</th>
					<th>Description</th>
					<th colspan="4"><%=headerVal %></th>
					
				</tr>

				<% 
					for(int i = 0; i<hotelReservation.getHotelName().size(); i++){
						int entryId = hotelReservation.getHotelId().get(i);
						String hotelName = hotelReservation.getHotelName().get(i);
						String location = hotelReservation.getLocation().get(i);
						String routeFrom = hotelReservation.getRouteFrom().get(i);
						String description = hotelReservation.getDescription().get(i);
				%>
					<tr>
						<%if(!hotelReservation.getLoggedIn().equals("")){%><td><input type="checkbox" name="check" value="<%=entryId%>"/></td><%} %>
						<td><%=hotelName %></td>
						<td><%=location %></td>
						<td><%=routeFrom %></td>
						<td><%=description %></td>
						<%
							if(hotelReservation.getLoggedIn().equals("")){
						%>
							<td><button type="submit" name="btn" value="vhl <%=entryId %>">View Location</button></td>
							<td><button type="submit" name="btn" value="vpm <%=entryId %>">View Promos</button></td>
							<td><button type="submit" name="btn" value="vri <%=entryId %>">View Room Information</button></td>
						<%
							} else{
						%>
							<td><button type="submit" name="btn" value="ari <%=entryId %>" style="width:100%;">Add Room</button></td>
							<td><button type="submit" name="btn" value="apm <%=entryId %>"  style="width:100%;">Add Promo</button></td>
						<%
							}
						%>
					</tr>
				<%
					}
				%>

			</table>
			
			<br /><br />
			
			<%if(!hotelReservation.getLoggedIn().equals("")){%><button type="submit" name="btn" value="remove">Delete Hotel(s)</button><%} %>
			
		</form>
	</center>
</body>
</html>