package com.cl.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.FoodApp.dto.Admin;
import com.cl.FoodApp.repositary.AdminRepositary;

@Repository
public class AdminDAO {
	
	@Autowired
	private AdminRepositary adminRepositary;
	
	//save
	public Admin saveAdmin(Admin admin) {
		return adminRepositary.save(admin);
	}
	
	//update
	public Admin updateAdmin(Admin admin, int id) {
		if(adminRepositary.findById(id).isEmpty()) {
			return null;
		}else {
		    admin.setId(id);
		    return adminRepositary.save(admin);
		}

	}
	
	//delete
	public Admin deleteAdmin(int id) {
		Admin admin = getAdminById(id).get();
        adminRepositary.delete(getAdminById(id).get());
        return admin;
	}
    
	//getById
	public Optional<Admin> getAdminById(int id) {
		
		return adminRepositary.findById(id);
	}
	
	//list of all admins 
	public List<Admin> findAllAdmin(){
		return adminRepositary.findAll();
	}
	
	

}
