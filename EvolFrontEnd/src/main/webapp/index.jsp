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

              <img class="profile-pic"  src="<c:url value="/resources/images/Icon.gif"/>" height="50" width="50" alt="music" style="width:100%;">
              <h2 class="hvr-underline-from-center">Rod<span>Digital / Design Consultant</span></h2>
              <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</div>
                       </div>

          </div>
        </div>
        <div class="col-md-4">
          <div class="profile-card text-center">

            <img class="img-responsive" src="<c:url value="/resources/card/ga.png"/>" height="100" width="100" alt="music" style="width:100%;">
            <div class="profile-info">

              <img class="profile-pic"  src="<c:url value="/resources/images/Icon.gif"/>" height="50" width="50" alt="music" style="width:100%;">
              <h2 class="hvr-underline-from-center">Adam<span>Developer</span></h2>
              <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</div>
                        </div>

          </div>
        </div>
        <div class="col-md-4">
          <div class="profile-card text-center">

            <img class="img-responsive"  src="<c:url value="/resources/card/paint.jpg"/>" height="100" width="100" alt="music" style="width:100%;">
                 <div class="profile-info">

              <img class="profile-pic"  src="<c:url value="/resources/images/Icon.gif"/>" height="50" width="50" alt="music" style="width:100%;">
              <h2 class="hvr-underline-from-center">Mike Young<span>Web Designer</span></h2>
              <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</div>
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

<footer>
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-sm-6 footerleft ">
        <div class="logofooter"> Logo</div>
        <p>Evol is set for Make your hobby fullfilled ,products are orginal made by respective company,Happy Hobby with Evol</p>
        <p><i class="fa fa-map-pin"></i> 210, Aggarwal Tower, Rohini sec 9, Chennai -110085, INDIA</p>
        <p><i class="fa fa-phone"></i> Phone (India) : +91 9999 878 398</p>
        <p><i class="fa fa-envelope"></i> E-mail : info@Evol.com</p>
        
      </div>
      <div class="col-md-2 col-sm-6 paddingtop-bottom">
        <h6 class="heading7">GENERAL LINKS</h6>
        <ul class="footer-ul">
          <li><a href="#"> Career</a></li>
          <li><a href="#"> Privacy Policy</a></li>
          <li><a href="#"> Terms & Conditions</a></li>
          <li><a href="#"> Client Gateway</a></li>
          <li><a href="#"> Ranking</a></li>
          <li><a href="#"> Case Studies</a></li>
          <li><a href="#"> Frequently Ask Questions</a></li>
        </ul>
      </div>
      <div class="col-md-3 col-sm-6 paddingtop-bottom">
        <h6 class="heading7">LATEST POST</h6>
        <div class="post">
          <p>facebook Ea game fifa 18 arival:Special Offer<span>july 3,2017</span></p>
          <p>facebook new Power Of Positive Thinking Book: motivational book <span>june 7,2017</span></p>
          <p>facebook one direction new Album:on August<span>may 3,2017</span></p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 paddingtop-bottom">
        <div class="fb-page" data-href="https://www.facebook.com/facebook" data-tabs="timeline" data-height="300" data-small-header="false" style="margin-bottom:15px;" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true">
          <div class="fb-xfbml-parse-ignore">
            <blockquote cite="https://www.facebook.com/facebook"><a href="https://www.facebook.com/facebook">Facebook</a></blockquote>
          </div>
        </div>
      </div>
    </div>
  </div>
</footer>
<!--footer start from here-->

<div class="copyright">
  <div class="container">
    <div class="col-md-6">
      <p>© 2016- All Rights reserved</p>
    </div>
    <div class="col-md-6">
      <ul class="bottom_ul">
        <li><a href="#">SwS-2020</a></li>
        <li><a href="#">About us</a></li>
        <li><a href="#">Blog</a></li>
        <li><a href="#">Faq's</a></li>
        <li><a href="#">Contact us</a></li>
        <li><a href="#">Site Map</a></li>
      </ul>
    </div>
  </div>
</div>




</div>


</body>
</html>