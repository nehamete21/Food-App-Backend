package com.cl.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.FoodApp.dto.Register;
import com.cl.FoodApp.repositary.RegisterRepositary;

@Repository
public class RegisterDao {

	@Autowired
	private RegisterRepositary registerRepositary;
	
	//save
	public Register saveUser(Register register) {
		return registerRepositary.save(register);
	}
	
	public Register updateUser(Register register, int id) {
		if(registerRepositary.findById(id).isEmpty()) {
			return null;
		}else {
			register.setId(id);
		    return registerRepositary.save(register);
		}

	}

	
	//delete
	public Register deleteUser(int id) {
		Register user = getUserById(id).get();
		registerRepositary.delete(getUserById(id).get());
        return user;
	}

	
	public Optional<Register> getUserById(int id) {
		
		return registerRepositary.findById(id);
	}

	public List<Register> findAllUser(){
		return registerRepositary.findAll();
	}

}
