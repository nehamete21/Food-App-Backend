package com.cl.FoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cl.FoodApp.dto.FoodOrder;
import com.cl.FoodApp.service.FoodOrderService;
import com.cl.FoodApp.utils.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class FoodOrderController {
	@Autowired 
	FoodOrderService FoodOrderService;
	
	@PostMapping("/saveFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder FoodOrder) {
		return FoodOrderService.saveFoodOrder(FoodOrder);
	}
	
	@PutMapping("/updateFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder FoodOrder,@RequestParam int id) {
		return FoodOrderService.updateFoodOrder(FoodOrder,id); 
	}
	
	@DeleteMapping("/deleteFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int id) {
	    return FoodOrderService.deleteFoodOrder(id);	
	}
	
	@GetMapping("/getbyidfoodOrder/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@PathVariable int id) {
		return FoodOrderService.getFoodOrderById(id);
	}
	
	@GetMapping("/findallFoodOrder")
	public ResponseEntity<ResponseStructure<List<FoodOrder>>> findAllFoodOrder(){
		return FoodOrderService.findAllFoodOrder();
	}
}
