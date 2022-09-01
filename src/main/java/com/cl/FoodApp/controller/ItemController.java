package com.cl.FoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cl.FoodApp.dto.Item;
import com.cl.FoodApp.service.ItemService;
import com.cl.FoodApp.utils.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ItemController {
	
	@Autowired 
	ItemService itemService;
	
	@PostMapping("/saveItem")
	public ResponseEntity<ResponseStructure<Item>> saveItem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}
	
	@PutMapping("/updateItem")
	public ResponseEntity<ResponseStructure<Item>> updateItem(@RequestBody Item Item ,@RequestParam int id) {
		return itemService.updateItem(Item,id); 
	}
	
	@DeleteMapping("/deleteItem")
	public ResponseEntity<ResponseStructure<Item>> deleteItem(@RequestParam int id) {
	    return itemService.deleteItem(id);	
	}
	
	
	@GetMapping("/getbyidItems/{id}")
	public ResponseEntity<ResponseStructure<Item>> getItemById(@PathVariable int id) {
		return itemService.getItemById(id);
	}
	
	@GetMapping("/findallItem")
	public ResponseEntity<ResponseStructure<List<Item>>> findAllItem(){
		return itemService.findAllItem();
	}
}


