package com.urosht.provider.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.urosht.provider.ContractProviderApplication;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractProviderApplication.class)
public abstract class BaseClass {

	@Autowired
	private HelloController controller;
	
	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(controller);
	}
}
