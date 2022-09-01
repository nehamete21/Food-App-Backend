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

import com.cl.FoodApp.dto.Admin;
import com.cl.FoodApp.dto.Item;
import com.cl.FoodApp.dto.Register;
import com.cl.FoodApp.service.AdminService;
import com.cl.FoodApp.service.ItemService;
import com.cl.FoodApp.service.RegisterService;
import com.cl.FoodApp.utils.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {
   
	
	@Autowired 
	RegisterService registerService;
	
	
	@PostMapping("/saveUser")
	public ResponseEntity<ResponseStructure<Register>>  saveUser(@RequestBody Register user) {
		return registerService.saveUser(user);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<ResponseStructure<Register>> updateUser(@RequestBody Register register,@RequestParam int id) {
		return registerService.updateUser(register,id); 
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<ResponseStructure<Register>> deleteUser(@RequestParam int id) {
	    return registerService.deleteUser(id);	
	}
	
	
	@GetMapping("/getbyidUser/{id}")
	public ResponseEntity<ResponseStructure<Register>> getAdminById(@PathVariable int id) {
		return registerService.getUserById(id);
	}
	
	
	@GetMapping("/findallUser")
	public ResponseEntity<ResponseStructure<List<Register>>> findAllUser(){
		return registerService.findAllUser();
	}
}
