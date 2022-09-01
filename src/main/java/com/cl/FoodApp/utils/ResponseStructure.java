package com.cl.FoodApp.utils;

import com.cl.FoodApp.dto.BranchManager;

public class ResponseStructure<T> {
  String message;
  int status;
  T t;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public T getT() {
	return t;
}
public void setT(T t) {
	this.t = t;
}

  
}
