package com.example.demo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

@SerializedName("OrderList")
@Expose
private List<OrderList> orderList = null;

public List<OrderList> getOrderList() {
return orderList;
}

public void setOrderList(List<OrderList> orderList) {
this.orderList = orderList;
}

}