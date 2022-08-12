<%@page import="com.springmvc.main.model.Customer"%>
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
<h1>All Customers</h1>

<%
	List<Customer> list = (List<Customer>) request.getAttribute("customer_list");

	for(Customer c : list){
		out.println(c ); 
%>
<a href="<%=request.getContextPath() %>/delete-customer?id=<%=c.getId() %>">delete</a>
&nbsp;&nbsp;&nbsp;
<a href="<%=request.getContextPath() %>/edit-customer?id=<%=c.getId() %>">edit</a>
<br />
<%		
	}
%>


</body>
</html>