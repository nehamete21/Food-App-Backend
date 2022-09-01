package com.cl.FoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.FoodApp.dao.FoodOrderDAO;
import com.cl.FoodApp.dto.EmailDetails;
import com.cl.FoodApp.dto.FoodOrder;
import com.cl.FoodApp.exception.IdNotFoundException;
import com.cl.FoodApp.utils.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDAO foodOrderDao;
	
	@Autowired
	EmailDetails emailDetails;
	
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {

		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("FoodOrder saved sucessfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setT(foodOrderDao.savefoodOrder(foodOrder));

		// after saving food order send bill to customer
		emailDetails.setRecipient("neha.mete@clarivate.com");
		emailDetails.setSubject("order is placed");
		String message =  "";
		emailDetails.setMsgBody(message);
		
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("FoodOrder deleted  sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(foodOrderDao.deletefoodOrder(id));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id) {
		Optional<FoodOrder> FoodOrder = foodOrderDao.getfoodOrderById(id);
		if (FoodOrder.isEmpty()) {
			throw new IdNotFoundException();

		} else {
			ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("FoodOrder Found sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(FoodOrder.get());
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<List<FoodOrder>>> findAllFoodOrder() {
		ResponseStructure<List<FoodOrder>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("List of admins Found sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(foodOrderDao.findAllfoodOrders());
		return new ResponseEntity<ResponseStructure<List<FoodOrder>>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodOrder, int id) {
		FoodOrder newFoodOrder = foodOrderDao.updatefoodOrder(foodOrder, id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();

		if (newFoodOrder != null) {
			responseStructure.setMessage("FoodOrder Updated sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(newFoodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("Invalid Id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setT(null);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.NOT_FOUND);

		}

	}
}
