package com.gsgonc.junitMitMockito.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;

import com.gsgonc.junitMitMockito.model.Item;
import com.gsgonc.junitMitMockito.service.ItemBusinessService;


@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ItemBusinessService businessMock;
	
	@Test
	public void dummyItem_business_basic() throws Exception {
		
		when(businessMock.retrieveHardcodedItem()).thenReturn(
				new Item(2, "Item2", 50, 50));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item-from-business")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2, name:Item2, price:50, quantity:50}"))
				.andReturn();
	}
	
	@Test
	public void items_from_database() throws Exception {
		
		when(businessMock.retrieveAllItens()).thenReturn(
				Arrays.asList(new Item(1,"Item1", 10, 10),new Item(2,"Item2", 10, 10)));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/items-from-database")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:1, name:Item1, price:10, quantity:10}, {id:2, name:Item2, price:10, quantity:10}]"))
				.andReturn();
	}
	
}
