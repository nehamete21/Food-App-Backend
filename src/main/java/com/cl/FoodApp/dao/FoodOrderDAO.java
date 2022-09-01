package com.cl.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.cl.FoodApp.dto.FoodOrder;
import com.cl.FoodApp.repositary.FoodOrderRepositary;

@Repository
public class FoodOrderDAO {
	@Autowired
	private FoodOrderRepositary foodOrderRepositary;

	public FoodOrder savefoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderRepositary.save(foodOrder);
	}

	// update
	public FoodOrder updatefoodOrder(FoodOrder foodOrder, int id) {
		foodOrder.setId(id);
		return foodOrderRepositary.save(foodOrder);
	}

	// delete
	public FoodOrder deletefoodOrder(int id) {
		FoodOrder foodOrder = getfoodOrderById(id).get();
		foodOrderRepositary.delete(foodOrder);
		return foodOrder;
	}

	// getById
	public Optional<FoodOrder> getfoodOrderById(int id) {

		return foodOrderRepositary.findById(id);
	}

	// list of all admins
	public List<FoodOrder> findAllfoodOrders() {
		return foodOrderRepositary.findAll();
	}
}
