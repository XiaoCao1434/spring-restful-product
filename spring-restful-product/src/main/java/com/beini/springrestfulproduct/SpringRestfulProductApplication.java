package com.beini.springrestfulproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
/*1.feign的启用（必须）*/
@EnableFeignClients
/*1.Hystrix的启用（必须）*/
@EnableCircuitBreaker
public class SpringRestfulProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestfulProductApplication.class, args);
	}
}
