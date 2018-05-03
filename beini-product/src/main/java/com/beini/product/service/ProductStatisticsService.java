package com.beini.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.beini.product.entity.ProductStatistics;

public interface ProductStatisticsService {
	
	/*查询*/
	Page<ProductStatistics> findAll(Pageable pageable);
	ProductStatistics findById(Integer id);
	/*更新*/
	ProductStatistics save(ProductStatistics bean);
	ProductStatistics update(ProductStatistics bean);
	void delete(Integer... id);
}
