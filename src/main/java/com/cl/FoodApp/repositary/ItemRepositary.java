package com.cl.FoodApp.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.FoodApp.dto.Branch;
import com.cl.FoodApp.dto.Item;

public interface ItemRepositary extends JpaRepository<Item, Integer> {

}
