<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evol</title>
<jsp:include page="header.jsp"/>
</head>
<body>

	<center>
		<h2>Evol</h2>
		<a href="Category">Add category</a>
		<a href="Product">Add Product</a>
		<a href="Supplier">Add Supplier</a>
	   <a href="ProductPage">open</a>
	     <a href="Login">login</a>
	</center>
	
	<img src="<c:url value="/resources/images/wall.jpg"/>" alt="New York">
 
	
</body>
</html>