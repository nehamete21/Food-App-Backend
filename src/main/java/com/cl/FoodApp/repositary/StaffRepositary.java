package com.cl.FoodApp.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.FoodApp.dto.Staff;

public interface StaffRepositary extends JpaRepository<Staff, Integer>{

}
