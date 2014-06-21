<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="buyAndSell" class="buy.and.sell.BuyAndSell" scope="session"/>

<%
	String inputSearch = request.getParameter("searchbar");
	String searchBy = request.getParameter("searchby");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("search")){
		buyAndSell.clearResults();
		buyAndSell.setSearchResults(inputSearch, searchBy);
		request.getRequestDispatcher("/buy_and_sell_result_page.jsp").forward(request, response);
	} 
%>

<body>
	<center>
		<h1>Buy And Sell</h1>
		<h3>Mobile Phones</h3>
		
		<form action="PageController">
			<input type="text" name="searchbar" placeholder="Search Mobile" REQUIRED/>
			<select name="searchby" id="">
				<option value="devicemodel">Item</option>
				<option value="seller">Seller</option>
			</select>
			<button type="submit" name="btn" value="search">Search</button>
			<br /><br />
		</form>
		
		<form action="PageController">
			<button type="submit" name="btn" value="signupnewmember">Sign Up</button>
			<button type="submit" name="btn" value="loginmember">Log in</button>
		</form>
		
		<br /><br />
		
		<%=buyAndSell.getMessage() %>
		<%buyAndSell.setMessage(""); %>
	</center>
</body>
</html>