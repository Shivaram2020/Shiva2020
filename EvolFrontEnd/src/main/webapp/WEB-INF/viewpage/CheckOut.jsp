<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CheckOut</title>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<jsp:include page="header.jsp"/>
</head>
<body>

<c:forEach items="${cartlist}" var="cartlist">


<img src="<c:url value="/resources/images/${cartlist.prodid}.jpg"/>">




${cartlist.prodid}


${cartlist.price * cartlist.quantity}

${cartlist.productname}

 ${ cartlist.quantity }







</c:forEach>

${grandtotal}

<form action="<c:url value="/payment"/>" method="get">
paymode<input type="text" name="paymode" required/>
shipping address<input type="text" name="shipping" required/>



<input type="submit" value="payment "name="submit"/>
</form>
</body>
</html>