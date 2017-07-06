<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>


<c:forEach items="${cartlist}" var="cartlist">


<img src="<c:url value="/resources/images/${cartlist.prodid}.jpg"/>">




${cartlist.prodid}


${cartlist.price * cartlist.quantity}

${cartlist.productname}
<form action="<c:url value="/update/${cartlist.cartitemid}/${prodinfo.prodid}"/>" method="get" >


<input type="text" value="${ cartlist.quantity }" name="quantity"/>





<input type="submit" value="update">


<a href="<c:url value="/delete/${cartlist.cartitemid}"/>">delete</a>

</form>






</c:forEach>
<form action="<c:url value="UserHome1"/>" method="get" >

<input type="submit" value="ContinueShopping">
</form>
</body>
</html>