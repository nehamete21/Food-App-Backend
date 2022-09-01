package com.cl.FoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.FoodApp.dao.ItemDAO;
import com.cl.FoodApp.dto.Item;
import com.cl.FoodApp.exception.IdNotFoundException;
import com.cl.FoodApp.utils.ResponseStructure;

@Service
public class ItemService {
	@Autowired
	ItemDAO ItemDao;
	
	public  ResponseEntity<ResponseStructure<Item>> saveItem(Item item) {
		ResponseStructure<Item> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Item saved sucessfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setT(ItemDao.saveItem(item));
		return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.CREATED);
	}
	
	public  ResponseEntity<ResponseStructure<Item>> deleteItem(int id) {
		ResponseStructure<Item> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Item deleted  sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(ItemDao.deleteItem(id));
		return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.OK);
	}
	
	
	public  ResponseEntity<ResponseStructure<Item>> getItemById( int id) {
		Optional<Item> item = ItemDao.getItemById(id);
		if (item.isEmpty()) {
			throw new IdNotFoundException();

		} else {
			ResponseStructure<Item> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Item Found sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(item.get());
			return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.OK);		
		}	}
	
	
	public ResponseEntity<ResponseStructure<List<Item>>> findAllItem(){
		ResponseStructure<List<Item>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("List of admins Found sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(ItemDao.findAllItem());
		return new ResponseEntity<ResponseStructure<List<Item>>>(responseStructure,HttpStatus.OK);		
	}
	
	public  ResponseEntity<ResponseStructure<Item>> updateItem(Item item, int id) {
		Item newItem =ItemDao.updateItem(item, id);
		ResponseStructure<Item> responseStructure = new ResponseStructure<>();

		if(newItem != null) {
			responseStructure.setMessage("Item Updated sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(newItem);
			return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.OK);
			}
		else {
			responseStructure.setMessage("Invalid Id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setT(null);
			return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.NOT_FOUND);
			
			}	
		
}
	
}
