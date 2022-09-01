package com.cl.FoodApp.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.FoodApp.dto.Register;

public interface RegisterRepositary extends JpaRepository<Register, Integer>{

}
