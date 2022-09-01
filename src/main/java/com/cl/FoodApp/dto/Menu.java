package com.cl.FoodApp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Menu {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
  int id;
	
  // there items are existing item from database
  @OneToMany(cascade = {CascadeType.ALL})
  List<Item> items;

//  @ManyToOne(cascade = {CascadeType.ALL})
//  BranchManager branchManager;
//  
//  @OneToMany(cascade = {CascadeType.ALL})
//  List<Item> item;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public List<Item> getItems() {
	return items;
}

public void setItems(List<Item> items) {
	this.items = items;
}

//public BranchManager getBranchManager() {
//	return branchManager;
//}
//
//public void setBranchManager(BranchManager branchManager) {
//	this.branchManager = branchManager;
//}

//public List<Item> getItem() {
//	return item;
//}
//
//public void setItem(List<Item> item) {
//	this.item = item;
//}
  
  
}
