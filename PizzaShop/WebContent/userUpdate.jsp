<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>User profile</title>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<jsp:useBean id="userBean" class="pizza.UserBean" scope="application"></jsp:useBean>
<body><h1>Update your profile by filling below fields</h1>
	<i>$(sessionsScope.username)</i>
		<center>
			<form action="PizzaShop" method="post">
				<table border="0" cellspacing="5" align="center">
					<tr>
						<td align="right">
							Username:
						</td>
						<td align="left">
							<input type="text" value='<jsp:getProperty property="name" name="userBean"/>' name="username" required pattern=".{3,}" title="The username has to be at least 3 characters">
						</td>
					</tr>
					<tr>
						<td align="right">
							E-mail:
						</td>
						<td align="left">
							<input type="email" value='<jsp:getProperty property="email" name="userBean"/>' name="email" required>
						</td>
					</tr>	
					<tr>
						<td align="right">
							Address:
						</td>
						<td align="left">
							<input type="text" value='<jsp:getProperty property="address" name="userBean"/>' name="address" required>
						</td>
					</tr>	
					<tr>
						<td align="center">
							<input type="hidden" name="action" value="update">
							<input type="submit" value="Update">
						</td>
					</tr>
				</table>	
				
				
			</form>
		</center>
	
</body>
</html>