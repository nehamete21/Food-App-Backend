package com.cl.FoodApp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   int id;
   String status;
   String customerEmail;
   Float totalPrice;
   String customerName;
   long ContactNumber;
   String orderCreatedTime;
   String orderDeliveryTime;
   
   
   
   @OneToMany(cascade = {CascadeType.ALL })
   List<Item> items;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Float getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(Float totalPrice) {
	this.totalPrice = totalPrice;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public long getContactNumber() {
	return ContactNumber;
}

public void setContactNumber(long contactNumber) {
	this.ContactNumber = contactNumber;
}

public String getOrderCreatedTime() {
	return orderCreatedTime;
}

public void setOrderCreatedTime(String orderCreatedTime) {
	this.orderCreatedTime = orderCreatedTime;
}

public String getOrderDeliveryTime() {
	return orderDeliveryTime;
}

public void setOrderDeliveryTime(String orderDeliveryTime) {
	this.orderDeliveryTime = orderDeliveryTime;
}


public List<Item> getItems() {
	return items;
}

public void setItems(List<Item> items) {
	this.items = items;
}
   
   

}
