

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product page</title>
<jsp:include page="header.jsp"/>
 <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
 <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<c:forEach items="${prodlist}" var="product">
<h1>${product.prodid}</h1>
<img src="<c:url value="/resources/images/${product.prodid}.jpg"/>">
</c:forEach>

 
</body>
</html>

