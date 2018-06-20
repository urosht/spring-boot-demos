package com.urosht.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.urosht.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	@Bean ApiInfo apiInfo() {
		return new ApiInfo("Demo Cat App", 
				"This app has cats and turns cats into json strings", 
				"0.0.1-SNAPSHOT", 
				"http://termsofservice.cat", 
				"Simba The Lion King", 
				"Jungle licence", "http://licence-url.com");
	}
}
