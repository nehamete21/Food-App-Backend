package com.cl.FoodApp.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.FoodApp.dto.Branch;

public interface BranchRepositary extends JpaRepository<Branch, Integer>{

}
