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
<form action="UpdateCategory" method="post">
</c:if>
<c:if test="${!flag }">
<form action="AddCategory" method="post">
</c:if>
	
	<h1 align="center"> Details</h1>
	<c:if test="${flag }">
		<h1 align="center">Category ID: <input type="text"  type="hidden" name="catid" value="${category.catid}"/>
		</c:if>
		
	<c:if test="${flag}">
	<h1 align="center">Category Name: <input type="text" required type="hidden" name="catname" value="${category.catname}"/></h1>
	</c:if>
	<c:if test="${!flag }">
	<h1 align="center">Category Name: <input type="text" required name="catname"/></h1>
	</c:if>
	<c:if test="${flag}">
	<h1 align="center">Category Description <input type="text" required type="hidden" name="catdesc" value="${category.catdesc}"/></h1>
	</c:if>
	<c:if test="${!flag }">
	<h1 align="center">Category Description<input type="text" required name="catdesc"/></h1>
	</c:if>
	
	
    <c:if test="${!flag }">
		<h1 align="center"><input type="submit" value="AddCategory"/></h1>
		</c:if>
		<c:if test="${flag}">
		<h1 align="center"><input type="submit" type="hidden" value="UpdateCategory"/></h1>
	</c:if>
	
	

</form>

<!-- Category Form Completed -->
<table align="center" cellspacing="2">
<tr>


<td>Category id</td>
<td>Category name</td>
<td>Category description</td>
<td>Operation<td>
</tr>



<c:forEach items="${catdetails}" var="category"  >
<tr>
<td>${category.catid}</td>
 <td>${category.catname}</td>  
 <td>${category.catdesc}</td> 
 
  <c:set var = "delete"  value = "deleteCategory"/>
  <c:set var = "update"  value = "updateCategory"/>
 <td><a href="<c:url value="${delete}/${category.catid}"/>">delete</a></td>
 <td><a href="<c:url value="${update}/${category.catid}"/>">Update</a></td></tr>
  

</c:forEach>

</table>

</c:if>


</body>
</html>
