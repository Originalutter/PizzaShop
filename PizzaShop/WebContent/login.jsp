<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.12.0/jquery.validate.min.js" ></script>
<script>
	$( document ).ready(function() {
	  // Handler for .ready() called.
		$('#registerBtn').click(function(){
			$('#loginForm').hide();
			$('#registerForm').show();
		});
		$('#loginBtn').click(function(){
			$('#registerForm').hide();
			$('#loginForm').show();
		});
	});
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PizzaShop | Login</title>
</head>
<body>
	<center>
		<form id="loginForm" method="post" action="PizzaShop">
			<fieldset>
		  		<legend>LOGIN</legend>
				<table border="0" cellspacing="5" align="center">
					<tr>
						<td align="right">
							Username:
						</td>
						<td align="left">
							<input type="text" name="username">
						</td>
					</tr>
					<tr>
						<td align="right">
							Password:
						</td>
						<td align="left">
							<input type="password" name="password">
						</td>
					</tr>	
					<tr>
						<td>
							<input id="registerBtn" type="button" value="Register">
						</td>
						<td align="center">
							<input type="hidden" name="action" value="login">
							<input type="submit" value="Log in">
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
		<form id="registerForm" method="post" action="PizzaShop" style="display:none">
		  	<fieldset>
		  		<legend>REGISTER</legend>
			    <table border="0" cellspacing="5" align="center">
					<tr>
						<td align="right">
							Username:
						</td>
						<td align="left">
							<input type="text" name="username" required pattern=".{3,}" title="The username has to be at least 3 characters">
						</td>
					</tr>
					<tr>
						<td align="right">
							Password:
						</td>
						<td align="left">
							<input type="password" name="password">
						</td>
					</tr>	
					<tr>
						<td align="right">
							E-mail:
						</td>
						<td align="left">
							<input type="email" name="email" required>
						</td>
					</tr>	
					<tr>
						<td align="right">
							Address:
						</td>
						<td align="left">
							<input type="text" name="address" required>
						</td>
					</tr>	
					<tr>
						<td>
							<input id="loginBtn" type="button" value="Log in">
						</td>
						<td align="center">
							<input type="hidden" name="action" value="register">
							<input type="submit" value="Register">
						</td>
					</tr>
				</table>
		  	</fieldset>
		</form>
	</center>
<script>
// $("#registerForm").validate();
</script>
</body>
</html>