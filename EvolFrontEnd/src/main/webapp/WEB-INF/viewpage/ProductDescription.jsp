<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   


</head>
<body>
<div>

<img src="<c:url value="/resources/images/${prodinfo.prodid}.jpg"/>">
</div>

<div>
${prodinfo.prodname}
</div>

<form action="<c:url value="/AddCart/${prodinfo.prodid}"/>" method="get">
Quantity<input type="text" name="quantity"/>

<input type="submit" name="submit"/>
</form>

</body>
</html>