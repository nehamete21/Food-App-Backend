package com.cl.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.cl.FoodApp.dto.Staff;
import com.cl.FoodApp.repositary.StaffRepositary;

@Repository
public class StaffDAO {
	
	@Autowired
	private StaffRepositary staffRepositary;

	public Staff saveStaff(@RequestBody Staff staff) {
		return staffRepositary.save(staff);
	}

	// update
	public Staff updateStaff(@RequestBody Staff staff , int id) {
		staff.setId(id);
		return staffRepositary.save(staff);	}

	// delete
	public Staff deleteStaff(int id) {
		Staff staff = getStaffById(id).get();
		staffRepositary.delete(staff);
		return staff;
	}

	// getById
	public Optional<Staff> getStaffById(int id) {

		return staffRepositary.findById(id);
	}

	// list of all admins
	public List<Staff> findAllStaff() {
		return staffRepositary.findAll();
	}
}
