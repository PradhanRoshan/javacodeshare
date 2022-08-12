<%@page import="com.springmvc.main.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Customer</h1>
<% 
	Customer customer = (Customer) request.getAttribute("customer"); 
%>
<%=request.getAttribute("msg") %>
<form method="get" action="<%=request.getContextPath() %>/process-edit-customer">
<input type="hidden" name="id" value="<%=customer.getId() %>">
<label>Enter Name: </label>
<input type="text" name="cname" value="<%=customer.getName() %>"> <br /> <br />
<label>Enter City: </label>
<input type="text" name="ccity" value="<%=customer.getCity() %>"> <br /> <br />
<label>Enter Age: </label>
<input type="text" name="cage" value="<%=customer.getAge() %>" > <br /> <br />
<input type="submit" value="Edit Customer">

</form>
<hr>
<a href="<%=request.getContextPath() %>/view-customers">View Customers</a>

</body>
</html>