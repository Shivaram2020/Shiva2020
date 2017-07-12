<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book</title>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<link href="<c:url value="/resources/navbar/css/navbar1.css" />" rel="stylesheet">


</head>
<body>

<c:if test="${sessionScope.loggedIn }">

<nav class="navbar  navbar-custom">
  <div class="container-fluid">
    <div class="navbar-header">
    
    
      <a class="navbar-brand active" href="index.jsp"><img class="circle" src="<c:url value="/resources/icon/photo.gif"/>"height="100" width="100"></a>
    
    </div>
     
    <a  href="UserHome1" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-home"></span>Home
 </a>
     <a  href="Book" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-book"></span>Book
 </a>
      <a  href="Music" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-headphones"></span>Music
 </a>
      <a href="Photography" class="btn btn-info btn-lg" ><span class="glyphicon glyphicon-camera"></span>Photography
 </a>
      <a href="Painting" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-picture"></span>Painting
 </a>
      <a href="Game" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-sunglasses"></span>Game
 </a>
 
  
   <ul class="nav navbar-nav nav navbar-right dropdown">
   <a href="CartPage" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-shopping-cart"></span>CartPage</a>
<button onclick="myFunction()" class="dropbtn btn btn-success btn-lg"><span class="glyphicon glyphicon-user"></span> ${sessionScope.username}</button>
  <div id="myDropdown" class="dropdown-content">
  
   <a href="Logout" class="btn btn-danger btn-lg""><span class="glyphicon glyphicon-log-out"></span>Logout</a>
  </div>

  </ul>
</nav>
</c:if>




<c:if test="${!sessionScope.loggedIn }">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
   
      <a class="navbar-brand active" href="index.jsp"><img class="circle" src="<c:url value="/resources/icon/photo.gif"/>"height="100" width="100"></a>
    
    </div>
     
    <a  href="UserHome1" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-home"></span>Home
 </a>
     <a  href="Book" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-book"></span>Book
 </a>
      <a  href="Music" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-headphones"></span>Music
 </a>
      <a href="Photography" class="btn btn-info btn-lg" ><span class="glyphicon glyphicon-camera"></span>Photography
 </a>
      <a href="Painting" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-picture"></span>Painting
 </a>
      <a href="Game" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-sunglasses"></span>Game
 </a>
      
    <ul class="nav navbar-nav nav navbar-right">
    <li> <a href="Login" >
          <span class="glyphicon glyphicon-user"></span> login
        </a></li>
        
      <li><a href="signup">
          <span class="glyphicon glyphicon-plus"></span> signup 
        </a></li>
   
       </ul>
  
  </div>
</nav>
</c:if>


<div class="row">
  <div class="col-sm-6 col-md-4">
  
  <c:forEach items="${prodlist}" var="product">
  <c:if test="${3==product.catid }">
  
  <h1>${product.prodid}</h1>
  
  
    <div class="thumbnail">
      <a href="<c:url value="/ProductDescription/${product.prodid}" />" class=" thumbnail">
<img src="<c:url value="/resources/images/${product.prodid}.jpg"/>"></a>
      
      <div class="caption">
        <h3>${product.prodname}</h3>
        <h4>${product.price}</h4>
        <p><h4>${product.proddesc}</h4></p>
        <p><a href="<c:url value="/ProductDescription/${product.prodid}" />" class="btn btn-primary" role="button">Add to cart</a></p>
              </div>
   
    </div>
  </c:if>
  </c:forEach>
 
  </div>
</div>
 
<script>

/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}





</script>

</body>
</html>

