package com.cl.FoodApp.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.FoodApp.dto.Item;
import com.cl.FoodApp.dto.Menu;

public interface MenuRepositary extends JpaRepository<Menu, Integer>  {

}
