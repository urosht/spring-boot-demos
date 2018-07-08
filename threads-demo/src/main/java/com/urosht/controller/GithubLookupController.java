package com.urosht.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urosht.dto.User;
import com.urosht.service.GithubLookupService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GithubLookupController {

	private GithubLookupService service;
	
	public GithubLookupController(GithubLookupService service) {
		this.service = service;
	}
	
	
	@GetMapping("/lookupUsers")
	public String lookupUsers() throws Exception {
		
		long start = System.currentTimeMillis();
		
		
			CompletableFuture<User> page1 = service.findUser("PivotalSoftware");
			CompletableFuture<User> page2 = service.findUser("CloudFoundry");
			CompletableFuture<User> page3 = service.findUser("Spring-Projects");
		
		
		CompletableFuture.allOf(page1, page2, page3).join();
		log.info("--> {}", page1.get());
		log.info("--> {}", page2.get());
		log.info("--> {}", page2.get());
		return "Elapsed time: " + (System.currentTimeMillis() - start);
	}
}
