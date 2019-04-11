package com.gsgonc.junitMitMockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsgonc.junitMitMockito.model.Item;
import com.gsgonc.junitMitMockito.service.ItemBusinessService;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService itemService;
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "honey", 100, 1);
	}
	
	@GetMapping("/dummy-item-from-business")
	public Item dummyItemFromBusiness() {
		return itemService.retrieveHardcodedItem();
	}	
	
	@GetMapping("/items-from-database")
	public List<Item> itemsFromDatabase() {
		return itemService.retrieveAllItens();
	}
}
