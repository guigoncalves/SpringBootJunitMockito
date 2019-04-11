package com.gsgonc.junitMitMockito.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.gsgonc.junitMitMockito.model.Item;
import com.gsgonc.junitMitMockito.repository.ItemRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService business;
	
	@Mock
	private ItemRepository repository;
	
	@Test
	public void calculateSumDataService_basic() {
		when(repository.findAll()).thenReturn(Arrays.asList(
				new Item(1, "Item1", 10, 10), 
				new Item(2, "Item2", 15, 10)));
		List<Item> items = business.retrieveAllItens();
		assertEquals(100,items.get(0).getValue());
		assertEquals(150,items.get(1).getValue());		
	}
}
