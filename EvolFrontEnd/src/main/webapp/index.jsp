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
         <a href="Game">  <img src="<c:url value="/resources/caurosel/gam.jpg"/>"  height="315" width="850" alt="game" style="width:100%;"></a>
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
	
	
	
	<div class="container">
	<div class="row">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<div class="container">
  <div class="row ">
 
<br>
<br>
    <div class="col-lg-12">
      <div>


        <div class="col-md-4">
          <div class="profile-card text-center">

            <img class="img-responsive" src="<c:url value="/resources/card/jb.png"/>" height="100" width="100" alt="music" style="width:100%;">
            <div class="profile-info">

              <img class="profile-pic"  src="<c:url value="/resources/card/jbp.jpg"/>" height="80" width="70" alt="music" style="width:100%;">
              <h2 class="hvr-underline-from-center">Music<span>Justin Biber</span></h2>
              <div>Evol launching exclusive music albums,updates of pop music world everyday , orginal albums are selling by Evol music world,you can get music album from around the world with exciting prices  </div>
                  
                  <a href="Login" >
         <i   class="glyphicon glyphicon-user"></i>
        </a>
                  
               
        
    <a href="signup">
         <i class="glyphicon glyphicon-plus"></i>
        </a>
        
              
                       </div>

          </div>
        </div>
        <div class="col-md-4">
          <div class="profile-card text-center">

            <img class="img-responsive" src="<c:url value="/resources/card/ga.png"/>" height="100" width="100"  style="width:100%;">
            <div class="profile-info">

              <img class="profile-pic"  src="<c:url value="/resources/card/ub.jpg"/>" height="80" width="70" style="width:100%;">
              <h2 class="hvr-underline-from-center">Game<span>Ubisoft</span></h2>
              <div>Wow new 2017 games are going to rock this year,Gamers have great year to brands going to launch awesome games soon available on Evol with amazing price checkin for top games around the world  </div>
                       
     
                  
                  <a href="Login" >
         <i  class="glyphicon glyphicon-user"></i>
        </a>
                  
               
        
    <a href="signup">
         <i class="glyphicon glyphicon-plus"></i>
        </a>
        
         
                       
                        </div>

          </div>
        </div>
        <div class="col-md-4">
          <div class="profile-card text-center">

            <img class="img-responsive"  src="<c:url value="/resources/card/ts.jpg"/>" height="100" width="100"  style="width:100%;">
                 <div class="profile-info">

              <img class="profile-pic"  src="<c:url value="/resources/card/tsp.jpg"/>" height="80" width="70"  style="width:100%;">
              <h2 class="hvr-underline-from-center">Photography<span>Ts tamil</span></h2>
              <div>Evol photography collection having photos frames poster from around the world ,collections based on top photographer around the world ,Evol make you new vision of photography, Wow leaded company's lenses,body,kit  available check in now </div>
                  
               
                  <a href="Login" >
         <i class="glyphicon glyphicon-user"></i>
        </a>
                  
               
        
    <a href="signup">
         <i  class="glyphicon glyphicon-plus"></i>
        </a>
        
    
                  </div>

          </div>
        </div>


      </div>
    </div>
  </div>
</div>
	</div>
</div>
	
	
	
	
	
	
	
</div>
	
	
		
	
	
</div>

<jsp:include page="Footer.jsp"/>

</body>
</html>