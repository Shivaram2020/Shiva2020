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
<body>
<div id="fullscreen_bg" class="fullscreen_bg"/>
<div class="container" >
    <div class="col-md-6" >
        <div id="logbox"  >
            <form id="signup" method="post" action="AddUser" >
            <div>              
            <h1>Create an Account</h1>
		 <input class="form-control" required type="text" name="username" id = "username" placeholder="username";"/></p>
		           </div>
   
<div><label for="address">Address:</label>
<input type="text" name="address" size="50" /> </div>
<div><label for="country">Country:</label>  
<select name="country">  
<option selected="" value="Default">(Please select a country)</option>  
<option value="AF">Australia</option>  
<option value="AL">Canada</option>  
<option value="DZ">India</option>  
<option value="AS">Russia</option>  
<option value="AD">USA</option>  
</select></li>  </div>
<div><label for="zip">ZIP Code:</label>
<input type="text" name="zip" /></div> 
<div><label for="email">Email:</label>
<input type="text" name="email" size="50" /></div>  
<div><label id="gender">Sex:</label>
<input type="radio" name="msex" value="Male" /><span>Male</span>
<input type="radio" name="fsex" value="Female" /><span>Female</span></div>
<div><label>Language:</label></li>  
<input type="checkbox" name="en" value="en" checked /><span>English</span>  
<input type="checkbox" name="nonen" value="noen" /><span>Non English</span> </div>
<div><label for="desc">About:</label></li>  
<textarea name="desc" id="desc"></textarea></li> </div> 

                <div>
                
                    <input required name="password" type="password" placeholder="Password" class="form-control inputpass" minlength="4" maxlength="16"  id="pass1" /> </p>
</div>
                <div>
                
                    <input required name="pass" type="password" placeholder="Confirm Password" class="form-control inputpass" minlength="4" maxlength="16" placeholder="Enter again to validate"  id="pass2" onkeyup="checkPass(); return false;" />
                       
    </div>
                <input type="submit" value="Sign me up!" class="inputButton"/>
</form>
        </div>
        </div>
        </div>
        
            


<script>


</script>
      
      
</body>
</html>