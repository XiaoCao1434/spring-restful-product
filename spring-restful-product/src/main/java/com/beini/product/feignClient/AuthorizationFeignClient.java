package com.beini.product.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*2.feign的声明（必须）*/
@FeignClient(name="authorization")
public interface AuthorizationFeignClient {
	/*3.feign的接口声明（必须），其中请求参数中的ID也必须使用@RequestParam或者RequestBody来使用*/
	@GetMapping("/user/getOne")
	public String getOne(@RequestParam("id")String id);
}
