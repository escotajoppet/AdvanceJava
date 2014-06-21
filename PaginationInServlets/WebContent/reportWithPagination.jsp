<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page
	import="com.javaworkspace.paginationinservlets.dto.StudentDetailsDTO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagination In Servlets - www.javaworkspace.com</title>
</head>
<body>

<h1>Pagination In Servlets</h1>

<%
	List list = (List) session.getAttribute("studentDetails");

	//for(int i = 0; i<list.size(); i++){
		//System.out.println("list --> " + list.get(i));
	//}
%>

<%
	List pageNumbers = (List) session.getAttribute("pages");

	//for(int i = 0; i<pageNumbers.size(); i++){
		//System.out.println("pageNumbers --> " + pageNumbers.get(i));
	//}
%>

<table border="1">
	<tr bgcolor="orange">
		<td><strong>Student Name</strong></td>
		<td><strong>Father Name</strong></td>
		<td><strong>Age</strong></td>
		<td><strong>Country</strong></td>
	</tr>
	<%
		for (int i = 0; i < list.size(); i++) {
	%>
	<tr>
		<%
			StudentDetailsDTO studentDetailsDTO = (StudentDetailsDTO) list
						.get(i);
				out.println("<td>" + studentDetailsDTO.getStudentName()
						+ "</td>");
				out.println("<td>" + studentDetailsDTO.getFatherName()
						+ "</td>");
				out.println("<td>" + studentDetailsDTO.getAge() + "</td>");
				out.println("<td>" + studentDetailsDTO.getCountry() + "</td>");
		%>
	</tr>
	<%
		}
	%>

	<tr>
		<td colspan="4" align="right">
		<form method="get" action="Controller">
		<table>
			<tr>
				<%
					for (int i = 0; i < pageNumbers.size(); i++) {
				%>
				<td><a href="Controller?pageNumber=<%=pageNumbers.get(i)%>"><%=pageNumbers.get(i)%></a></td>
				<%
					}
				%>
			</tr>
		</table>
		</form>
		</td>
	</tr>
</table>
</body>
</html>