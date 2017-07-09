<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>header</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/navbar/css/navbar.css" />" rel="stylesheet">


</head>
 <div class="parallax">
 <div class="container-fluid">

<nav class="navbar navbar-custom  ">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp"><img src="<c:url value="/resources/icon/icon.gif"/>"height="100" width="100"></a>
    </div>
    
  
        
        
       
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
  </div>
  </div>

</body>
</html>