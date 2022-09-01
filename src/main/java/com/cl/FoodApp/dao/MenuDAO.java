package com.cl.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.cl.FoodApp.dto.Menu;
import com.cl.FoodApp.repositary.MenuRepositary;

@Repository
public class MenuDAO {
	@Autowired
	private MenuRepositary menuRepositary;

	public Menu saveMenu(@RequestBody Menu menu) {
		return menuRepositary.save(menu);
	}

	// update
	public Menu updateMenu(Menu menu , int id) {
		menu.setId(id);
		return menuRepositary.save(menu);	}

	// delete
	public Menu deleteMenu(int id) {
		Menu menu = getMenuById(id).get();
		menuRepositary.delete(menu);
		return menu;
	}

	// getById
	public Optional<Menu> getMenuById(int id) {

		return menuRepositary.findById(id);
	}

	// list of all Menus
	public List<Menu> findAllMenu() {
		return menuRepositary.findAll();
	}
}
