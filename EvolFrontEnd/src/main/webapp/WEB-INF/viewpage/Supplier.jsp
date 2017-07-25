<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title> category </title>
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

tr:nth-child(even){background-color: #f2f2f2}
</style>
</head>
<body style="background-color:#E6E6FA">

<c:if test="${sessionScope.loggedIn }">
<!-- Category Form Started -->
<c:if test="${flag}">
<form action="UpdateSupplier" method="post">
</c:if>
<c:if test="${!flag }">
<form action="AddSupplier" method="post">
</c:if>
	
	<h1 align="center"> Details</h1>
	<c:if test="${flag}">
	<h1 align="center">Supplier Id: <input type="text" type="hidden" name="suppid" value="${category.suppid}"/></h1>
	</c:if>
	
	
	<c:if test="${flag}">
	<h1 align="center">Supplier Name: <input type="text" required type="hidden" name="suppname" value="${category.suppname}"/></h1>
	</c:if>
	<c:if test="${!flag }">
	<h1 align="center">Supplier Name: <input type="text" required name="suppname"/></h1>
	</c:if>
	<c:if test="${flag}">
	<h1 align="center">Supplier Address <input type="text" required type="hidden" name="address" value="${category.address}"/></h1>
	</c:if>
	<c:if test="${!flag }">
	<h1 align="center">Supplier Address<input type="text" required name="address"/></h1>
	</c:if>
	
	
    <c:if test="${!flag }">
		<h1 align="center"><input type="submit" value="AddSupplier"/></h1>
		</c:if>
		<c:if test="${flag}">
		<h1 align="center"><input type="submit" type="hidden" value="UpdateSuppplier"/></h1>
	</c:if>
	
	

</form>

<!-- Supplier Form Completed -->
<table align="center" cellspacing="2">
<tr>


<td>Supplier id</td>
<td>Supplier name</td>
<td>Supplier address</td>
<td>Operation<td>
</tr>



<c:forEach items="${suppdetails}" var="supplier"  >
<tr>
<td>${supplier.suppid}</td>
 <td>${supplier.suppname}</td>  
 <td>${supplier.address}</td> 
 
  <c:set var = "delete"  value = "deleteSupplier"/>
  <c:set var = "update"  value = "updateSupplier"/>
 <td><a href="<c:url value="${delete}/${supplier.suppid}"/>">delete</a></td>
 <td><a href="<c:url value="${update}/${supplier.suppid}"/>">Update</a></td></tr>
  

</c:forEach>

</table>
</c:if>
</body>
</html>
