package com.zby.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String hello() {
		ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
		LOG.info("/hello,hello:{},serviceId:{}", serviceInstance.getHost(), serviceInstance.getServiceId());
		return "Hello,World!";
	}
}
