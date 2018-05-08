package com.zby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZookeeperHelloController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/serviceUrl")
	public String serviceUrl() {
		List<ServiceInstance> list = discoveryClient.getInstances("zk-discoveryclient");
		if (list != null && list.size() > 0) {
			return list.get(0).getUri().toString();
		}
		return null;
	}

	@RequestMapping("/zk")
	public String hello() {
		return "Hello,Zookeeper!";
	}
}
