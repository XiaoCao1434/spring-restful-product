package com.beini.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	
	/**
	 * 根据父ID和分页信息获取所属父商品类别的类别分页信息
	 * @param pid 父ID
	 * @param request 分页信息
	 * @return 所属父商品类别的类别分页信息
	 */
	Page<ProductCategory> findPageByPcPpuid(String pid, PageRequest request);
}
