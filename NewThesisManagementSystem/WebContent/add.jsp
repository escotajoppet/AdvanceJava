<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title></title>
</head>

<jsp:useBean id="thesisManagement" class="thesis.management.ThesisManagement" scope="session"/>

<%
	String groupNo= request.getParameter("groupno");
	String thesisType = request.getParameter("thesistype");
	String thesisTitle = request.getParameter("thesistitle");
	String briefDescription = request.getParameter("briefdescription");
	String member1 = request.getParameter("member1");
	String member2 = request.getParameter("member2");
	String member3 = request.getParameter("member3");
	String member4 = request.getParameter("member4");
	
	if(request.getParameter("btn")!=null && request.getParameter("btn").equals("addnewtitle")){
		thesisManagement.addNewThesisTitle(Integer.parseInt(groupNo), thesisType, thesisTitle, briefDescription, member1, member2, member3, member4);
	}	
%>

<body>
	<center>
		<h1>Thesis Management System</h1>
		<h2>Add Thesis Title</h2>
		<form action="PageController">
		
			<label for="">Group No.</label>
			<input type="textbox" name="groupno"/>
			
			<br /><br />
			
			<input type="radio" name="thesistype" value="Software"/>
			<label for="">Software</label>
		
			<br />
		
			<input type="radio" name="thesistype" value="Hardware"/>
			<label for="">Hardware</label>
		
			<br />
			
			<input type="radio" name="thesistype" value="Software-Hardware" CHECKED/>
			<label for="">Software-Hardware</label>
			
			<br /><br />
			
			<label for="">Thesis Title</label>
			<input type="textbox" name="thesistitle"/>
			
			<br />
			
			<label for="">Brief Description</label>
			<input type="textbox" name="briefdescription"/>
			
			<br />
			
			<p>Group Members:</p>
			
			<label for="">Group Member Name 1</label>
			<input type="textbox" name="member1"/>
			
			<br />
			
			<label for="">Group Member Name 2</label>
			<input type="textbox" name="member2"/>
			
			<br />
			
			<label for="">Group Member Name 3</label>
			<input type="textbox" name="member3"/>
			
			<br />
			
			<label for="">Group Member Name 4</label>
			<input type="textbox" name="member4"/>
			
			<br />
			
			<br />
			
			<button type="submit" name="btn" value="addnewtitle">Add Thesis Title</button>
			
			<br /><br />
			
			<%=thesisManagement.getMessage() %>
			<%thesisManagement.setMessage(""); %>
		
			<br />
		</form>
		<form action="PageController">
			<button type="submit" name="btn" value="backtoguest">Back to Guest Menu</button>
		</form>	
	</center>
</body>
</html>