<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="<c:url value="/resources/theme1/css/signup.css" />"  rel="stylesheet">
 <script src="<c:url value="/resources/theme1/js/main.js" />"></script>	

<title>Signup</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body class="cl">

<div class="left left1 cl">
 

<div class="selection">

<div class="container">
	<div class="row cl">
        <div class="col-md-6">
        
        
       
        
            <form action="AddUser" method="post">
            
             
           <fieldset class="cl"><legend class="text-center "style=color:red;>Valid information is required to register. <span class="req"><small> required *</small></span></legend> 
  
  
  <div class="form-group">
                <label for="username"   style=color:white;><span class="req">* </span> User name:  <small>This will be your login user name</small> </label> 
                    <input class="form-control" type="text" name="username" id = "txt" onkeyup = "Validate(this)" placeholder="minimum 6 letters" required />  
                        <div id="errLast"></div>
            </div>

           


            <div class="form-group">
                <label for="email"   style=color:white;><span class="req">* </span> Email Address: </label> 
                    <input class="form-control" required type="text" name="email" id = "email"  onchange="email_validate(this.value);" />   
                        <div class="status" id="status"></div>
            </div>

          
 <div class="form-group">
            <label for="phonenumber"   style=color:white;><span class="req">* </span> Phone Number: </label>
                    <input required type="text" name="phonenumber" id="phone" class="form-control phone" maxlength="28" onkeyup="validatephone(this);" placeholder="not used for marketing"/> 
            </div>

            <div class="form-group">
                <label for="password"   style=color:white;><span class="req">* </span> Password: </label>
                    <input required name="password" type="password" class="form-control inputpass" minlength="4" maxlength="16"  id="pass1" /> </p>

                <label for="password"   style=color:white;><span class="req">* </span> Password Confirm: </label>
                    <input required name="pass" type="password" class="form-control inputpass" minlength="4" maxlength="16" placeholder="Enter again to validate"  id="pass2" onkeyup="checkPass(); return false;" />
                        <span id="confirmMessage" class="confirmMessage"></span>
            </div>
               
       
           
           
            <div class="form-group">
                <label for="address"   style=color:white;><span class="req">* </span> address:  <small>address</small> </label> 
                    <input class="form-control" type="text" name="address" id = "txt"  placeholder="address" required />  
                       
            </div>
           
           
           
            <div class="form-group">
                <input class="btn btn-success" type="submit" name="submit_reg" value="Register">
            </div>
                     


 
 

            </fieldset>
         </form><!-- ends register form --> 

	</div>
    </div>      
    </div>
    </div>
   
    
    
     </div>
      <div class="imp">
      
      <img src="<c:url value="/resources/images/imp.gif"/> " height="700" width="800" >
      
      </div>
</body>
</html>