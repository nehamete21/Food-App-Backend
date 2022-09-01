package com.cl.FoodApp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cl.FoodApp.dao.RegisterDao;
import com.cl.FoodApp.dto.Register;
import com.cl.FoodApp.exception.IdNotFoundException;
import com.cl.FoodApp.utils.AES;
import com.cl.FoodApp.utils.ResponseStructure;

@Service
public class RegisterService {

	@Autowired
	RegisterDao registerDao;

	public ResponseEntity<ResponseStructure<Register>> saveUser(Register register) {

		//Register.setPassword(AES.encrypt(Register.getPassword(), Register.getEmail()));
		ResponseStructure<Register> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Register saved sucessfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setT(registerDao.saveUser(register));
		return new ResponseEntity<ResponseStructure<Register>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Register>> deleteUser(int id) {
		ResponseStructure<Register> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Register deleted  sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(registerDao.deleteUser(id));
		return new ResponseEntity<ResponseStructure<Register>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Register>> getUserById(int id) {
		Optional<Register> Register = registerDao.getUserById(id);
		if (Register.isEmpty()) {
			throw new IdNotFoundException();

		} else {
			ResponseStructure<Register> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Register Found sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(Register.get());
			return new ResponseEntity<ResponseStructure<Register>>(responseStructure,HttpStatus.OK);		
		}
	}

	public ResponseEntity<ResponseStructure<List<Register>>>findAllUser() {
		ResponseStructure<List<Register>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("List of admins Found sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(registerDao.findAllUser());
		return new ResponseEntity<ResponseStructure<List<Register>>>(responseStructure,HttpStatus.OK);		

		
	}

	public ResponseEntity<ResponseStructure<Register>> updateUser(Register Register, int id) {
		Register newuser =registerDao.updateUser(Register, id);
		ResponseStructure<Register> responseStructure = new ResponseStructure<>();

		if(newuser != null) {
			responseStructure.setMessage("Register Updated sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(newuser);
			return new ResponseEntity<ResponseStructure<Register>>(responseStructure,HttpStatus.OK);
			}
		else {
			responseStructure.setMessage("Invalid Id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setT(null);
			return new ResponseEntity<ResponseStructure<Register>>(responseStructure,HttpStatus.NOT_FOUND);
			
			}	
		
}
	
}
