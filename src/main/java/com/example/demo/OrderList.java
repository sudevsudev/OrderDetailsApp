package com.example.demo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderList {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("date")
	@Expose
	private String date;
	@SerializedName("amount")
	@Expose
	private Integer amount;
	@SerializedName("phone")
	@Expose
	private long phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "OrderList [name=" + name + ", date=" + date + ", amount=" + amount + ", phone=" + phone + "]";
	}
	
}