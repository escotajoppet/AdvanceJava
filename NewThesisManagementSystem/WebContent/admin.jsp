<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:useBean id="thesisManagement" class="thesis.management.ThesisManagement" scope="session"/>

<%
	String display = "none";
	String tableDisplay = "none";
	
	String groupNumber = request.getParameter("groupnumber");

	String updateThesisType = request.getParameter("updatethesistype");
	String updateThesisTitle= request.getParameter("updatethesistitle");
	String updateDescription = request.getParameter("updatedescription");
	String[] members = request.getParameterValues("members");
	
	String btn = request.getParameter("btn");
	
	try{
		if(btn.equals("update")){
			thesisManagement.setPanelistVew(groupNumber);
			thesisManagement.setGroupNumber(Integer.parseInt(groupNumber));
			display = "block";
		} else if(btn.equals("passed")){
			thesisManagement.setGuestView(btn);
			tableDisplay = "block";
		} else if(btn.equals("redefense")){
			thesisManagement.setGuestView(btn);
			tableDisplay = "block";		
		} else if(btn.equals("pending")){
			thesisManagement.setGuestView(btn);
			tableDisplay = "block";		
		} else if(btn.equals("passed with modification")){
			thesisManagement.setGuestView(btn);
			tableDisplay = "block";		
		} else if(btn.equals("all")){
			thesisManagement.setGuestView(btn);
			tableDisplay = "block";		
		} else if(btn.equals("confirmupdate")){
			thesisManagement.confirmUpdate(updateThesisType, updateThesisTitle, updateDescription, members);
		} else if(btn.equals("delete")){
			thesisManagement.removeTitle(Integer.parseInt(groupNumber));
		} 
	} catch(Exception e){
		
	}
%>

<body>
	<center>
		<h1>Thesis Management System</h1>
		
		<form action="PageController">
			Group No.: <input type="text" name="groupnumber" size="2" REQUIRED/><br />
			<button type="submit" name="btn" value="update">Update</button>
			<button type="submit" name="btn" value="delete">Delete</button>
		</form>	
		
		<hr />
			
		<form action="PageController">
			<button type="submit" name="btn" value="passed">View Passed</button>
			<button type="submit" name="btn" value="redefense">View Redefense</button>
			<button type="submit" name="btn" value="pending">View Pending</button>
			<button type="submit" name="btn" value="passed with modification">View Passed with Modification</button>
			<button type="submit" name="btn" value="all">View All</button>			
			
			<hr />
			
			<div id="details" style="display: <%=display%>;">
				<b>Group Number:</b> <input type="text" value="<%=thesisManagement.getGroupNumber() %>" DISABLED/><br />
				<b>Thesis Type:</b> 
					<select name="updatethesistype" id="">
						<option value="Software" <%=thesisManagement.getThesisType().equals("Software") ? "SELECTED" : "" %>>Software</option>
						<option value="Hardware" <%=thesisManagement.getThesisType().equals("Hardware") ? "SELECTED" : "" %>>Hardware</option>
						<option value="Software-Hardware" <%=thesisManagement.getThesisType().equals("Software-Hardware") ? "SELECTED" : "" %>>Software-Hardware</option>
					</select>
				<br />
				<b>Thesis Title:</b> <input type="text" name="updatethesistitle" value="<%=thesisManagement.getThesisTitle() %>" size="50"/><br />
				<b>Brief Description:</b> <input type="text" name="updatedescription" value="<%=thesisManagement.getBriefDescription() %>" size="50"/><br /><br />
				<b>Members:</b> <br />
				
				<%
					for(int i = 0; i<thesisManagement.getMembers().size(); i++){
				%>
						<input type="text" name="members" value="<%=thesisManagement.getMembers().get(i) %>"/><br />
				<%
					} thesisManagement.clearMembers();
				%>
				
				<button type="submit" name="btn" value="confirmupdate">Update Group</button>
				<hr />
			</div>
			
			<div style="display: <%=tableDisplay%>;">
				<table border="2" cellpadding="10">
					<tr>
						<th>Group No</th>
						<th>Thesis Title</th>
						<th>Status</th>
					</tr>
					
					<%
						for(int i = 0; i<thesisManagement.getGuestGroupNumber().size(); i++){
					%>
						<tr>
							<td><%=thesisManagement.getGuestGroupNumber().get(i) %></td>
							<td><%=thesisManagement.getGuestThesisTitle().get(i) %></td>
							<td><%=thesisManagement.getGuestStatus().get(i) %></td>
						</tr>
					<%
						} thesisManagement.clearGuestView();
					%>
				</table>
				<hr />
			</div>
			
			<button type="submit" value="logoutadmin" name="btn">Log Out</button>
		</form>		
		
		<br /><br />
		
		<%=thesisManagement.getMessage() %>
		<%thesisManagement.setMessage(""); %>		
	</center>	
</body>
</html>