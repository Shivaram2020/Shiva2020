

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product page</title>
<jsp:include page="header.jsp"/>
</head>
<body>

<div id=container>

<div class=row>
<div class="col-sm-6 col-md-3">

<c:forEach items="${prodlist}" var="product">
<h1>${product.prodid}</h1>

<a href="<c:url value="/ProductDescription/${product.prodid}" />" class=" thumbnail">
<img src="<c:url value="/resources/images/${product.prodid}.jpg"/>"></a>

<div class="caption">

<h4>${product.proddesc}</h4>
<h4>${product.price}</h4>
</div>

</c:forEach>


</div>




</div>



</div>




 
</body>
</html>

