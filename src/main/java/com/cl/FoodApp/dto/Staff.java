package com.cl.FoodApp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Staff {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  int id;
	  String name;
	  @Column(unique = true)
	  String email;
	  String password;
	  String role;
	  
	   
//	  @OneToMany(cascade = {CascadeType.ALL})
//	  List<Item> item;
//	  
	  @OneToMany(cascade = {CascadeType.ALL})
	  List<FoodOrder> foodOrders;

	public int getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public List<Item> getItem() {
//		return item;
//	}
//
//	public void setItem(List<Item> item) {
//		this.item = item;
//	}

	public List<FoodOrder> getFoodOrders() {
		return foodOrders;
	}

	public void setFoodOrders(List<FoodOrder> foodOrders) {
		this.foodOrders = foodOrders;
	}

    
}
