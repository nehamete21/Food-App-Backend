package com.cl.FoodApp.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.FoodApp.dto.BranchManager;
import com.cl.FoodApp.dto.FoodOrder;

public interface FoodOrderRepositary extends JpaRepository<FoodOrder, Integer>{

}
