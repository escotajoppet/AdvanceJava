<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title></title>
</head>

<jsp:useBean id="thesisManagement" class="thesis.management.ThesisManagement" scope="session"/>

<%
	String btn = request.getParameter("btn");
	
	if(btn!=null && btn.equals("gpassed")){
		thesisManagement.setGuestView(btn);
	} else if(btn!=null && btn.equals("gredefense")){
		thesisManagement.setGuestView(btn);
	} else if(btn!=null && btn.equals("gpending")){
		thesisManagement.setGuestView(btn);
	} else if(btn!=null && btn.equals("gpassed with modification")){
		thesisManagement.setGuestView(btn);
	} else if(btn!=null && btn.equals("gall")){
		thesisManagement.setGuestView(btn);
	} 
%>

<body>
	<center>
		<h1>Thesis Management System</h1>
		<h2>Check Status</h2>
		<form action="PageController">
			<button type="submit" name="btn" value="gpassed">View Passed</button>
			<button type="submit" name="btn" value="gredefense">View Redefense</button>
			<button type="submit" name="btn" value="gpending">View Pending</button>
			<button type="submit" name="btn" value="gpassed with modification">View Passed with Modification</button>
			<button type="submit" name="btn" value="gall">View All</button>
		</form>
		
		<br /><br />
		
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
		
		<br />
		
		<form action="PageController">
			<button type="submit" name="btn" value="backtoguest">Back to Guest Menu</button>
		</form>
	</center>	
</body>
</html>