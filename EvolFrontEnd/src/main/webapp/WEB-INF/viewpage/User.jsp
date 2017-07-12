

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

<div class="parallax">

</div>



<c:if test="${sessionScope.loggedIn }">



<div class="parallax1">

<div class="container">

<div class="row">
  <c:forEach items="${prodlist}" var="product">
  
  <div class="col-sm-6 col-md-3">
  
  
  
  
    <div class="thumbnail">
      <a href="<c:url value="/ProductDescription/${product.prodid}" />" class=" thumbnail">
<img src="<c:url value="/resources/images/${product.prodid}.jpg"/>" height="300" width="400" ></a>
      
      <div class="caption">
        <h3>${product.prodname}</h3>
        <h4>&#8377 ${product.price}</h4>
        <p><h4>${product.proddesc}</h4></p>
        <p><a href="<c:url value="/ProductDescription/${product.prodid}" />" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a></p>
              </div>
   
    </div>
    </div>
  
  
  
  
  </c:forEach>
 </div>
  </div>

  
</div>
 
  
  
  


</c:if>
<c:if test="${!sessionScope.loggedIn }">




<div class="parallax1">

<div class="container">

<div class="row">
  <c:forEach items="${prodlist}" var="product">
  
  <div class="col-sm-6 col-md-3">
  
  
  
  
    <div class="thumbnail">
      <a href="<c:url value="/ProductDescription/${product.prodid}" />" class=" thumbnail">
<img src="<c:url value="/resources/images/${product.prodid}.jpg"/>" height="300" width="400" ></a>
      
      <div class="caption">
        <h3>${product.prodname}</h3>
        <h4>&#8377 ${product.price}</h4>
        <p><h4>${product.proddesc}</h4></p>
        <p><a href="<c:url value="/Login" />" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a></p>
              </div>
   
    </div>
    </div>
  
  
  
  
  </c:forEach>
 </div>
  </div>

  
</div>
 
  
 


</c:if>



 
  
<jsp:include page="Footer.jsp"/>




 
</body>
</html>

