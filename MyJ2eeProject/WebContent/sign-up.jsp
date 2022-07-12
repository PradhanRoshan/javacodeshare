<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Sign-Up</h1>
 
<form method="post" action="MainController">
	<input type="hidden" name="page" value="signUpForm">
	<label>Name: </label>
	<input type="text" name="name" required>
	<br /> <br />
	<label>Username: </label>
	<input type="text" name="username" required>
	<br /> <br />
	<label>Password:</label>
	<input type="password" name="password" required>
	<br /> <br />
	<input type="submit" value="SignUp"> 
</form>
</body>
</html>