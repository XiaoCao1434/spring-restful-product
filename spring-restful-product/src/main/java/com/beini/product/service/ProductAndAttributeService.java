package com.beini.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.beini.product.entity.ProductAndAttribute;

public interface ProductAndAttributeService {
	
	/*查询*/
	Page<ProductAndAttribute> findAll(Pageable pageable);
	ProductAndAttribute findById(Integer id);
	/*更新*/
	ProductAndAttribute save(ProductAndAttribute bean);
	ProductAndAttribute update(ProductAndAttribute bean);
	void delete(Integer... id);
}
