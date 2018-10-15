package com.zby;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 
 * @author zby
 * @description 这是一个大坑，使用这个类名会报错，留在这儿警醒世人吧
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignClient {

	public static void main(String[] args) {
		// SpringApplication.run(FeignClient.class, args);
		new SpringApplicationBuilder(FeignClient.class).web(true).run(args);
	}
}
