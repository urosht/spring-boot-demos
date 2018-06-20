package com.urosht.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.urosht.entity.Cat;
import com.urosht.service.CatService;

@RunWith(SpringRunner.class)
@WebMvcTest(CatController.class)
public class CatControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CatService service;
	
	@Test
	public void whenGetEndpoint_returnCatResponse() throws Exception {
		
		String name = "rufus";
		String color = "blue";
		
		when(service.getCatByName(name)).thenReturn(Cat.builder()
				.name(name)
				.color(color)
				.build());
		
		mockMvc.perform(get("/get").param("name", name)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("rufus"))
				.andExpect(jsonPath("$.color").value("blue"));
	}
}
