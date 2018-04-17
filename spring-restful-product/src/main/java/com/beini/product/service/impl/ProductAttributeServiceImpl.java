package com.beini.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.beini.product.entity.ProductAttribute;
import com.beini.product.repository.ProductAttributeRepository;
import com.beini.product.service.ProductAttributeService;
@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {
	@Autowired
	private ProductAttributeRepository repository;
	@Override
	public Page<ProductAttribute> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public ProductAttribute findById(String id) {
		return repository.findOne(id);
	}

	@Override
	public ProductAttribute save(ProductAttribute bean) {
		return repository.save(bean);
	}

	@Override
	public ProductAttribute update(ProductAttribute bean) {
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
}
