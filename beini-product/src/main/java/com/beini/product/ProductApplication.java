package com.beini.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
/*1.feign的启用（必须）,feign默认是启用hystrix*/
@EnableFeignClients
/*1.Hystrix的启用（必须）*/
/*@EnableCircuitBreaker*/
@EnableSwagger2
//@MapperScan("com.beini.product.mapper")
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}
