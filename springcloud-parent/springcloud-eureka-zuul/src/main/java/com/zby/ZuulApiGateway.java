package com.zby;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApiGateway {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApiGateway.class).run(args);
	}
}
