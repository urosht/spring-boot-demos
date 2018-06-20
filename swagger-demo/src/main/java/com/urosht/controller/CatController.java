package com.urosht.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urosht.entity.Cat;
import com.urosht.service.CatService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CatController {

	private CatService service;
	
	public CatController(CatService service) {
		this.service = service;
	}
	
	@GetMapping(value ="/get", produces = MediaType.APPLICATION_JSON_VALUE,
			params = {"name"})
	@ApiOperation(value = "Get Cat", notes = "Get a Cat by it's name")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Return a cat"),
		@ApiResponse(code = 500, message = "Cat not found")
	})
	public Cat get(@ApiParam("Cat name")@RequestParam String name) {
		return service.getCatByName(name);
	}
}
