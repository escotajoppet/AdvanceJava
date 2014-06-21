<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Pet Shopping Cart</title>
<link rel="stylesheet" href="css/all.css" />
</head>

<jsp:useBean id="petShop" class="online.pet.shop.OnlinePetShop" scope="session"/>

<%
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("petproducts")){
		petShop.setFrom("petitems");
		request.getRequestDispatcher("/pet_shop_pet_products.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").equals("listofpets")){
		petShop.setFrom("petlist");
		request.getRequestDispatcher("/pet_shop_pet_list.jsp").forward(request, response);
	}
%>

<body>
	<center>
		<h1>Web-Based Pet Shopping Cart</h1>
		<form action="PageController">
			<button type="submit" name="btn" value="listofpets">List of Pets</button><br /><br />
			<button type="submit" name="btn" value="petproducts">Pet Products</button>
			
			<%
				if(petShop.getLoggedAs().equals("admin")){
			%>
				<br /><br />
				<button type="submit" name="btn" value="viewallreservations">View All Reservations</button>
			<%
				}
			%>
			<br /><br />
			
			<button type="submit" name="btn" value="logout">Log Out</button>
		</form>
	</center>
</body>
</html>