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
	String newCategory = request.getParameter("newcategory");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("addcategory")){
		petShop.addCategory(newCategory);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("getcat ")){
		petShop.setSelectedCategory(request.getParameter("btn").substring(7));
		request.getRequestDispatcher("/pet_shop_breeds.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").startsWith("delcat ")){
		petShop.setSelectedCategory(request.getParameter("btn").substring(7));
		petShop.removeSelectedCategory();
	}

	petShop.clearCategoryList();
	petShop.setCategoryList();
%>

<body>
	<center>
		<h2>Select a Category</h2>
		
		<form action="PageController">
			<table border="2" cellpadding="10">
				<tr>
					<th>Category</th>
					<th>Breed Quantity</th>
					<th colspan="2"></th>
				</tr>
				
				<%
					for(int i = 0; i<petShop.getCategory().size(); i++){
				%>
					<tr>
						<td><%=petShop.getCategory().get(i) %></td>
						<td><%=petShop.getQuantities().get(i) %></td>
						<td><button type="submit" value="getcat <%=petShop.getCategory().get(i) %>" name="btn">Get List</button></td>
						<%
							if(petShop.getLoggedAs().equals("admin")){
						%>
							<td><button type="submit" value="delcat <%=petShop.getCategory().get(i) %>" name="btn">Remove</button></td>
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
				<input type="text" name="newcategory"/><button type="submit" name="btn" value="addcategory">Add Category</button>
			<%	
				}			
			%>
		</form>
		
		<br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtomainpage">Back to Main Page</button>
		</form>
	</center>
</body>
</html>