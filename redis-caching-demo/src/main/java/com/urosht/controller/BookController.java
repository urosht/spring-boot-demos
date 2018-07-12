package com.urosht.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urosht.domain.Book;
import com.urosht.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {

	private BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable String id) {
		log.info("Handle request - get book with id {}", id);
		return service.getBookById(id);
	}
	
	@GetMapping("/all")
	public List<Book> getAllBooks() {
		log.info("Handle request - get all books");
		return service.getAllBooks();
	}
	
	@DeleteMapping("/{id}")
	public void deleteBookById(@PathVariable String id) {
		log.info("Handle request - delete book with id {}", id);
		service.deleteBookById(id);
	}
}
