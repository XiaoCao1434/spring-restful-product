package com.beini.product.mapper;

import com.beini.product.entity.Product;

public interface ProductMapper {
	Product findById(String id);
	/*更新*/
	int save(Product bean);
	int update(Product bean);
	int delete(String... id);
}
