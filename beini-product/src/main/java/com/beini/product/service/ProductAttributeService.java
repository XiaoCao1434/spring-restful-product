package com.beini.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.beini.product.entity.ProductAttribute;

public interface ProductAttributeService {
	/*查询*/
	Page<ProductAttribute> findAll(Pageable pageable);
	ProductAttribute findById(String id);
	/*更新*/
	ProductAttribute save(ProductAttribute bean);
	ProductAttribute update(ProductAttribute bean);
	void delete(String... id);
}
