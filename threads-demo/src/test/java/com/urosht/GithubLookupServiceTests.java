package com.urosht;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import com.urosht.service.GithubLookupService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubLookupServiceTests {

	@Autowired
	private GithubLookupService testClass;
	@MockBean
	private RestTemplateBuilder builder;
	
	@Before
	public void setup() {
		this.testClass = new GithubLookupService(builder);
	}
	
	@Test
	public void givenValidArgs_whenAPIGetsCalled_thenReturnResults() {
		
		// TODO
		
	}
}
