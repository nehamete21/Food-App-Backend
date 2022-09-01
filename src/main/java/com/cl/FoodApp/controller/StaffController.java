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

import com.cl.FoodApp.dto.Staff;
import com.cl.FoodApp.service.StaffService;
import com.cl.FoodApp.utils.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class StaffController {
	@Autowired 
	StaffService staffService;
	
	@PostMapping("/saveStaff")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff Staff) {
		return staffService.saveStaff(Staff);
	}
	
	@PutMapping("/updateStaff")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff Staff, @RequestParam int id) {
		return staffService.updateStaff(Staff, id); 
	}
	
	@DeleteMapping("/deleteStaff")
	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(@RequestParam int id) {
	    return staffService.deleteStaff(id);	
	}
	
	@GetMapping("/getbyidstaff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> getStaffById(@PathVariable int id) {
		return staffService.getStaffById(id);
	}
	
	@GetMapping("/findallStaff")
	public ResponseEntity<ResponseStructure<List<Staff>>> findAllStaff(){
		return staffService.findAllStaff();
	}
}
