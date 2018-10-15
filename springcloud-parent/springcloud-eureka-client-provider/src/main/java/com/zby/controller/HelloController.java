package com.zby.controller;

import java.util.List;

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

	@SuppressWarnings("deprecation")
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String hello() {
		LOG.info("discoveryClient：{}", discoveryClient);
		ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
		LOG.info("serviceInstance----->host:{},port:{},serviceId:{},uri:{},metaData:{},secure:{}",
				serviceInstance.getHost(), serviceInstance.getPort(), serviceInstance.getServiceId(),
				serviceInstance.getUri(), serviceInstance.getMetadata(), serviceInstance.isSecure());
		String description = discoveryClient.description();
		LOG.info("description：{}", description);
		List<String> serviceIdList = discoveryClient.getServices();
		LOG.info("serviceIds：{}", serviceIdList);
		LOG.info("All ServiceInstance：");
		for (String serviceId : serviceIdList) {
			LOG.info("----->serviceId：{}", serviceId);
			List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(serviceId);
			for (ServiceInstance serviceInstancei : serviceInstanceList) {
				LOG.info("----->serviceInstance----->host:{},port:{},serviceId:{},uri:{},metaData:{},secure:{}",
						serviceInstancei.getHost(), serviceInstancei.getPort(), serviceInstancei.getServiceId(),
						serviceInstancei.getUri(), serviceInstancei.getMetadata(), serviceInstancei.isSecure());

			}
		}
		return "Hello,World!";
	}
}
