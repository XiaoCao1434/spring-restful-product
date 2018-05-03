package com.beini.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.beini.product.entity.ProductAndAttribute;

/**
 * 商品与属性关联信息服务接口
 * 
 * @author lb_chen
 * @date 2018-04-18 16:34
 */
public interface ProductAndAttributeService {

	/* 查询 */
	Page<ProductAndAttribute> findAll(Pageable pageable);

	ProductAndAttribute findById(Integer id);

	/* 更新 */
	ProductAndAttribute save(ProductAndAttribute bean);

	ProductAndAttribute update(ProductAndAttribute bean);

	void delete(Integer... id);
}
