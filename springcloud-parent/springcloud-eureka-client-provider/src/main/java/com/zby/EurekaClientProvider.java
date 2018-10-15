package com.zby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient // 这个注解没有意义，可能是加着好看吧，WTF
@SpringBootApplication
public class EurekaClientProvider {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientProvider.class, args);
	}
}
