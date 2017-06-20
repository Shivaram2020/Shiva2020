<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style type="text/css">


.fullscreen_bg {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-size: cover;
    background-position: 50% 50%;
    background-image: url('https://www.xhostel.com/wp-content/uploads/2017/03/best-shopping-in-Bucharest.jpg');
    background-repeat:repeat;
  }
::selection {
        background-color: #b5e2e7;
    }

    ::-moz-selection {
        background-color: #8ac7d8;
    }

    body {
        background: #3CC;
    }

    .container {
        display: -webkit-flex;
        display: flex;
        height: 100%;
    }

    #logbox {

        padding: 10px;
        margin: 50px auto;
        width: 340px;
        background-color: #fff;
        -webkit-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
        -moz-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
    }

    h1 {
        text-align: center;
        font-size: 175%;
        color: #757575;
        font-weight: 300;
    }

    h1, input {
        font-family: "Open Sans", Helvetica, sans-serif;
    }

    .input {
        width: 75%;
        height: 50px;
        display: block;
        margin: 0 auto 15px;
        padding: 0 15px;
        border: none;
        border-bottom: 2px solid #ebebeb;
    }
    .input:focus {
        outline: none;
        border-bottom-color: #3CC !important;
    }
    .input:hover {
        border-bottom-color: #dcdcdc;
    }
    .input:invalid {
        box-shadow: none;
    }

    .pass:-webkit-autofill {
        -webkit-box-shadow: 0 0 0 1000px white inset;
    }

    .inputButton {
        position: relative;
        width: 85%;
        height: 50px;
        display: block;
        margin: 30px auto 30px;
        color: white;
        background-color: #3CC;
        border: none;
        -webkit-box-shadow: 0 5px 0 #2CADAD;
        -moz-box-shadow: 0 5px 0 #2CADAD;
        box-shadow: 0 5px 0 #2CADAD;
    }
    .inputButton:hover {
        top: 2px;
        -webkit-box-shadow: 0 3px 0 #2CADAD;
        -moz-box-shadow: 0 3px 0 #2CADAD;
        box-shadow: 0 3px 0 #2CADAD;
    }
    .inputButton:active {
        top: 5px;
        box-shadow: none;
    }
    .inputButton:focus {
        outline: none;
    }

    .navbar-brand{
	        font-size: xx-large;
    font-weight: bold;
    font-family: cursive;
	
	}
	

</style>
</head>
<body>
<div id="fullscreen_bg" class="fullscreen_bg"/>
<div class="container" >
    <div class="col-md-6" >
        <div id="logbox"  >
            <form id="signup" method="post" action="/signup" >
            <div>              
            <h1>Create an Account</h1>
		 <input class="form-control" required type="text" name="email" id = "email" placeholder="Email" onchange="email_validate(this.value);"/>
           </div>
  
                <div>
                
                    <input required name="password" type="password" placeholder="Password" class="form-control inputpass" minlength="4" maxlength="16"  id="pass1" /> </p>
</div>
                <div>
                
                    <input required name="password" type="password" placeholder="Confirm Password" class="form-control inputpass" minlength="4" maxlength="16" placeholder="Enter again to validate"  id="pass2" onkeyup="checkPass(); return false;" />
                       
    </div>
                <input type="submit" value="Sign me up!" class="inputButton"/>
</form>
        </div>
        </div>
        </div>
        
            


<script>

function checkPass()
{
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('pass1');
    var pass2 = document.getElementById('pass2');
    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field 
    //and the confirmation field
    if(pass1.value == pass2.value){
        //The passwords match. 
        //Set the color to the good color and inform
        //the user that they have entered the correct password 
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match"
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
} 
function validatephone(phone) 
{
    var maintainplus = '';
    var numval = phone.value
    if ( numval.charAt(0)=='+' )
    {
        var maintainplus = '';
    }
    curphonevar = numval.replace(/[\\A-Za-z!"£$%^&\,*+_={};:'@#~,.Š\/<>?|`¬\]\[]/g,'');
    phone.value = maintainplus + curphonevar;
    var maintainplus = '';
    phone.focus;
}
// validates text only
function Validate(txt) {
    txt.value = txt.value.replace(/[^a-zA-Z-'\n\r.]+/g, '');
}
// validate email
function email_validate(email)
{
var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;

    if(regMail.test(email) == false)
    {
    document.getElementById("status").innerHTML    = "<span class='warning'>Email address is not valid yet.</span>";
    }
    else
    {
    document.getElementById("status").innerHTML	= "<span class='valid'>Thanks, you have entered a valid Email address!</span>";	
    }
}
// validate date of birth
function dob_validate(dob)
{
var regDOB = /^(\d{1,2})[-\/](\d{1,2})[-\/](\d{4})$/;

    if(regDOB.test(dob) == false)
    {
    document.getElementById("statusDOB").innerHTML	= "<span class='warning'>DOB is only used to verify your age.</span>";
    }
    else
    {
    document.getElementById("statusDOB").innerHTML	= "<span class='valid'>Thanks, you have entered a valid DOB!</span>";	
    }
}
// validate address
function add_validate(address)
{
var regAdd = /^(?=.*\d)[a-zA-Z\s\d\/]+$/;
  
    if(regAdd.test(address) == false)
    {
    document.getElementById("statusAdd").innerHTML	= "<span class='warning'>Address is not valid yet.</span>";
    }
    else
    {
    document.getElementById("statusAdd").innerHTML	= "<span class='valid'>Thanks, Address looks valid!</span>";	
    }
}

</script>
      
      
</body>
</html>