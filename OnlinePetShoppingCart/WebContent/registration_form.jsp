<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Pet Shopping Cart</title>
</head>

<jsp:useBean id="petShop" class="online.pet.shop.OnlinePetShop" scope="session"/>

<%
	String lastName = request.getParameter("lastname");
	String firstName = request.getParameter("firstname");
	String address = request.getParameter("address");
	String contactNumber = request.getParameter("contact");
	
	String backToValue = petShop.getFrom().equals("petitems") ? "Pet Items" : "Breeds";
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("getreservation")){
		lastName = lastName.substring(0, 1) + lastName.substring(1);
		firstName = firstName.substring(0, 1) + firstName.substring(1);
		String fullName =  lastName + ", " + firstName;
		petShop.setReservation2(fullName, address, contactNumber);
		petShop.addReservation();
		
		request.getRequestDispatcher("/end_of_reservation.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").equals("backto")){
		String pageLocation = petShop.getFrom().equals("petitems") ? "pet_shop_pet_products.jsp" : "pet_shop_breeds.jsp";
		request.getRequestDispatcher(pageLocation).forward(request, response);
	}
%>

<body>
	<center>
		<h2>Registration Form</h2>
		<form action="PageController">
			Last Name: <input type="text" name="lastname"/><br />
			First Name: <input type="text" name="firstname"/><br />
			Address: <input type="text" name="address"/><br />
			Contact Number: <input type="text" name="contact"/><br /><br />
			
			<button type="submit" name="btn" value="getreservation">Submit</button>
	
			<br />
			
			<button type="submit" name="btn" value="backto">Back to <%=backToValue %> Section</button>
		</form>
	</center>
</body>
</html>