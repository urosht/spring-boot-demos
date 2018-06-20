package com.urosht.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.urosht.entity.Cat;
import com.urosht.repository.CatRepository;

@RunWith(MockitoJUnitRunner.class)
public class CatServiceTests {

	@Mock
	private CatRepository repository;
	
	private CatService service;

	@Before
	public void setup() {	
		this.service = new CatService(repository);
	}
	
	@Test
	public void getCatByName_returnCat() {
		// arrange
		String name = "rufus";
		String color = "blue";
		when(repository.findByName(name)).thenReturn(Cat.builder().name(name).color(color).build());
		// act
		Cat cat = service.getCatByName(name);
		// assert
		assertTrue(cat.getColor().equals("blue"));
	}
}
