<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import="pizza.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PizzaShop | Admin</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<table>
<c:forTokens items="${sessionScope.ingredients}" delims="," var="ingredient">
	 <tr>
	 	<td>
	 		<c:out value="${ingredient}"/>
 		</td>
 		<td>
 			<form action="PizzaShop" method="post">
 				<input type=number name="increase" min=0>
 				<input type=submit value="+"/>
				<input type=hidden name="action" value="increaseStock"/>
				<input type=hidden name="ingredient" value="${ingredient}"/>
			</form>
 		</td>
 	</tr>
</c:forTokens>
</table>
<br>
Compose new pizza: <br>
<form action="PizzaShop" method="post">
	<input type=text name="name" placeholder="Name"/>
	<input type=text name="ingredient1" placeholder="1st ingredient"/>
	<input type=text name="ingredient2" placeholder="2nd ingredient"/>
	<input type=text name="ingredient3" placeholder="3rd ingredient"/>
	<input type=text name="ingredient4" placeholder="4th ingredient"/>
	<input type=text name="ingredient5" placeholder="5th ingredient"/>
 	<input type=submit value="Submit"/>
	<input type=hidden name="action" value="composeNewPizza"/>
</form>
</body>
</html>