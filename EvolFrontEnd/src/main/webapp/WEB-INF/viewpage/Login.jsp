<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html >

<head>
 
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  

<link href="<c:url value="/resources/theme1/css/signin.css" />" rel="stylesheet">
<title>signin</title>  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto+Slab'>

      <style>
     {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html, body {
  height: 100%;
  background-color: #F15A5C;
  font-family: "Roboto Slab", serif;
  color: white;
}

.preload * {
  transition: none !important;
}

label {
  display: block;
  font-weight: bold;
  font-size: small;
  text-transform: uppercase;
  font-size: 0.7em;
  margin-bottom: 0.35em;
}

input[type="text"], input[type="password"] {
  width: 100%;
  border: none;
  padding: 0.5em;
  border-radius: 2px;
  margin-bottom: 0.5em;
  color: #333;
}
input[type="text"]:focus, input[type="password"]:focus {
  outline: none;
  box-shadow: inset -1px -1px 3px rgba(0, 0, 0, 0.3);
}

button {
  padding-left: 1.5em;
  padding-right: 1.5em;
  padding-bottom: 0.5em;
  padding-top: 0.5em;
  border: none;
  border-radius: 2px;
  background-color: #7E5AF1;
  text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.25);
  color: white;
  box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.45);
}

small {
  font-size: 1em;
}

.login--login-submit {
  float: right;
}

.login--container {
  width: 600px;
  background-color: #F15A5C;
  margin: 0 auto;
  position: relative;
  top: 25%;
}

.login--toggle-container {
  position: absolute;
  background-color: #F15A5C;
  right: 0;
  line-height: 2.5em;
  width: 50%;
  height: 120px;
  text-align: right;
  cursor: pointer;
  transform: perspective(1000px) translateZ(1px);
  transform-origin: 0% 0%;
  transition: all 1s cubic-bezier(0.06, 0.63, 0, 1);
  backface-visibility: hidden;
}
.login--toggle-container .js-toggle-login {
  font-size: 4em;
  text-decoration: underline;
}
.login--active .login--toggle-container {
  transform: perspective(1000px) rotateY(180deg);
  background-color: #bc1012;
}

.login--username-container, .login--password-container {
  float: left;
  background-color: #F15A5C;
  width: 50%;
  height: 120px;
  padding: 0.5em;
}

.login--username-container {
  transform-origin: 100% 0%;
  transform: perspective(1000px) rotateY(180deg);
  transition: all 1s cubic-bezier(0.06, 0.63, 0, 1);
  background-color: #bc1012;
  backface-visibility: hidden;
}
.login--active .login--username-container {
  transform: perspective(1000px) rotateY(0deg);
  background-color: #F15A5C;
}

footer {
  position: absolute;
  bottom: 12px;
  left: 20px;
}

    </style>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>

<body>

<form action="<c:url value="/perform_login"/>" method="post">
  <div class='preload login--container'>
  <div class='login--form'>
    <div class='login--username-container'>
      <label>Username</label>
      <input autofocus placeholder='Username' name="username" type='text' required>
    </div>
    <div class='login--password-container'>
      <label>Password</label>
      <input placeholder='Password' name="password" type='password' requried >
      <button class='js-toggle-login login--login-submit'>Login</button>
    </div>
  </div>
  <div class='login--toggle-container'>
    
    <div class='js-toggle-login'>Evol</div>
    <small>Login</small>
  </div>
</div>
</form>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="<c:url value="/resources/theme1/js/index.js"/>"></script>

</body>
</html>



