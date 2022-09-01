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
public class Admin {
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

@OneToMany(cascade = {CascadeType.ALL})
  List<Branch> branch;

  @OneToMany(cascade = {CascadeType.ALL})
  List<BranchManager> branchManager;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public List<Branch> getBranch() {
	return branch;
}

public void setBranch(List<Branch> branch) {
	this.branch = branch;
}

public List<BranchManager> getBranchManager() {
	return branchManager;
}

public void setBranchManager(List<BranchManager> branchManager) {
	this.branchManager = branchManager;
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

//public List<Branch> getBranch() {
//	return branch;
//}
//
//public void setBranch(List<Branch> branch) {
//	this.branch = branch;
//}

//public List<BranchManager> getBranchManager() {
//	return branchManager;
//}
//
//public void setBranchManager(List<BranchManager> branchManager) {
//	this.branchManager = branchManager;
//}
  
  
  
}
