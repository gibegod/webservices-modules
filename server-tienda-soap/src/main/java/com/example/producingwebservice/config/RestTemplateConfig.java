package com.example.producingwebservice.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Value("${rest.template.connect.timeout}")
	private long connectTimeOut;
	@Value("${rest.template.read.timeout}")
	private long readTimeOut;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.setConnectTimeout(Duration.ofMillis(connectTimeOut))
				.setReadTimeout(Duration.ofMillis(readTimeOut)).build();
	}

}
