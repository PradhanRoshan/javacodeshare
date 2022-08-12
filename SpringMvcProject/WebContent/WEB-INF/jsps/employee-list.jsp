<%@page import="com.springmvc.main.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee List</h1>

 <%=request.getAttribute("list") %>
<% 
 List<Employee> list = (List<Employee>) request.getAttribute("list");

 
 %>
</body>
</html>