package com.gsgonc.junitMitMockito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gsgonc.junitMitMockito.model.Item;
import com.gsgonc.junitMitMockito.repository.ItemRepository;


@Component
public class ItemBusinessService {

	@Autowired
	private ItemRepository itemRepository;
	
	public Item retrieveHardcodedItem() {
		return new Item(1, "honey", 100, 1);
	}
	
	public List<Item> retrieveAllItens() {
		List<Item> items = itemRepository.findAll();
		for (Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}


}
