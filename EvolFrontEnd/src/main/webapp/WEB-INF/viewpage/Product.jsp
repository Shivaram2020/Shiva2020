<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Product</title>
<jsp:include page="header1.jsp"/>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}
th, td {
    text-align: left;
    padding: 8px;
}
tr:hover
{
background-color: #abebc6
}
</style>
</head>
<body style="background-color:#E6E6FA">
<c:if test="${sessionScope.loggedIn }">
<form:form method="POST" action="InsertProduct" modelAttribute="product" enctype="multipart/form-data">

<table align="center">
			<tr>
				<td colspan="2"><center>Product Details</center></td>
			</tr>
			<c:if test="${flag}">
			<tr>
				<td>Product ID</td>
				<td><form:input  path="prodid" /></td>
			</tr>
			</c:if>
			<tr>
				<td>Product Name</td>
				<td><form:input path="prodname" required="required"/></td>
			</tr>
			
			<tr>
				<td>Category</td>
				<td><form:select path="catid" >
						<form:option value="0" label="------Select----"  required="required"/>
						<form:options items="${catlist}" />
					</form:select>
				</td>
			</tr>		
			<tr>
				<td>Supplier</td>
				<td><form:select path="suppid" required="required">
						<form:option value="0" label="------Select----"/>
						<form:options items="${supplist}" />
					</form:select>
				</td>
			</tr>		
			<tr>
				<td>Offer</td>
				<td><form:select path="offid" required="required">
						<form:option value="0" label="------Select----"/>
						<form:options items="${offlist}" />
					</form:select>
				</td>
			</tr>	
			<tr>
				<td>Price</td>
				<td><form:input path="price" onkeyup="validatequantity(this);" id="quantity" required="required"  value="1" /></td>
			</tr>
			<tr>
				<td>Stock</td>
				<td><form:input path="quantity"  onkeyup="validatequantity(this);" id="quantity" required="required" value="1" /></td>
			</tr>
			<tr>
				<td>Product Desc</td>
				<td><form:textarea path="proddesc"  required="required" /></td>
			</tr>
			
	<tr>
			<td>Product Image</td>
			<td><form:input type="file" path="pimage" required="required"/></td>
	</tr>


			
			<tr>
			<td colspan="2"><input type="submit"  value="Submit"/></td>
			</tr>
</table>
</form:form>

<!-- Displaying the Product data using Table -->
<table class="t">

	<tr>
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Price</td>
		<td>Quantity</td>
		<td>Category Id</td>
		<td>Supplier Id</td>
			<td>Offer Id</td>
		<td>Description</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${prodlist}" var="product">
		<tr >
			<td>${product.prodid}</td>
			<td>${product.prodname}</td>
			<td>${product.price}</td>
			<td>${product.quantity}</td>
			<td>${product.catid}</td>
			<td>${product.suppid}</td>
			<td>${product.offid}</td>
			<td>${product.proddesc}</td>
			<td><a href="<c:url value="deleteProduct/${product.prodid}"/>">Delete</a>
				<a href="<c:url value="updateProduct/${product.prodid}"/>">Update</a>
			</td>
		</tr>
	</c:forEach>
</table>
</c:if>

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

