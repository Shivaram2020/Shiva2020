<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title> category </title>
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
<body>
<!-- Category Form Started -->
<form action="AddCategory" method="post">

	
	<h1 align="center"> Details</h1>
	
	
	<h1 align="center">Category Name: <input type="text" name="catname"/></h1>
	
	<h1 align="center">Category Description<input type="text" name="catdesc"/></h1>
	
	
	

		<h1 align="center"><input type="submit" value="AddCategory"/></h1>
	
	

</form>
<!-- Category Form Completed -->
<table align="center" cellspacing="2">
<tr>


<td>Category id</td>
<td>Category name</td>
<td>Category description</td>
</tr>



<c:forEach items="${catdetails}" var="category">
<tr>
<td>${category.catid}</td>
 <td>${category.catname}</td>  
 <td>${category.catdesc}</td> </tr>
</c:forEach>


</table>

</body>
</html>
