<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="Insertproduct" modelAtrribute="Product">
<table>
    <tr>
        <td>Product id:</td>
       <td><form:input path="prodid"/>  
         </tr>
    <tr>
        <td> ProductName:</td>
        <td><form:password path="prodname" /></td>
    </tr>
    <tr>
    <td>Category id:</td>
    <td><form:select path="catid">
    <td><form:option value="0" label="--------select--------"></form:option>
    <td> <form:options items="${catid}"/><td>
    </form:select>
    <tr>
        <td>Supplier:</td>
        <td><form:input path="suppid" /></td>
    </tr>
    <tr>
        <td>Price:</td>
        <td><form:input path="price" /></td>
    </tr>
    <tr>
        <td> Stock:</td>
        <td><form:input path="quantity" /></td>
    </tr>
    <tr>
        <td> Product Desc:</td>
        <td><form:textarea path="proddesc" /></td>
    </tr>
    
    
    </table>
    </form:form>






</body>
</html>