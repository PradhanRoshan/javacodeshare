<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>

<%=request.getAttribute("error_msg") %>
<form method="post" action="MainController">
	<input type="hidden" name="page" value="loginForm">
	<label>Username: </label>
	<input type="text" name="username" value="<%=request.getAttribute("username") %>">
	<br /> <br />
	<label>Password:</label>
	<input type="password" name="password">
	<br /> <br />
	<input type="submit" value="login"> 
</form>
</body>
</html>