package com.beini.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.beini.product.entity.ProductDescription;

public interface ProductDescriptionService {
	
	/*查询*/
	Page<ProductDescription> findAll(Pageable pageable);
	ProductDescription findById(Integer id);
	/*更新*/
	ProductDescription save(ProductDescription bean);
	ProductDescription update(ProductDescription bean);
	void delete(Integer... id);
}
