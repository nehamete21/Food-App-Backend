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

import com.cl.FoodApp.dto.BranchManager;
import com.cl.FoodApp.service.BranchManagerService;
import com.cl.FoodApp.utils.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class BranchManagerController {
	@Autowired 
	BranchManagerService branchManagerService;
	
	@PostMapping("/saveBranchManager")
	public ResponseEntity<ResponseStructure<BranchManager>> saveBranchManager(@RequestBody BranchManager branchManager) {
		return branchManagerService.saveBranchManager(branchManager);
	}
	
	@PutMapping("/updateBranchManager")
	public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager(@RequestBody BranchManager branchManager, @RequestParam int id ) {
		return branchManagerService.updateBranchManager(branchManager,id); 
	}
	
	@DeleteMapping("/deleteBranchManager")
	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(@RequestParam int id) {
	    return branchManagerService.deleteBranchManager(id);	
	}
	
	@GetMapping("/getbyidManager/{id}")
	public ResponseEntity<ResponseStructure<BranchManager>> getBranchManagerById(@PathVariable int id) {
		return branchManagerService.getBranchManagerById(id);
	}
	
	@GetMapping("/findallBranchManager")
	public ResponseEntity<ResponseStructure<List<BranchManager>>> findAllBranchManager(){
		return branchManagerService.findAllBranchManager();
	}
}
