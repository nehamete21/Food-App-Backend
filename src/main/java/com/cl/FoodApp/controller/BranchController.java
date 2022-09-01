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

import com.cl.FoodApp.dto.Branch;
import com.cl.FoodApp.service.BranchService;
import com.cl.FoodApp.utils.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BranchController {
	
	@Autowired 
	BranchService branchService;
	
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}
	
	@PutMapping("/updateBranch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch( @RequestBody Branch branch, @RequestParam int id) {
		return branchService.updateBranch(branch,id); 
	}
	
	@DeleteMapping("/deleteBranch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id) {
	    return branchService.deleteBranch(id);	
	}
	
	@GetMapping("/getbyidBranch")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@PathVariable int id) {
		return branchService.getBranchById(id);
	}
	
	@GetMapping("/findallBranch")
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch(){
		return branchService.findAllBranch();
	}
}
