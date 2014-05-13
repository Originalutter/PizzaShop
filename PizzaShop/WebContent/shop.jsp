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
<% if(request.getSession().getAttribute("inStock") != null) {
if(request.getSession().getAttribute("inStock").equals("false")) {
	out.println("<script>alert('One or more products are not in stock');</script>");
} else if (request.getSession().getAttribute("inStock").equals("true")) {
	out.println("<script>alert('Purchase completed!');</script>");	
}
}%>

<div style="float:right">
<input type=submit value="Logout" onclick="window.location.href='logout.jsp'"/>
</div>
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
<div>
	Price: 
	<jsp:getProperty property="price" name="cartBean"/>kr
	<form action="PizzaShop" method="post">
		<input type=hidden name="action" value="submitPurchase"/>
		<input type=submit value="Submit purchase"/>
	</form>
</div>
</body>
</html>