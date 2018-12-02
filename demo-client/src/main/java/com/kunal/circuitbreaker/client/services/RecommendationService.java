package com.kunal.circuitbreaker.client.services;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@Service
public class RecommendationService {
	private final RestTemplate restTemplate;

	public RecommendationService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(fallbackMethod = "reliable",
			  commandProperties = {
				       @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
				       @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="60")
				    }
			
			)
	public String readingList() {
		URI uri = URI.create("http://localhost:8090/recommended");

		return this.restTemplate.getForObject(uri, String.class);
	}

	public String reliable() {
		return "Cloud Native Java (O'Reilly)";
	}

}
