package com.urosht.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.urosht.dto.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GithubLookupService {

	private RestTemplate restTemplate;
	
	public GithubLookupService(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	@Async
	public CompletableFuture<User> findUser(String user) throws InterruptedException {
		 
		log.info("Looking up {}", user);
		String url = String.format("https://api.github.com/users/%s", user);
		User response = restTemplate.getForObject(url, User.class);
		// Artificial delay
		Thread.sleep(1000L);
		return CompletableFuture.completedFuture(response);
	}
}
