package com.kunal.circuitbreaker.client.democlient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kunal.circuitbreaker.client.services.RecommendationService;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
@ComponentScan("com.kunal.circuitbreaker")
public class DemoClientApplication {
	
	@Autowired
	RecommendationService recommendationService;

	 @Bean
	  public RestTemplate rest(RestTemplateBuilder builder) {
	    return builder.build();
	  }
	 
	public static void main(String[] args) {
		SpringApplication.run(DemoClientApplication.class, args);
	}
	
	@RequestMapping(value="/client-read-recommendation")
	public String readFromServer() {
//		RestTemplate restClient = new RestTemplate();
//		 URI uri = URI.create("http://localhost:8090/recommended");
	    return recommendationService.readingList();
	}
	
}
