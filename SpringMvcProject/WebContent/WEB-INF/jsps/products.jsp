<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Products</h1>
<%
String[] str = (String[])request.getAttribute("namesArr"); 
for(String s : str) {
	out.println(s);
} 
	 %>

</body>
</html>