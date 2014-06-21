<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="laundrySystem" class="laundry.system.LaundrySystem" scope="session"/>

<%
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("tbacktologinuser")){
		laundrySystem.setUserEmailAdd("");
		request.getRequestDispatcher("/laundry_login_page_as_user.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").equals("cancel")){
		laundrySystem.cancelTransaction();
		request.getRequestDispatcher("/laundry_information_page.jsp").forward(request, response);
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").equals("confirminfo")){
		laundrySystem.confirmTransaction();
		request.getRequestDispatcher("/laundry_information_page.jsp").forward(request, response);
	}
%>

<body>
	<center>
		<h2>Transaction Summary</h2>
		<form action="PageController">
			Number of Clothes: <%=laundrySystem.getTotalNumberOfClothes() %><br />
			Number of Kilos: <%=laundrySystem.getKiloCount() %> <br />
			Amount: <%=laundrySystem.getAmount() %><br />
			Type of Wash: <%=laundrySystem.getTypeOfWash() %><br />
			Mode of Payment: <%=laundrySystem.getModeOfPayment() %><br />
			Type of Services: <%=laundrySystem.getTypeOfService() %><br /><br />
			
			<button type="submit" name="btn" value="confirminfo">Confirm Order</button>
			<button type="submit" name="btn" value="cancel">Cancel Transaction</button>
			<button type="submit" name="btn" value="tbacktologinuser">Log Out</button>
		</form>
	</center>
</body>
</html>