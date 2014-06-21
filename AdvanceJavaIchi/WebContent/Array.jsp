<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>

<jsp:useBean id="joppetpanget" class="P.Punction" scope="session"/>

<%
	String opt = request.getParameter("opt");
	String sub = request.getParameter("sub");
	String[] elements = request.getParameterValues("elem");
	String set = request.getParameter("set");
	
	int[] elemToNum = new int [elements != null ? elements.length : 0];
	int dimension = opt != null ? Integer.parseInt(opt) : 0;
	
	if(set !=null && elements != null){
		for(int i=0; i<elemToNum.length; i++){
			elemToNum[i] = Integer.parseInt(elements[i]);
		}
	}
%>

<body>
<center>
	<form action="">
		<h3>Populate Array</h3>
		Select number of Dimension/s: <select name="opt" id="">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select>
		<input type="submit" name="sub"  value="Submit"/> <br> 
		
		<%
			for (int x=0; x<dimension; x++){
			%>
				<input type="text" placeholder="<%=x+1%>" name="elem"/>
			<%
			}
		%>
		<br><input type="submit" name="set" value="Set Values!"/>
		<%
			if(set != null){
		%>
			<div id="ascending">
			<h2>Ascending: </h2>
			Sort A: <input type="text" value="<%for(int i=0; i<elemToNum.length; i++){out.println(joppetpanget.sortA(elemToNum)[i] + ", ");}%>"  DISABLED/><br />
			Sort AA: <input type="text" value="<%for(int i=0; i<elemToNum.length; i++){out.println(joppetpanget.sortAA(elemToNum)[i] + ", ");}%>" DISABLED/>
		</div>
		
		<div id="descending">
			<h2>Descending: </h2>
			Sort D: <input type="text" value="<%for(int i=0; i<elemToNum.length; i++){out.println(joppetpanget.sortD(elemToNum)[i] + ", ");}%>" DISABLED/><br />
			Sort DD: <input type="text" value="<%for(int i=0; i<elemToNum.length; i++){out.println(joppetpanget.sortDD(elemToNum)[i] + ", ");}%>" DISABLED/>
		</div>
		<%
			}
		%>
		
	</form>
</center>
</body>
</html>