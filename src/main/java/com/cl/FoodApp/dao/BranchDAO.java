package com.cl.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.FoodApp.dto.Branch;
import com.cl.FoodApp.repositary.BranchRepositary;

@Repository
public class BranchDAO {
	
	@Autowired
	private BranchRepositary branchRepositary;
	
	    //save
		public Branch saveBranch(Branch branch) {
			return branchRepositary.save(branch);
		}
		
		//update
		public Branch updateBranch(Branch branch, int id) {
			
			if(branchRepositary.findById(id).isEmpty()) {
				return null;
			}else {
				branch.setId(id);
				return branchRepositary.save(branch);

			}
			
		}
		
		//delete
		public Branch deleteBranch(int id) {
			Branch branch = getBranchById(id).get();
			branchRepositary.delete(getBranchById(id).get());
			return branch;
		}
	    
		//getById
		public Optional<Branch> getBranchById(int id) {
			
			return branchRepositary.findById(id);
		}
		
		//list of all Branchs 
		public List<Branch> findAllBranch(){
			return branchRepositary.findAll();
		}

}
