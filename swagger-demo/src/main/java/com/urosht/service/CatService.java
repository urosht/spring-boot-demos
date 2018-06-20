package com.urosht.service;

import org.springframework.stereotype.Service;

import com.urosht.entity.Cat;
import com.urosht.repository.CatRepository;

@Service
public class CatService {

	private CatRepository repository;
	
	public CatService(CatRepository repository) {
		this.repository = repository;
	}
	
	public Cat getCatByName(String name) {
		return repository.findByName(name);
	}

}
