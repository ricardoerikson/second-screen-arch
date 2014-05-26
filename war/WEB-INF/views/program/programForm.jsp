<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Program Form</title>
</head>
<body>

	<h1>Create a new Program</h1>
	<form action="/program/new" method="post">
		<label for="title">Program title</label> <input type="text"
			name="title" /> <br> <label for="videoCode">YouTube
			Code</label> <input type="text" name="videoCode" /> <br> <input
			type="submit" value="Create Program" />

	</form>

</body>
</html>