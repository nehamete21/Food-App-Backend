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

import com.cl.FoodApp.dao.AdminDAO;
import com.cl.FoodApp.dto.Admin;
import com.cl.FoodApp.exception.IdNotFoundException;
import com.cl.FoodApp.utils.AES;
import com.cl.FoodApp.utils.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	AdminDAO adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {

		//admin.setPassword(AES.encrypt(admin.getPassword(), admin.getEmail()));
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Admin saved sucessfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setT(adminDao.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Admin deleted  sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(adminDao.deleteAdmin(id));
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		Optional<Admin> admin = adminDao.getAdminById(id);
		if (admin.isEmpty()) {
			throw new IdNotFoundException();

		} else {
			ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Admin Found sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(admin.get());
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);		
		}
	}

	public ResponseEntity<ResponseStructure<List<Admin>>>findAllAdmin() {
		ResponseStructure<List<Admin>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("List of admins Found sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(adminDao.findAllAdmin());
		return new ResponseEntity<ResponseStructure<List<Admin>>>(responseStructure,HttpStatus.OK);		

		
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int id) {
		Admin newAdmin =adminDao.updateAdmin(admin, id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();

		if(newAdmin != null) {
			responseStructure.setMessage("Admin Updated sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(newAdmin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
			}
		else {
			responseStructure.setMessage("Invalid Id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setT(null);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.NOT_FOUND);
			
			}	
		
}
	
}
