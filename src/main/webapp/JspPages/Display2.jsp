<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.HashMap"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Number of Orders</title>
</head>
<body>
<h1>Order Details Based on Number of Orders or ONE time Orders </h1>
   <a href="/">HOME PAGE</a>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>Number of Orders</th></tr>  
   <c:forEach var="order" items="${OrderDetails }">   
   <tr>  
   <td>${order.getKey()}</td>   
   <td>${order.getValue()}</td>  
 </tr>
   </c:forEach>  
   </table>  
   <br/>  
 

</body>
</html>