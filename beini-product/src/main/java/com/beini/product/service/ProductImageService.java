package com.beini.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.beini.product.entity.ProductImage;

public interface ProductImageService {
	
	/*查询*/
	Page<ProductImage> findAll(Pageable pageable);
	ProductImage findById(Integer id);
	/*更新*/
	ProductImage save(ProductImage bean);
	ProductImage update(ProductImage bean);
	void delete(Integer... id);
}
