
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


function formValidation()  
{  
var uid = document.registration.userid;  
var passid = document.registration.passid;  
var uname = document.registration.username;  
var uadd = document.registration.address;  
var ucountry = document.registration.country;  
var uzip = document.registration.zip;  
var uemail = document.registration.email;  
var umsex = document.registration.msex;  
var ufsex = document.registration.fsex; if(userid_validation(uid,5,12))  
{  
if(passid_validation(passid,7,12))  
{  
if(allLetter(uname))  
{  
if(alphanumeric(uadd))  
{   
if(countryselect(ucountry))  
{  
if(allnumeric(uzip))  
{  
if(ValidateEmail(uemail))  
{  
if(validsex(umsex,ufsex))  
{  
}  
}   
}  
}   
}  
}  
}  
}  
return false;  
}  