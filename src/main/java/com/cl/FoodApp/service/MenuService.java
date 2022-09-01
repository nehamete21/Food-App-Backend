package com.cl.FoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.FoodApp.dao.MenuDAO;
import com.cl.FoodApp.dto.Menu;
import com.cl.FoodApp.exception.IdNotFoundException;
import com.cl.FoodApp.utils.ResponseStructure;
@Service
public class MenuService {
	@Autowired
	MenuDAO menuDao;
	
	public ResponseEntity<ResponseStructure<Menu>>  saveMenu(Menu menu) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Menu saved sucessfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setT(menuDao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Menu>>  deleteMenu(int id) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Menu deleted  sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(menuDao.deleteMenu(id));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<Menu>>  getMenuById( int id) {
		Optional<Menu> Menu = menuDao.getMenuById(id);
		if (Menu.isEmpty()) {
			throw new IdNotFoundException();

		} else {
			ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Menu Found sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(Menu.get());
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);		
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<Menu>>> findAllMenu(){
		ResponseStructure<List<Menu>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("List of admins Found sucessfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setT(menuDao.findAllMenu());
		return new ResponseEntity<ResponseStructure<List<Menu>>>(responseStructure,HttpStatus.OK);		
	}
	
	public ResponseEntity<ResponseStructure<Menu>>  updateMenu(Menu menu, int id) {
		
		Menu newMenu =menuDao.updateMenu(menu, id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();

		if(newMenu != null) {
			responseStructure.setMessage("Menu Updated sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setT(newMenu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
			}
		else {
			responseStructure.setMessage("Invalid Id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setT(null);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.NOT_FOUND);
			
			}	
		
}
	
}
