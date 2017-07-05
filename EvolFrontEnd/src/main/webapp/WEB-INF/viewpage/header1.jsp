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


</head>
<body>


<c:if test="${sessionScope.loggedIn }">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand active" href="index.jsp">Evol</a>
    </div>
    <ul class="nav navbar-nav">
    
      <li><a href="Product">product</a></li>
      <li><a href="Supplier">supplier</a></li>
     <li><a href="Category">category</a></li>
     
    </ul>
     <ul class="nav navbar-nav nav navbar-right">
     
     <a href="#">${sessionScope.username}</a>
     <a href="index.jsp"> logout</a>
     </ul>
  </div>
</nav>
</c:if>

<c:if test="${!sessionScope.loggedIn }">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Evol</a>
    </div>
    <ul class="nav navbar-nav nav navbar-right">
     <li><a href="AdminHome">Adminhome</a></li>
      <li><a href="Product">product</a></li>
      <li><a href="Supplier">supplier</a></li>
     <li><a href="Category">category</a></li>
     
    </ul>
  </div>
</nav>
</c:if>

</body>
</html>