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
import com.cl.FoodApp.service.AdminService;
import com.cl.FoodApp.service.ItemService;
import com.cl.FoodApp.utils.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
   
	
	@Autowired 
	AdminService adminService;
	
	
	@PostMapping("/saveAdmin")
	public ResponseEntity<ResponseStructure<Admin>>  saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin,@RequestParam int id) {
		return adminService.updateAdmin(admin,id); 
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam int id) {
	    return adminService.deleteAdmin(id);	
	}
	
	@GetMapping("/getbyidAdmin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@PathVariable int id) {
		return adminService.getAdminById(id);
	}
	
	
	@GetMapping("/findalladmin")
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin(){
		return adminService.findAllAdmin();
	}
}
