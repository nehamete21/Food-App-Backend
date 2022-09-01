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

import com.cl.FoodApp.dto.Menu;
import com.cl.FoodApp.service.MenuService;
import com.cl.FoodApp.utils.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class MenuController {
	@Autowired 
	MenuService MenuService;
	
	@PostMapping("/saveMenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu Menu) {
		return MenuService.saveMenu(Menu);
	}
	
	@PutMapping("/updateMenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestBody Menu Menu,@RequestParam int id) {
		return MenuService.updateMenu(Menu, id); 
	}
	
	@DeleteMapping("/deleteMenu")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@RequestParam int id) {
	    return MenuService.deleteMenu(id);	
	}
	
	@GetMapping("/getbyidmenu/{id}")
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@PathVariable int id) {
		return MenuService.getMenuById(id);
	}
	
	@GetMapping("/findallMenu")
	public ResponseEntity<ResponseStructure<List<Menu>>> findAllMenu(){
		return MenuService.findAllMenu();
	}
}
