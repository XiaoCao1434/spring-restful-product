package com.beini.springrestfulproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beini.springrestfulproduct.feignClient.AuthorizationFeignClient;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private AuthorizationFeignClient authorizationFeignClient;

	@GetMapping("/getOne")
	public String getProduct(String uid) {
		System.out.println("获取商品的 UID :" + uid);
		String userInfo = authorizationFeignClient.getOne(uid);
		System.out.println("userInfo : " + userInfo);
		return userInfo;
	}
}
