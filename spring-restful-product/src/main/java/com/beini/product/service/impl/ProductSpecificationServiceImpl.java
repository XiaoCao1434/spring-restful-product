package com.beini.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.beini.product.entity.ProductSpecification;
import com.beini.product.repository.ProductSpecificationRepository;
import com.beini.product.service.ProductSpecificationService;
@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {
	@Autowired
	private ProductSpecificationRepository repository;
	@Override
	public Page<ProductSpecification> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public ProductSpecification findById(String id) {
		return repository.findOne(id);
	}

	@Override
	public ProductSpecification save(ProductSpecification bean) {
		return repository.save(bean);
	}

	@Override
	public ProductSpecification update(ProductSpecification bean) {
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
