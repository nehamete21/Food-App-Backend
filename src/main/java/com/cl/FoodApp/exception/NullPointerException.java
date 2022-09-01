package com.cl.FoodApp.exception;

public class NullPointerException extends RuntimeException {
	String message ="You are trying to acess object which is not present";
	
	@Override
	public String getMessage() {
		return message;
	}
}
