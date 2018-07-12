package com.urosht.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.urosht.repository.BookRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTests {

	@Autowired
	private BookService service;
	@Mock
	private BookRepository repository;
	
	@Before
	public void setup() {
		this.service = new BookService(repository);
	}
	
	@Test
	public void givenId_whenDBIsCalled_returnBook() {
		
		
	}
	
}
