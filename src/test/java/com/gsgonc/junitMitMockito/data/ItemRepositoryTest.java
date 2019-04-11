package com.gsgonc.junitMitMockito.data;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gsgonc.junitMitMockito.model.Item;
import com.gsgonc.junitMitMockito.repository.ItemRepository;


@RunWith(SpringRunner.class)
@DataJpaTest //Get data from in memory database
public class ItemRepositoryTest {

	@Autowired
	ItemRepository repository;
	
	@Test
	public void testFindAll() {
		List<Item> items = repository.findAll();
		assertEquals(3, items.size());
	}

}
