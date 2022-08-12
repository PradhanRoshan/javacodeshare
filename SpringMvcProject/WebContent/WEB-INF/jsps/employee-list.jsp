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

 
<% 
 List<Object> list =  (List<Object>) request.getAttribute("list");

	for(Object o : list){
		out.println(o + "<br />");
	}
 
 %>
</body>
</html>