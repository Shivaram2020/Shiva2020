<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CheckOut</title>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<link href="<c:url value="/resources/product/css/pay.css" />" rel="stylesheet">


<jsp:include page="header.jsp"/>

<style>


input[type=submit] {
   
    font-size: 20px;
    line-height: 20px;
    float: center;
    border: 0;
    display: block;
    margin: 0;
}
.pay {
    /* The image used */
    background-image:url('https://imgix.ttcdn.co/i/wallpaper/original/0/315672-64b1d0b08a194dbcb6fa14e9e612368b.png?size=900&crop=0,123,2836,741');

    /* Set a specific height */
    min-height: 500px; 

    /* Create the parallax scrolling effect */
    background-attachment: fixed;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover ;
}
.pay1 {
    /* The image used */
    background-image:url('https://c1.staticflickr.com/8/7283/16386858141_65a65879cd_b.jpg');

    /* Set a specific height */
    min-height: 500px; 

    /* Create the parallax scrolling effect */
    background-attachment: fixed;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover ;
}

</style>


</head>

<body style="background-color:#232323;">
<div class="pay">
<div class="accordian">
<c:forEach items="${cartlist}" var="cartlist">

  <ul>
    <li>

      <div class="image_title">
       <h2> <a href="CartPage"><span class="label label-info">${cartlist.productname}</span><span class="badge badge-warning">${cartlist.quantity}</span></a></h2>
       
            <a href="CartPage"><span class="label label-danger">&#8377 ${cartlist.price * cartlist.quantity}</span></a>
      </div>
      <a href="CartPage">
     <img src="<c:url value="/resources/images/${cartlist.prodid}.jpg"/>" height="600" width="500">
	</a>
	
	
    </li>

  </ul>
  </c:forEach>
</div>

<div class="pay1">
<div class="container">
	<div class="row">
		<div class="paymentCont">
						<div class="headingWrap">
								<h3 class="headingTop text-center">Select Your Payment Method</h3>	
								
						</div>
						<form action="<c:url value="/payment"/>" method="get">
						<div class="paymentWrap">
							<div class="btn-group paymentBtnGroup btn-group-justified" data-toggle="buttons">
					            <label class="btn paymentMethod active">
					            	<div class="method visa"></div>
					                <input type="radio" name="paymode" value="VISA-CARD"checked> 
					            </label>
					            <label class="btn paymentMethod">
					            	<div class="method master-card"></div>
					                <input type="radio" name="paymode" value="MASTER-CARD"> 
					            </label>
					            <label class="btn paymentMethod">
				            		<div class="method amex"></div>
					                <input type="radio" name="paymode" value="CREDIT-CARD">
					            </label>
					             <label class="btn paymentMethod">
				             		<div class="method vishwa"></div>
					                <input type="radio" name="paymode" value="EVOLPAY"> 
					            </label>
					            <label class="btn paymentMethod">
				            		<div class="method ez-cash"></div>
					                <input type="radio" name="paymode"  value="Ez-PAY"> 
					            </label>
					          <label class="btn paymentMethod">
				            		<div class="method cashondeliver"></div>
					                <input type="radio" name="paymode"  value="CASH ON DELVERY"> 
					            </label>
					        </div>  
					          <div>
					          
					     <h1>  <span class="label label-default">SHIPPING ADDRESS:</span><input type="text" name="shipping" required/></h1>
					
					
					<div class="container">
<center>
<h2><a href="CartPage" class="label label-default">GRAND TOTAL:<span></span><span></span>&#8377 ${grandtotal} </a></h2>
   
  <h1> <input type="submit" value="PAYMENT"name="submit" class="btn btn-success"/></h1>
   
    </center>        
 
</div>          
						          </div>
						</div>
						
						
						  </form>  
						
					</div>
	
	</div>
</div>
</div>

<div>
<jsp:include page="Footer.jsp"/>
</div>

  </div>
</body>

</html>