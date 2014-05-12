<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PizzaShop | Shop</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<table>
<% 
Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://mysql12.citynetwork.se/108985-lmm","108985-mb29814","Larsa1952");
Statement st= con.createStatement(); 
ResultSet rs=st.executeQuery("SELECT distinct(name) FROM pizzas"); 
while(rs.next()){
	out.print(
			"<tr>" +
				"<td>" +
					rs.getString(1) +
				"</td>" +
				"<td>" +
					"<div class='plus' value='" + rs.getString(1) + "'><b>+</b></div>" +
			"</tr>");
}
%>
</table>
</body>
</html>