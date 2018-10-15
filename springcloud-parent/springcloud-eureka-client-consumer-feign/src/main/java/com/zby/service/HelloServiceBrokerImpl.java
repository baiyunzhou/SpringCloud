package com.zby.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceBrokerImpl implements HelloService {

	@Override
	public String hello() {
		return "error";
	}

}
