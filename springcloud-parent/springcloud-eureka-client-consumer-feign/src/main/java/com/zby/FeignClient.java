package com.zby;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignClient {
	public static void main(String[] args) {
		// SpringApplication.run(FeignClient.class, args);
		new SpringApplicationBuilder(FeignClient.class).web(true).run(args);
	}
}
