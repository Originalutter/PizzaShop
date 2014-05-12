<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import="pizza.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PizzaShop | Shop</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:useBean id="cartBean" class="pizza.CartBean" scope="application">
</jsp:useBean>
<table>
<c:forTokens items="${sessionScope.pizzas}" delims="," var="pizza">
	 <tr>
	 	<td>
	 		<c:out value="${pizza}"/>
 		</td>
 		<td>
 			<form action="PizzaShop" method="post">
 				<input type=submit value="+"/>
				<input type=hidden name="action" value="addpizza"/>
				<input type=hidden name="pizza" value="${pizza}"/>
			</form>
 		</td>
 	</tr>
</c:forTokens>
</table>
<jsp:getProperty property="price" name="cartBean"/>
<jsp:getProperty property="pizza" name="cartBean"/>
</body>
</html>