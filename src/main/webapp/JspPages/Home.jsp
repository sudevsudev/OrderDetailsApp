<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="getAllOrders">
Total Number of orders Recived
<input type="submit" value="Allorders" />
</form>

Without using SQL:

<form action="getAllOrderDetail">
Get All Customer Order Detail without using sql : 
<input type="submit" value="getAllOrderDetail" />
</form>

<form action="getTotalNoOfOrders">
Total Number of orders Recived : 
<input type="submit" value="getTotalNoOfOrders" />
</form>

<form action="getTotalAmount">
Get Total Amount of the orders : 
<input type="submit" value="getTotalAmount" />
</form>

<form action="getNameOfOneTime">
Name of Customers Ordered Once : 
<input type="submit" value="getone" />
</form>

<form action="getOneTimeOrder">
List of customers ordered once :
<input type="submit" value="ListOneTimeOrder" />
</form>
 
<form action="getNameByOrders">
Name By Number of orders :
<input type="submit" value="Listorders" />
</form>


</body>
</html>