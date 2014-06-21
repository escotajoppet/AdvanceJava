<%@page import="java.util.Arrays, sun.org.mozilla.javascript.internal.ast.ForLoop"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Array Populating</title>
<!--  <link rel="stylesheet" href="../css/bootstrap.css" /> -->
<!-- <link rel="stylesheet" href="../css/main.css" /> -->
</head>

<jsp:useBean id="punction" class="p.Punction" scope="session"/>

<%! 
	int num = 0; int resultR = 0; int resultI = 0;
%>

<%
	boolean flag = false;
	String noOfElements = request.getParameter("no-of-elements");
	int noOfElementsToNum = noOfElements!=null ? Integer.parseInt(noOfElements) : 0;
	
	String[] elements = request.getParameterValues("elements");
	String setElements = request.getParameter("setelements");
	String setValues = request.getParameter("setvalues");
	
	String methods = request.getParameter("methods");
	String number = request.getParameter("number");
	String setMethod = request.getParameter("setmethod");
	
	int[] elementsToInt = new int[elements!=null ? noOfElementsToNum : 0];
%>

<body>
	<center>
		<div class="panel panel-primary mainDiv">
			<div class="panel-heading">Populate Array</div>
			<div class="panel-body">
				<form action="assignmentTwoWJS.jsp">
					<div class="alert alert-info">
						<span>Number of elements: </span>
						<span>
							<select name="no-of-elements" id="dropdown">
								<option value="1" >1</option>
								<option value="2" >2</option>
								<option value="3" >3</option>
								<option value="4" >4</option>
								<option value="5" >5</option>
								<option value="6" >6</option>
								<option value="7" >7</option>
								<option value="8" >8</option>
								<option value="9" >9</option>
								<option value="10" >10</option>
								<option value="11" >11</option>
								<option value="12" >12</option>
							</select>
						</span>
					</div>
					
					<div id="texts">

					</div>
				</form>	
					
				<%if(setValues!=null){%>
				
				<div class="alert alert-info">Set of Elements: <p><%for(int i = 0; i<elements.length; i++){out.println(elements[i]); if(i==elements.length-1){} else {out.println(" -> ");}} %></p></div>
				
				<%for(int i = 0; i<elementsToInt.length; i++){
						try{Integer.parseInt(elements[i]); flag = true;}catch(Exception e){flag = false; break;}
					}
					if(flag==true){
						for(int i = 0; i<elementsToInt.length; i++)
							elementsToInt[i] = elements!=null ? Integer.parseInt(elements[i]) : 0;
					}%>
											
					<div class="alert alert-warning">
						<h5>Ascending Order:</h5>
						sortA: <input type="text" class="textValue" value="<%=Arrays.toString(punction.sortA(Arrays.copyOf(elementsToInt, elementsToInt.length))) %>" DISABLED/><br>
						sortAA: <input type="text" class="textValue1" value="<%=Arrays.toString(punction.sortAA(Arrays.copyOf(elementsToInt, elementsToInt.length)))%>" DISABLED/>
					</div>
					
					<div class="alert alert-warning">
						<h5>Descending Order:</h5>
						sortD: <input type="text" class="textValue" value="<%=Arrays.toString(punction.sortD(Arrays.copyOf(elementsToInt, elementsToInt.length))) %>" DISABLED/><br>
						sortDD: <input type="text" class="textValue1" value="<%=Arrays.toString(punction.sortDD(Arrays.copyOf(elementsToInt, elementsToInt.length))) %>" DISABLED/>
					</div>
					
				<%}%>

				<form action="assignmentTwoWJS.jsp">
						<div class="alert alert-info">
							<div class="numericmethod" id="factorial"><input type="radio" name="methods" value="factorial" class="radios"  CHECKED/> Factorial</div>
							<div class="numericmethod" id="fibonacci"><input type="radio" name="methods" value="fibonacci" class="radios" /> Fibonacci</div>
							<input type="text" name="number" placeholder="Enter Number" class="form-control" id="text"/>
							<input type="submit" name="setmethod" value="Get Result!" class="btn btn-success"/>						
						</div>
							
						<%if(setMethod!=null){
								try{
									num = Integer.parseInt(number);
									resultR = methods.equals("factorial") ? punction.factorialR(num) : punction.fibonacciR(num);
									resultI = methods.equals("factorial") ? punction.factorialI(num) : punction.fibonacciI(num);
								} catch(Exception e){
									num = 0;
								}%>								
								
								<div class="alert alert-warning">
									Result R: <input type="text" class="textValue1" value="<%=resultR %>" DISABLED/>
								</div>
								
								<div class="alert alert-warning">
									Result I: <input type="text" class="textValue2" value="<%=resultI %>"  DISABLED/>
								</div>
								
						<%}%>					
					</form>
			</div>
		</div>
	</center>
	
	<script type="text/javascript" src="../js/assignment_2.js"></script>
</body>
</html>