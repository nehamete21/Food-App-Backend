package com.cl.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.FoodApp.dto.Item;
import com.cl.FoodApp.repositary.ItemRepositary;

@Repository
public class ItemDAO {

	@Autowired
	private ItemRepositary itemRepositary;

	public Item saveItem(Item item) {
		return itemRepositary.save(item);
	}

	// update
	public Item updateItem(Item item, int id) {
		item.setId(id);
		return itemRepositary.save(item);
	}

	// delete
	public Item deleteItem(int id) {
		Item item = getItemById(id).get();
		itemRepositary.delete(item);
		return item;
	}

	// getById
	public Optional<Item> getItemById(int id) {

		return itemRepositary.findById(id);
	}

	// list of all Items
	public List<Item> findAllItem() {
		return itemRepositary.findAll();
	}
}
