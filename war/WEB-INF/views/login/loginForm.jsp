<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
	<h1>Login form:</h1>
	<form action="/login" method="POST">
		<label for="username">username:</label> <input type="text"
			name="username" /> <br> <label for="password">password</label>
		<input type="password" name="password" /><br> <input
			type="submit" value="Login" />
	</form>

</body>
</html>