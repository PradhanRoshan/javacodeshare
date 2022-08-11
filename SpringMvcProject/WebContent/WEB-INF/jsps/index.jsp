<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello Spring!!! finally... LOGIN</h1>
<p>Welcome <%=request.getAttribute("username") %></p>
<a href="<%=request.getContextPath() %>/products">products</a> <br />
<a href="<%=request.getContextPath() %>/vendors">vendors</a><br />
<a href="<%=request.getContextPath() %>/add-customer">Add Customer</a> <br />
<a href="<%=request.getContextPath() %>/view-customers">View Customers</a>
</body>
</html>