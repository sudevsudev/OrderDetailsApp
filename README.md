# OrderDetailsApp

Sample Record Orders.csv 

#Spring MVC 
Get All Customer Order Detail without using JPA : @RequestMapping("getAllOrders").

#REST Service 
REST Service to Get All Customer Order Detail in JSON.

GET Request : http://localhost:9988/getAllOrder

#Using GSON
FromJson file OrderList.json

>Total Number of orders Recived.

>Get Total Amount of the orders. 

>Name of Customers Ordered only Once.

>List of ordered one time, two time ... 

>Name of customers By Number of orders.
 
PostgresSQL:

create table orders(date varchar(20), phone bigint, name varchar(30), amount bigint);

copy all DATA using:

\COPY orders(date, phone, name, amount) FROM 'C:\Users\sudev k r\Desktop\Orders.csv' DELIMITER ',' CSV HEADER;
