<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shipping done</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<link href="<c:url value="/resources/product/css/confirm.css"/>" rel="stylesheet">
<jsp:include page="header.jsp"/>
</head>
<body>




<c:forEach items="${orderlist}" var="orderlist">

<div class="container">
	<div class="row">
		
        <div class="receipt-main col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
            <div class="row">
    			<div class="receipt-header">
					<div class="col-xs-6 col-sm-6 col-md-6">
						
					
					<div class="col-xs-6 col-sm-6 col-md-6 text-right">
						<div class="receipt-right">
							<h1>${orderlist.username}</h1>
							<small>${orderlist.shipmentaddress}</small>
							<h1>Order ID:${orderlist.orderid}</h1>
						</div>
					</div>
				</div>
            
			
			
			
					<div class="col-xs-4 col-sm-4 col-md-4">
						<div class="receipt-left">
							<h1>Receipt
							<a href="<c:url value="/deleteorders/${orderlist.orderid}"/>">

								<button type="button" class="btn btn-link btn-xs receipt-left glyphicon glyphicon-trash">
							
								</button></a></h1>
						</div>
					</div>
				</div>
            </div>
			<div class="col-xs-2">
							
							</div>
            <div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Mode of payment</th>
                            <th>Total Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="col-md-9"><h1>${orderlist.paymode}</h1></td>
                            <td class="col-md-3"><i class="fa fa-inr"></i><h1>&#8377 ${orderlist.total}</h1> </td>
                        </tr>
                        
                       
                        <tr>
                           
                            <td class="text-right"><h2><strong>Total: </strong></h2></td>
                            <td class="text-left text-danger"><h2><strong><i class="fa fa-inr"></i><h1>&#8377 ${orderlist.total}</h1> </strong></h2></td>
                        </tr>
                    </tbody>
                </table>
            </div>
			
			<div class="row">
				<div class="receipt-header receipt-header-mid receipt-footer">
					<div class="col-xs-8 col-sm-8 col-md-8 text-left">
						<div class="receipt-right">
							<p><b>Date :</b></p>  <p id="demo"></p>
							<h5 style="color: rgb(140, 140, 140);">Thank you for your business!</h5>
							
							<h1><a href="<c:url value="/confirm"/>" class="btn btn-info btn-lg"><h1>Confirm</h1></a></h1>
						</div>
					</div>
					
				</div>
            </div>
		</div>
		
</div>
</div>
		
		</c:forEach>
		<script>
document.getElementById("demo").innerHTML = Date();
</script>
		
</body>
</html>