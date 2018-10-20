package com.urosht.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractClientApplicationTests {

	@Rule
	public StubRunnerRule stubRunnerRule = new StubRunnerRule()
		.downloadStub("com.urosht", "contract-provider", "0.0.1-SNAPSHOT", "stubs")
		.withPort(8100)
		.stubsMode(StubRunnerProperties.StubsMode.LOCAL);

	@Test
	public void validate_when_endpoint_called_return_hello_contract() throws Exception {
		// given:
			RestTemplate restTemplate = new RestTemplate();

		// when:
			String response = restTemplate.getForObject("http://localhost:8100/hello", String.class);

		// then:
			assertThat(response).isEqualTo("Hello World");
	}
	
}
