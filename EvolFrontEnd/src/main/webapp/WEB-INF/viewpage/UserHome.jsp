

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product page</title>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 
   <style>
   <style>
img {
    border: 1px solid #ddd;
    border-radius: 4px;
    padding: 5px;
    width: 1500px;
}

img:hover {
    box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);
}


.menu {
    width: 25%;
    float: left;
    padding: 15px;
    border: 1px solid red;
}

</style>
   
   
<jsp:include page="header.jsp"/>
<link href="<c:url value="/resources/navbar/css/navbar1.css" />" rel="stylesheet">
</head>
<body>

<div class="parallax">


<div class="container">
  <div class="row">

<div id="menuBall2" class="menuBall">
	<a href="CartPage" class="ball redball">
    <div class="menuText">
       <span class="glyphicon glyphicon-shopping-cart"></span>&#8377 ${grandtotal}
       
    </div>
  </a>
</div>
</div>
</div>


</div>
<div class="parallax1">

<div class="container">

<div class="row">
   <c:forEach items="${prodlist}" var="product">
  
  <div class="col-sm-6 col-md-3">
  
  
 
  
    <div class="thumbnail con">
      <a href="<c:url value="/ProductDescription/${product.prodid}" />" class=" thumbnail">
<img src="<c:url value="/resources/images/${product.prodid}.jpg"/>" height="300" width="400" ></a>
      
      <div class="caption">
        <h3>${product.prodname}</h3>
        <h4><s>&#8377 ${product.price+500}</s>&#8377 ${product.price}</h4>
        <p><h4>${product.proddesc}</h4></p>
        <p><a href="<c:url value="/ProductDescription/${product.prodid}" />" class="btn btn-success fix  btn-circle btn-lg" role="button"><i class="glyphicon glyphicon-shopping-cart"></i></a></p>
              </div>
   
    </div>
    
    </div>
  
 
   </c:forEach>
  
 
  
 </div>
  </div>

  
</div>

<jsp:include page="Footer.jsp"/>





 
</body>
</html>

