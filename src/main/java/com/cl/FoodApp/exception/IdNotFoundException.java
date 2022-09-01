package com.cl.FoodApp.exception;

public class IdNotFoundException extends RuntimeException{
    
	String message ="Id not found , Please do check";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
