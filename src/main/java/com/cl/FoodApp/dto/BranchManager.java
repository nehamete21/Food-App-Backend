package com.cl.FoodApp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BranchManager {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  int id;
	  String name;
	  @Column(unique = true)
	  String email;
	  String password;
	  String role;
	  
	  public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	  //add list of menu
	  @OneToMany(cascade = {CascadeType.ALL})
	  List<Menu> menu;
	  
	  @OneToMany(cascade = {CascadeType.ALL})
	  List<Staff> staffs; 

	  @OneToMany(cascade = {CascadeType.ALL})
	  List<Item> items;
	  
	   
	


	public int getId() {
		return id;
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


	public List<Menu> getMenu() {
		return menu;
	}


	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}


	public List<Staff> getStaffs() {
		return staffs;
	}


	public void setStaff(List<Staff> staff) {
		this.staffs = staff;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> item) {
		this.items = item;
	}


	
      
}
