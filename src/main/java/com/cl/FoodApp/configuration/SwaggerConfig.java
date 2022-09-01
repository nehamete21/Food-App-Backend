package com.cl.FoodApp.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
   
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select().paths(PathSelectors.any()).build();
	}

	private ApiInfo getInfo() {
		return new ApiInfo("Food App Apllication : Backend Appication","Developed by neha mete","1.0","Terms of service", new Contact("neha", "http://foodApp.com", "nehamete21@gmail.com"),"Licence of api", "Api url", Collections.emptyList());
	}
}
