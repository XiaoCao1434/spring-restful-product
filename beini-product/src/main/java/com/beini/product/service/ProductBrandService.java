package com.beini.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.beini.product.entity.ProductBrand;
/**
 * 商品类目服务接口
 * @author lb_chen
 *
 */
public interface ProductBrandService {
	/*查询*/
	Page<ProductBrand> findAll(Pageable pageable);
	ProductBrand findById(String id);
	/*更新*/
	ProductBrand save(ProductBrand bean);
	ProductBrand update(ProductBrand bean);
	void delete(String... id);
	/**
	 * 通过商品类别ID查询商品类目分页信息
	 * @param pcUuid 商品类别ID
	 * @param pageable 商品类目分页属性
	 * @return 商品类目分页信息
	 */
	Page<ProductBrand> findAllByPcUuid(String pcUuid,Pageable pageable);
}
