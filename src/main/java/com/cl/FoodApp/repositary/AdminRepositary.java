package com.cl.FoodApp.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.FoodApp.dto.Admin;

public interface AdminRepositary extends JpaRepository<Admin, Integer>{

}
