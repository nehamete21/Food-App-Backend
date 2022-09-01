package com.cl.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cl.FoodApp.dto.Admin;
import com.cl.FoodApp.dto.BranchManager;
import com.cl.FoodApp.repositary.BranchManagerRepositary;

@Repository
public class BranchManagerDAO {
	@Autowired
	private BranchManagerRepositary branchManagerRepositary;
    
	//save
	public BranchManager saveBranchManager(@RequestBody BranchManager branchManager) {
		return branchManagerRepositary.save(branchManager);
	}
    
	  //update
		public BranchManager updateBranchManager(BranchManager branchManager, int id) {
			if(branchManagerRepositary.findById(id).isEmpty()) {
				return null;
			}else {
				branchManager.setId(id);
				return branchManagerRepositary.save(branchManager);
			}
			
		
		}
		
		//delete
		public BranchManager deleteBranchManager(int id) {
			BranchManager branchManager = getBranchManagerById(id).get();
			branchManagerRepositary.delete(getBranchManagerById(id).get());
			return branchManager;
		}
	    
		//getById
		public Optional<BranchManager> getBranchManagerById(int id) {
			
			return branchManagerRepositary.findById(id);
		}
		
		//list of all BranchManagers 
		public List<BranchManager> findAllBranchManager(){
			return branchManagerRepositary.findAll();
		}
}
