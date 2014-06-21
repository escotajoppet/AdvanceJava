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
	String newItem = request.getParameter("newitem");
	String newItemPrice = request.getParameter("newitemprice");
	
	String[] productQuantity = request.getParameterValues("productquantity");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("additem")){
		petShop.addNewItem(newItem, newItemPrice);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("delitm ")){
		petShop.removeItems(request.getParameter("btn").substring(7));
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("buyitm ")){
		petShop.setReservation3(request.getParameter("btn").substring(7), Integer.parseInt(productQuantity[petShop.getPetItems().indexOf(request.getParameter("btn").substring(7))]));
		request.getRequestDispatcher("/registration_form.jsp").forward(request, response);
	}
	
	petShop.clearItemList();
	petShop.setItemList();
%>

<body>
	<center>
		<h2>Pet Items</h2>
		
		<form action="PageController">
			<table border="2" cellpadding="3">
				<tr>
					<th>Product Type</th>
					<th>Price per Item</th>
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
					for(int i = 0; i<petShop.getPetItems().size(); i++){
				%>
					<tr>
						<td><%=petShop.getPetItems().get(i) %></td>
						<td><%=petShop.getPricePetItem().get(i) %></td>
						<%
						if(petShop.getLoggedAs().equals("customer")){
						%>
						<td>
							<select name="productquantity" id="" style="width: 100;">
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
						<td><button type="submit" name="btn" value="buyitm <%=petShop.getPetItems().get(i) %>">Buy Item</button></td>
						<%
						} if(petShop.getLoggedAs().equals("admin")){
							%>
							<td><button type="submit" name="btn" value="delitm <%=petShop.getPetItems().get(i) %>">Remove Item</button></td>
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
				<input type="text" name="newitem" placeholder="New Pet Item"/>
				<input type="text" name="newitemprice" placeholder="Price"/>
				<button type="submit" name="btn" value="additem">Add Item</button>
			<%
				}
			%>
		</form>
			
		<br /><br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtomainpage">Back to Main Page</button>
		</form>
	</center>
</body>
</html>