package com.urosht.integration;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.urosht.SwaggerDemoApplication;
import com.urosht.entity.Cat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SwaggerDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationsTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void getCatWithName_returnCat() {
		
		ResponseEntity<Cat> response = restTemplate.exchange("/cats/get?name={name}", HttpMethod.GET, null, Cat.class, "rufus");
		Cat cat = response.getBody();
		
		assertThat(response.getStatusCode().is2xxSuccessful());
		assertEquals("rufus", cat.getName());
		
	}
}
