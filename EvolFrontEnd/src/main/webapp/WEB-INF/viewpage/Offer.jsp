<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title> offer </title>
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
<!-- Offer Form Started -->
<c:if test="${flag}">
<form action="UpdateOffer" method="post">
</c:if>
<c:if test="${!flag }">
<form action="AddOffer" method="post">
</c:if>
	
	<h1 align="center"> Details</h1>
	<c:if test="${flag }">
		<h1 align="center">Offer ID: <input type="text"  type="hidden" name="offid" value="${offer.offid}"/>
		</c:if>
		
	<c:if test="${flag}">
	<h1 align="center">Offer Name: <input type="text" required type="hidden" name="offname" value="${offer.offname}"/></h1>
	</c:if>
	<c:if test="${!flag }">
	<h1 align="center">Offer Name: <input type="text" required name="offname"/></h1>
	</c:if>
	<c:if test="${flag}">
	<h1 align="center">Offer Description <input type="text" required type="hidden" name="offdesc" value="${offer.offdesc}"/></h1>
	</c:if>
	<c:if test="${!flag }">
	<h1 align="center">Offer Description<input type="text" required name="offdesc"/></h1>
	</c:if>
	
	
    <c:if test="${!flag }">
		<h1 align="center"><input type="submit" value="AddOffer"/></h1>
		</c:if>
		<c:if test="${flag}">
		<h1 align="center"><input type="submit" type="hidden" value="UpdateOffer"/></h1>
	</c:if>
	
	

</form>

<!-- Offer Form Completed -->
<table align="center" cellspacing="2">
<tr>


<td>Offer id</td>
<td>Offer name</td>
<td>Offer description</td>
<td>Operation<td>
</tr>



<c:forEach items="${offdetails}" var="offer"  >
<tr>
<td>${offer.offid}</td>
 <td>${offer.offname}</td>  
 <td>${offer.offdesc}</td> 
 
  <c:set var = "delete"  value = "deleteOffer"/>
  <c:set var = "update"  value = "updateOffer"/>
 <td><a href="<c:url value="${delete}/${offer.offid}"/>">delete</a></td>
 <td><a href="<c:url value="${update}/${offer.offid}"/>">Update</a></td></tr>
  

</c:forEach>

</table>

</c:if>


</body>
</html>

