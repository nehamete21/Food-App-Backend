package com.cl.FoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.FoodApp.dao.BranchManagerDAO;
import com.cl.FoodApp.dto.Admin;
import com.cl.FoodApp.dto.BranchManager;
import com.cl.FoodApp.exception.IdNotFoundException;
import com.cl.FoodApp.utils.AES;
import com.cl.FoodApp.utils.ResponseStructure;

@Service
public class BranchManagerService {
  
	@Autowired
	BranchManagerDAO branchManagerDao;
	
	public ResponseEntity<ResponseStructure<BranchManager>> saveBranchManager(BranchManager branchManager) {
		
		//branchManager.setPassword(AES.encrypt(branchManager.getPassword(),branchManager.getEmail() ));
		ResponseStructure<BranchManager> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Branch manager saved sucessfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setT(branchManagerDao.saveBranchManager(branchManager));
		return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure,HttpStatus.CREATED);

	}
	
	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(int id) {
		ResponseStructure<BranchManager> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Branch Manager deleted  sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(branchManagerDao.deleteBranchManager(id));
		return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure,HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<BranchManager>> getBranchManagerById( int id) {
		
		Optional<BranchManager> branchManager = branchManagerDao.getBranchManagerById(id);
		
		if (branchManager.isEmpty()) {
			throw new IdNotFoundException();

		} else {
			ResponseStructure<BranchManager> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("branchManager Found sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(branchManager.get());
			return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure,HttpStatus.OK);		
		}
		
	}
	
	
	public  ResponseEntity<ResponseStructure<List<BranchManager>>> findAllBranchManager(){
		ResponseStructure<List<BranchManager>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("List of BranchManager Found sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(branchManagerDao.findAllBranchManager());
		return new ResponseEntity<ResponseStructure<List<BranchManager>>>(responseStructure,HttpStatus.OK);		
	}
	
	public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager(BranchManager branchManager,int id) {
		BranchManager newBranchManager = branchManagerDao.updateBranchManager(branchManager, id);
		ResponseStructure<BranchManager> responseStructure = new ResponseStructure<>();

		if(newBranchManager != null) {
			responseStructure.setMessage("BranchManager Updated sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(newBranchManager);
			return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure, HttpStatus.OK);
			}
		else {
			responseStructure.setMessage("Invalid Id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setT(null);
			return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure, HttpStatus.NOT_FOUND);
			
			}	
		
	}
}
