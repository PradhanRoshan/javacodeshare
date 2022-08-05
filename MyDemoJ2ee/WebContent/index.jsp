<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello <%=request.getAttribute("username") %></h1>
<br> 
<a href="MainServlet?page=products">products</a>

</body>
</html>
<%--  
	1. Scriptlet  
	2. Expression  
 --%>