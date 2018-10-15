package com.zby.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "hello-service", fallback = HelloServiceBrokerImpl.class)
public interface HelloService {
	@RequestMapping(path = "/hello")
	String hello();
}
