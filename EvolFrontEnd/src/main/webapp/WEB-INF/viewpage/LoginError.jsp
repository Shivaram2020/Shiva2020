<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html >

<head>
 
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  

<link href="<c:url value="/resources/theme1/css/signin.css" />" rel="stylesheet">
<title>signin</title>





</head>
<body>

<div id="fullscreen_bg" class="fullscreen_bg">


<div class="container">
 
	<form action="<c:url value="/perform_login"/>" method="post">
		<h1 class="form-signin-heading text-muted">Sign In</h1>
		    <small  style=color:red;>  *Username or Password is incorrect </small>
		<input type="text" class="form-control" placeholder="Username" required autofocus="" name="username">
		<input type="password" class="form-control" placeholder="Password" required name="password">
		<input type="submit"value="submit">
			
	</form>

</div>

</div>






</body>




</html>
