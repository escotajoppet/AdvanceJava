<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title></title>
</head>

<jsp:useBean id="thesisManagement" class="thesis.management.ThesisManagement" scope="session"/>

<%
	String display = "none";

	String groupNumber = request.getParameter("groupnumberp");
	String verdict = request.getParameter("verdict");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("set")){
		thesisManagement.setPanelistVew(groupNumber);
		display = "block";
	} else if(request.getParameter("btn")!=null && request.getParameter("btn").equals("submitverdict")){
		thesisManagement.updateStatus(verdict);
	}
%>

<body>
	<center>
		<h1>Thesis Management System</h1>
		<h2>Log In As Panelist</h2>
		
		<form action="PageController">
			Group No.: <input type="text" name="groupnumberp" size="5"/><button type="submit" name="btn" value="set">Set Group</button>
			<hr />
			<div id="details" style="display: <%=display%>;">
				<b>Group Number:</b> <%=thesisManagement.getGroupNumber() %><br />
				<b>Thesis Type:</b> <%=thesisManagement.getThesisType() %><br />
				<b>Thesis Title:</b> <%=thesisManagement.getThesisTitle() %><br />
				<b>Brief Description:</b> <%=thesisManagement.getBriefDescription() %><br /><br />
				<b>Members:</b> <br />
				
				<%
					for(int i = 0; i<thesisManagement.getMembers().size(); i++){
				%>
						<%=thesisManagement.getMembers().get(i) %><br />
				<%
					} thesisManagement.clearMembers();
				%>
			
	
				<br />
		
				<input type="radio" name="verdict" value="passed" CHECKED/>
				<label for="">Passed</label>
				<br />
				
				<input type="radio" name="verdict" value="passed with modification" />
				<label for="">Passed with Modification</label>
				<br />
				
				<input type="radio" name="verdict" value="pending" />
				<label for="">Pending</label>
				<br />
				
				<input type="radio" name="verdict" value="redefense" />
				<label for="">Redefense</label>
				<br />
				<br />
				
				<button type="submit" value="submitverdict" name="btn">SUBMIT</button>
			</div>
			
			<button type="submit" value="panelistlogout" name="btn">Log Out</button>
			
			<br /><br />
			
			<%=thesisManagement.getMessage() %>
			<%thesisManagement.setMessage(""); %>
		</form>	
	</center>
</body>
</html>