package com.urosht.controller;

import static org.mockito.Matchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.urosht.domain.Book;
import com.urosht.service.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTests {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BookService service;
	
	@Test
	public void givenNameParameter_whenEndpointIsCalled_thenReturnBook() throws Exception {
		
		Book expected = Book.builder().title("Clean Code").author("Robert C Martin").build();
		BDDMockito.given(service.getBookById(anyString())).willReturn(expected);
				
		int id = 1;
		mockMvc.perform(get("/book/" + id))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.title").value(expected.getTitle()))
			.andExpect(jsonPath("$.author").value(expected.getAuthor()));
	}
	
}
