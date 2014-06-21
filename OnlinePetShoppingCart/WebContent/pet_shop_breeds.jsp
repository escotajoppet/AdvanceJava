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
	String newEntry = request.getParameter("newentry");
	String price = request.getParameter("price");
	
	String[] breedQuantity = request.getParameterValues("breedquantity");
	
	String btn = request.getParameter("btn");
	
	if(btn!=null && btn.equals("addbreed")){
		petShop.addNewEntry(newEntry, price);
	} else if(btn!=null && btn.startsWith("delbrd ")){
		petShop.removeEntry(btn.substring(7));
	} else if(btn!=null && btn.startsWith("resbrd ")){
		petShop.setReservation1(btn.substring(7), Integer.parseInt(breedQuantity[petShop.getEntryId().indexOf(Integer.parseInt(btn.substring(7)))]));
		request.getRequestDispatcher("/registration_form.jsp").forward(request, response);
	}

	petShop.clearSelectedCategoryBreeds();
	petShop.setSelectedCategoryBreeds();
%>

<body>
	<center>
		<h2>Category: <%=petShop.getSelectedCategory() %></h2>
		
		<form action="PageController">
			<table border="2" cellpadding="3">
				<tr>
					<th>Entry Id</th>
					<th>Breed Name</th>
					<th>Price</th>
					<%
						if(petShop.getLoggedAs().equals("customer")){
					%>
						<th>Quantity</th>
						<th colspan="2"></th>
					<%
						}
					%>
				</tr>
				
				<%
					for(int i = 0; i<petShop.getEntryId().size(); i++){
						String categoryBreed = petShop.getCategoryBreeds().get(i);
						String categoryEntryNumber = petShop.getEntryId().get(i).toString();
				%>
					<tr>
						<td><%=categoryEntryNumber %></td>
						<td><%=categoryBreed %></td>
						<td><%=petShop.getBreedPrices().get(i) %></td>
						<%
							if(petShop.getLoggedAs().equals("customer")){
						%>
							<td>
								<select name="breedquantity" id="" style="width: 100%;">
									<option value=""></option>
									<%
										for(int j = 1; j<11; j++){
									%>
										<option value="<%=j %>"><%=j %></option>
									<%
										}
									%>
								</select>
							</td>
							<td><button type="submit" name="btn" value="resbrd <%=categoryEntryNumber %>">Reserve</button></td>
						<%
							}
						%>
						<%
							if(petShop.getLoggedAs().equals("admin")){
						%>
							<td><button type="submit" name="btn" value="delbrd <%=categoryEntryNumber %>">Remove Entry</button></td>
						<%
							}
						%>
					</tr>
				<%
					}
				%>
			</table>
		</form>
		
		<br />
		
		<form action="PageController">
			<%
				if(petShop.getLoggedAs().equals("admin")){
			%>
				<input type="text" placeholder="Breed Name" name="newentry" size="25"/>
				<input type="text" placeholder="Price" name="price" size="25"/>
				<button type="submit" name="btn" value="addbreed">Add New Breed</button>
			<%
				}
			%>
		</form>
		
		<br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtocategorylist">Back to Category List</button>
		</form>
	</center>
</body>
</html>