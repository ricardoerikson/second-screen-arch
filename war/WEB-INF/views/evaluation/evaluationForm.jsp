<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Evaluation Form</title>
</head>
<body>
	<h1>Formulário de avaliação</h1>
	
	<p>Give a rating for the program: ${programTitle }</p>
	<form action="/evaluation/new" method="post">
		<input name="userId" type="hidden" value="${userId }" />
		<input name="movieId" type="hidden" value="${movieId }" />
		<input name="rating" type="radio" value="1"/>1<br>
		<input name="rating" type="radio" value="2"/>2<br>
		<input name="rating" type="radio" value="3"/>3<br>
		<input name="rating" type="radio" value="4"/>4<br>
		<input name="rating" type="radio" value="5"/>5<br>
		<br>
		<input type="submit" value="Submit evaluation" />
	</form>

</body>
</html>