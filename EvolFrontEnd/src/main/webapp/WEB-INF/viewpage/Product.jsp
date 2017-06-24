<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product</title>
</head>
<body>
<form:form action="InsertProduct" modelAtrribute="product" commandName="product" method="post">
<table>
   
    <tr>
        <td> ProductName:</td>
        <td><form:input path="prodname" /></td>
    </tr>
    <tr>
    <td>Category id:</td>
    <td><form:select path="catid">
    <td><form:option value="0" label="--------select--------">
    <td> <form:options items="${catlist}"/><td></form:option>
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
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
        <td></td></tr>
    </table>
    </form:form>
</body>
</html>