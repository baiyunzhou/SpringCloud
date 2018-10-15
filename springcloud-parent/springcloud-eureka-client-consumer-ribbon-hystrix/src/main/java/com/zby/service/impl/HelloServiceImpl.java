package com.zby.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zby.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	@Override
	public String hello() {
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}

	public String fallback() {
		return "error";
	}
}
