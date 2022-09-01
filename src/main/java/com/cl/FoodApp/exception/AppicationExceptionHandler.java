package com.cl.FoodApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cl.FoodApp.utils.ResponseStructure;

@ControllerAdvice
public class AppicationExceptionHandler extends ResponseEntityExceptionHandler{
  
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException exception){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Id Not Found In DataBase");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setT("no such id found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseStructure<String>> nullPointerException(NullPointerException exception){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Object is not present");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setT("No reference found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
