package com.cl.FoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.FoodApp.dao.BranchDAO;
import com.cl.FoodApp.dto.Branch;
import com.cl.FoodApp.exception.IdNotFoundException;
import com.cl.FoodApp.utils.AES;
import com.cl.FoodApp.utils.ResponseStructure;

@Service
public class BranchService {
	
	@Autowired
	BranchDAO branchDao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Branch saved sucessfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setT(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);

	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Branch deleted  sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(branchDao.deleteBranch(id));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<Branch>> getBranchById( int id) {
		Optional<Branch> Branch = branchDao.getBranchById(id);
		if (Branch.isEmpty()) {
			throw new IdNotFoundException();

		} else {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Branch Found sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(Branch.get());
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);		
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch(){
		ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("List of admins Found sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(branchDao.findAllBranch());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.OK);		

	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch, int id) {
		Branch newBranch = branchDao.updateBranch(branch, id);
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();

		if(newBranch != null) {
			responseStructure.setMessage("Branch Updated sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(newBranch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
			}
		else {
			responseStructure.setMessage("Invalid Id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setT(null);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.NOT_FOUND);
			
			}	
		
}
	
}

