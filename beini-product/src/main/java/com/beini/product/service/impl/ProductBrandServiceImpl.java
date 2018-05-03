package com.beini.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.beini.core.enums.KeyPrefixEnum;
import com.beini.core.utils.KeyUtil;
import com.beini.product.entity.ProductBrand;
import com.beini.product.repository.ProductBrandRepository;
import com.beini.product.service.ProductBrandService;
@Service
public class ProductBrandServiceImpl implements ProductBrandService {
	@Autowired
	private ProductBrandRepository repository;
	@Override
	public Page<ProductBrand> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public ProductBrand findById(String id) {
		return repository.findOne(id);
	}

	@Override
	public ProductBrand save(ProductBrand bean) {
		bean.setPbUuid(KeyUtil.genUniqueKey(KeyPrefixEnum.PRODUCT_BRAND));
		return repository.save(bean);
	}

	@Override
	public ProductBrand update(ProductBrand bean) {
		return repository.save(bean);
	}

	@Override
	public void delete(String... id) {
		try {
			for(String str:id) {
				repository.delete(str);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Page<ProductBrand> findAllByPcUuid(String pcUuid, Pageable pageable) {
		return repository.findAllByPcUuid(pcUuid,pageable);
	}
}
