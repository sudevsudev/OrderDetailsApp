<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Order Details </h1>
   <a href="/">HOME PAGE</a>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>Phone</th><th>Amount</th><th>Date</th></tr>  
   <c:forEach var="order" items="${OrderDetails }">   
   <tr>  
   <td>${order.name}</td>   
   <td>${order.phone}</td>  
   <td>${order.amount}</td>  
   <td>${order.date}</td>  
 </tr>
   </c:forEach>  
   </table>  
   <br/>  
    

</body>
</html>