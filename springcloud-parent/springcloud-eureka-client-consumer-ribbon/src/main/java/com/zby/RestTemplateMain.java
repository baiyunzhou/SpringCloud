package com.zby;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateMain {

	public static void main(String[] args) {
		// 模拟HTTP GET请求
		RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:1314/hello?name={1}",
		//		String.class, "zby");
		//restTemplate.postForLocation(url, request, uriVariables);
		ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/shutdown", null,
				String.class);
		System.out.println(responseEntity);
	}

}
