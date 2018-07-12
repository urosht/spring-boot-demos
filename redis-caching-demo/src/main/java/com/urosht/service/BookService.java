package com.urosht.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.urosht.domain.Book;
import com.urosht.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {

	private BookRepository repository;
	
	public BookService(BookRepository repository) {
		this.repository = repository;
	}

	@Cacheable(value = "books", key = "#id")
	public Book getBookById(String id) {
		log.info("Get Book from database with id {}...", id);
		return repository.findOne(id);
	}

	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<>();
		repository.findAll().forEach(list::add);
		return list;
	}

	@CacheEvict(value = "books", key = "#id")
	public void deleteBookById(String id) {
		repository.delete(id);
	}

}
