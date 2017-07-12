<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<jsp:include page="header.jsp"/>

<style>

.panel-footer
{

 background-color: #FA8072;
}
.img {
    background-image: url('https://i.ytimg.com/vi/6s1_FpfQEZc/maxresdefault.jpg');
}


.cart {
    /* The image used */
    background-image:url('http://toeicacademy.com/wp-content/uploads/2016/08/tu-vung-chu-de-shopping.jpg');

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
<body>

<div class="cart">

<c:if test="${sessionScope.loggedIn }">


<div class="container" >
	<div class="row ">
		<div class="col-xs-8">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<div class="row">
							<div class="col-xs-6">
								<h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
							</div>
							<div class="col-xs-6">
								<a href="<c:url value="UserHome1"/>"><button type="button" class="btn btn-primary btn-sm btn-block">
									<span class="glyphicon glyphicon-share-alt"></span> Continue shopping
								</button></a>
							</div>
						</div>
					</div>
				</div>
				<c:forEach items="${cartlist}" var="cartlist">
				<div class="panel-body img">
					<div class="row">
						<div class="col-xs-2"><img class="img-responsive"  src="<c:url value="/resources/images/${cartlist.prodid}.jpg"/>">
						</div>
						<div class="col-xs-4">
							<h4 class="product-name"><strong>
${cartlist.productname}
							</strong></h4>
						</div>
						<div class="col-xs-6">
							<div class="col-xs-6 text-right">
								<h3><strong>
${cartlist.price}
								 <span class="text-muted">x</span></strong></h3>
							</div>
							<div class="col-xs-4">
							
							<form action="<c:url value="/update/${cartlist.cartitemid}/${prodinfo.prodid}"/>" method="get" >


<input type="text" class="form-control input-sm btn btn-info btn-block" value="${ cartlist.quantity }" onkeyup="validatequantity(this);" id="quantity" name="quantity"/>





<input type="submit" class="btn btn-success btn-block" value="Add">
							
		</form>						
							</div>
							<div class="col-xs-2">
							<a href="<c:url value="/delete/${cartlist.cartitemid}"/>">

								<button type="button" class="btn btn-link btn-xs">
									<span class="glyphicon glyphicon-remove"> </span>
								</button></a>
							</div>
						</div>
					</div>
					<hr>
										<hr>
					
				<div class="panel-footer" >
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right">Total <strong>&#8377  ${cartlist.price * cartlist.quantity}
							</strong></h4>
						</div>
						</div>
						</div>
						</div>
					
						</c:forEach>
						
							<div class="panel-footer">
							<div class="row text-center" >
						<div class="col-xs-3 ">
							<a href="CheckOut"><button type="button" class="btn btn-success btn-block">
								Checkout
							</button></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</c:if>



</div>

  
<jsp:include page="Footer.jsp"/>

<script>

function validatequantity(quantity) 
{
    var maintainplus = '';
    var numval = quantity.value
    if ( numval.charAt(0)=='+' )
    {
        var maintainplus = '';
    }
    curphonevar = numval.replace(/[\\A-Za-z!"£$%^&\,*+_={};:'@#~,.Š\/<>?|`¬\]\[]/g,'');
   
    quantity.value = maintainplus + curphonevar;
    var maintainplus = '';
    quantity.focus;
}

</script>
  
</body>
</html>