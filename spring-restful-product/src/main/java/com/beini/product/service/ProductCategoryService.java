package com.beini.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.beini.product.entity.ProductCategory;

public interface ProductCategoryService {
	
	/*查询*/
	Page<ProductCategory> findAll(Pageable pageable);
	ProductCategory findById(String id);
	/*更新*/
	ProductCategory save(ProductCategory bean);
	ProductCategory update(ProductCategory bean);
	void delete(String... id);
}
