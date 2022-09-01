package com.cl.FoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.FoodApp.dao.StaffDAO;
import com.cl.FoodApp.dto.Staff;
import com.cl.FoodApp.dto.Staff;
import com.cl.FoodApp.exception.IdNotFoundException;
import com.cl.FoodApp.utils.AES;
import com.cl.FoodApp.utils.ResponseStructure;

@Service
public class StaffService {

	
	@Autowired
	StaffDAO staffDao;
	
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff) {
		
		//staff.setPassword(AES.encrypt(staff.getPassword(), staff.getEmail()));
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Staff saved sucessfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setT(staffDao.saveStaff(staff));
		return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(int id) {
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Staff deleted  sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(staffDao.deleteStaff(id));
		return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<Staff>> getStaffById( int id) {
		Optional<Staff> Staff = staffDao.getStaffById(id);
		if (Staff.isEmpty()) {
			throw new IdNotFoundException();

		} else {
			ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Staff Found sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(Staff.get());
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.OK);		
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<Staff>>> findAllStaff(){
		ResponseStructure<List<Staff>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("List of admins Found sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(staffDao.findAllStaff());
		return new ResponseEntity<ResponseStructure<List<Staff>>>(responseStructure,HttpStatus.OK);		

	}
	
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(Staff staff, int id) {
		Staff newAdmin =staffDao.updateStaff(staff , id);
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();

		if(newAdmin != null) {
			responseStructure.setMessage("Staff Updated sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(staff);
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.OK);
			}
		else {
			responseStructure.setMessage("Invalid Id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setT(null);
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.NOT_FOUND);
			
			}	
	}
}
