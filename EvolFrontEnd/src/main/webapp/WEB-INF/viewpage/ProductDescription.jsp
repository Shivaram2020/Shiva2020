<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product description</title>


<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   


<link href="<c:url value="/resources/product/css/desc.css" />" rel="stylesheet">


</head>
<body>


<div class="product">
<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="<c:url value="/resources/images/${prodinfo.prodid}.jpg"/>"></div>
						 	</div>
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${prodinfo.prodname}</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked "></span>
								<span class="fa fa-star"></span>
							</div>
							<span class="review-no">41 reviews</span>
						</div>
						<p class="product-description">${prodinfo.proddesc}</p>
						<h4 class="price">current price: <span>&#8377 ${prodinfo.price}</span></h4>
						<p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>
					
						<div class="action">
							<form action="<c:url value="/AddCart/${prodinfo.prodid}"/>" method="get">
Quantity<input type="text"  name="quantity" onkeyup="validatequantity(this);" id="quantity" value="1" required/>

<input type="submit" name="submit"  class="add-to-cart" value="Add to cart"/>
</form>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
 </div>
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