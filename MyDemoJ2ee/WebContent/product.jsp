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

<form method="post" action="MainServlet">
	<input type="hidden" name="page" value="login"/>
	Username: <input type="text" name="username" />
	<br />
	<input type="submit" value="login">
</form>
</body>
</html>