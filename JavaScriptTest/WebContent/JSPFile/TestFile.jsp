<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JS JSP Test</title>
</head>

<body>	
	<%
		String dropdown = request.getParameter("dropdown");
	%>
	
	<center>
		<form action="">
			<select name="dropdown" id="dropdown">
				<option value="1" >one</option>
				<option value="2" >two</option>
				<option value="3" >three</option>
				<option value="4" >four</option>
				<option value="5" >five</option>
			</select>
			<div id="texts">
			
			</div>
		</form>
		
	</center>
	
	<script type="text/javascript">
		var dropdown = document.getElementById("dropdown");
		var texts = document.getElementById("texts");
		
		dropdown.onchange = function(){
			texts.innerHTML = "";
			for(i =0; i<dropdown[dropdown.selectedIndex].value; i++){	
				var textBoxes = document.createElement("input");
				console.log(dropdown[dropdown.selectedIndex].value);
				textBoxes.name = "elements";
				textBoxes.placeholder = i;
				texts.appendChild(textBoxes);
			}
		};
	</script>
</body>
</html>