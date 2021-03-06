package com.example.demo.swaggerImpl;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;
import static springfox.documentation.builders.PathSelectors.regex;



@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	@Bean
	public Docket api() {
		// TODO Auto-generated method stub
		return new Docket(DocumentationType.SWAGGER_2)  
				.select()                                  
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))              
				.paths(regex("/api.*"))                          
				.build()
				.apiInfo(metaData());

	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
				"Spring Boot REST API",
				"Spring Boot REST API for Student Management",
				"1.0",
				"Terms of service",
				new Contact("Rupesh Kashyap", "https://swagger.io/docs/open-source-tools/swagger-ui/usage/configuration/", "rupeshkashyap1996@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
		return apiInfo;
	}

}
