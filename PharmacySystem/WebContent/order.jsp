<%@page import="org.apache.tomcat.util.digester.SetTopRule"%>

<jsp:useBean id="pharmacy" class="pharmacy.system.PharmacySystem" scope="session"/>
<%!
	String err = "";
	String dis = "";
	String DISABLED = "";
%>

<%
	String user =  (String)session.getAttribute("username");
	if(session.getAttribute("username")== null) {
	pharmacy.setLogOut(1);
	request.getRequestDispatcher("/signIn.jsp").forward(request, response);
	} else {

		String medicine = request.getParameter("medicineList");
		String num = request.getParameter("num");
		String[] checkbox = request.getParameterValues("checkbox");

		if(request.getParameter("btn") != null && request.getParameter("btn").equals("add")) {
			pharmacy.addToCart(medicine,Integer.parseInt(num));
		} else if(request.getParameter("btn") != null && request.getParameter("btn").equals("order_order")) {
			for(int i=0;i<checkbox.length;i++) {
				String []chkBox = checkbox[i].split("-"); 
				pharmacy.totalAmount(chkBox[0]);
			}	
			request.getRequestDispatcher("/total.jsp").forward(request, response);
		} else if(request.getParameter("btn") != null && request.getParameter("btn").equals("delete")) {
			for(int i=0;i<checkbox.length;i++) {
				String []chkBox = checkbox[i].split("-"); 
				pharmacy.removeCart(Integer.parseInt(chkBox[1]));
			}
			
		} 
	}

%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Online Garage Sale</title>
	<link rel="stylesheet" href="css/all.css" />
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/name.css" />
</head>
<body>
	<div id="main">
		<div id="form1">
			<div id="title"><p>Sign in Account</p> <%=pharmacy.getCartArrSize() %></div>
			<h3><%=err %></h3>
			<form action="Controller" method = "post">
					Medicine: <select name="medicineList">
						<%for(int i = 0; i <pharmacy.getArrSize();i++) { %>
						<option value = "<%=pharmacy.getMedicineList(i)%>"><%=pharmacy.getMedicineList(i)%></option>
						
						<%} %>
					</select>
					<label for="" class = "label">Ilan: </label><input type="text" name="num" class="name1" required/> 		
				<div>
				<%if(pharmacy.getCartArrSize() != 0) { %>
				<table border="1">
				<tr>
					<td></td>
					<td>Medicine</td>
					<td>#</td>
				</tr>
				<% 
					for(int i = 0; i < pharmacy.getCartArrSize(); i++) {
						String concat = ""+pharmacy.getCartMedicineList(i)+"-"+i+"";
				%>
					<tr>
					<td><input type="checkbox" name="checkbox" value = "<%=concat%>" class="name1" /></td>
					<td><%=pharmacy.getCartMedicineList(i)%></td>
					<td><%=pharmacy.getNumber(i)%></td>
					</tr>
				<%
					}
				%>
				</table>
				<%}%>
				</div>
				<div class="send">	
					<button type="submit" name="btn" value="add" class="submit1">Add</button>

					<%=DISABLED =  pharmacy.getCartArrSize() == 0 ? "DISABLED" : ""%>
					<button type="submit" name="btn" value="order_order" class="submit1" <%=DISABLED %>>Order</button>
					<button type="submit" name="btn" value="delete" class="submit1" <%=DISABLED %>>Delete</button>
	
				</div>	
			</form>
		</div>
	</div>
</body>
</html>	



