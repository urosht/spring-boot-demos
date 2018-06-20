package com.urosht.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.urosht.entity.Cat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CatRepositoryTests {

	@Autowired
	private CatRepository repository;
	

	@Test
	public void getByName_returnCatWithGivenName() {
		String expected = "rufus";
		
		Cat actual = repository.findByName(expected);
		
		assertNotNull(actual);
		assertEquals(expected, actual.getName());
	}
	
}
