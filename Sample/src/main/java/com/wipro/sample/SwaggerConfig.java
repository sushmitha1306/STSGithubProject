package com.wipro.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 ApiInfo apiInfo = new ApiInfo(
             "Products List Swagger Integration",
             "Spring Boot REST API for Products",
             "1.0",
             "Terms of service",
             new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"),
            "Apache License Version 2.0",
             "https://www.apache.org/licenses/LICENSE-2.0");
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()       
	                .apis(RequestHandlerSelectors.basePackage("com.wipro.Sample"))
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(apiInfo);
	    }
	 
}
