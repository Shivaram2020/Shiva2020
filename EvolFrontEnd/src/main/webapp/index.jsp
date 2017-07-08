<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evol</title>
<link href="<c:url value="/resources/navbar/css/navbar.css" />" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<jsp:include page="header.jsp"/>
</head>
<body>
 
<div class="parallax">
</div>
<div class="parallax3">
<div class="container-fluid">
  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
       
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
       <a href="Music"> <img src="<c:url value="/resources/caurosel/album.jpg"/>" height="315" width="850" alt="music" style="width:100%;"></a>
      <div class="carousel-caption">
        <h3>Evol Music</h3>
        <p>New PoP albums Coming Soon </p>
      </div>
     
      </div>

      <div class="item">
         <a href="Game">  <img src="<c:url value="/resources/caurosel/gam.jpg"/>"  height="315" width="850" alt="book" style="width:100%;"></a>
      <div class="carousel-caption">
        <h3>Evol Game</h3>
        <p>50% Offer! for New Arrivals </p>
      </div>
      
      
      </div>
    
      <div class="item">
       <a href="Photography">  <img src="<c:url value="/resources/caurosel/cam.jpg"/>" height="315" width="850" alt="photo" style="width:100%;"></a>
      <div class="carousel-caption">
        <h3>Evol Photography</h3>
        <p>Good Deal for Lenses Exciting Offer!</p>
      </div>
      
      </div>
    </div>
 
    

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>



</div>

<div class="parallax1">
		
		
		<center>
		<h2>Evol</h2>
		
	</center>
	
</div>

</div>


</body>
</html>