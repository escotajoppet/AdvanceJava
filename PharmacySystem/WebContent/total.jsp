<%@page import="org.apache.tomcat.util.digester.SetTopRule"%>

<jsp:useBean id="pharmacy" class="pharmacy.system.PharmacySystem" scope="session"/>
<%!
	String err = "";
%>

<%
	String user =  (String)session.getAttribute("username");
	if(session.getAttribute("username")== null) {
	pharmacy.setLogOut(1);
	request.getRequestDispatcher("/signIn.jsp").forward(request, response);
	} else {
		if(request.getParameter("btn") != null && request.getParameter("btn").equals("back")) {
			pharmacy.clearArr();
			pharmacy.medicineList();
			pharmacy.setTotal(0);
			request.getRequestDispatcher("/order.jsp").forward(request, response);
		} 
	}

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Controller" method = "post">
	<h2>Total Amount: <%=pharmacy.getTotal() %></h2>
	<button type="submit" name="btn" value="back" class="submit1">Back</button>
</form>	
</body>
</html>