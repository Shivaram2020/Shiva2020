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
    
    
      <a class="navbar-brand active" href="index.jsp"><img class="circle" src="<c:url value="/resources/icon/game.gif"/>"height="100" width="100"></a>
    
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
       <a class="navbar-brand active" href="index.jsp"><img class="circle" src="<c:url value="/resources/icon/game.gif"/>"height="100" width="100"></a>
    
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
 
 
  </div>
</nav>
</c:if>

<c:forEach items="${prodlist}" var="prodlist"  >
<c:if test="${5==prodlist.catid }">



<a href="ProductDescription/${prodlist.prodid}" class=" thumbnail">
<img src="<c:url value="/resources/images/${prodlist.prodid}.jpg"/>" height="100" width="300"></a>

</c:if>
</c:forEach>

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

