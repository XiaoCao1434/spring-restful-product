package com.beini.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.beini.product.entity.ProductDescription;
import com.beini.product.repository.ProductDescriptionRepository;
import com.beini.product.service.ProductDescriptionService;
@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {
	@Autowired
	private ProductDescriptionRepository repository;
	@Override
	public Page<ProductDescription> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public ProductDescription findById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public ProductDescription save(ProductDescription bean) {
		return repository.save(bean);
	}

	@Override
	public ProductDescription update(ProductDescription bean) {
		return repository.save(bean);
	}

	@Override
	public void delete(Integer... id) {
		try {
			for(Integer str:id) {
				repository.delete(str);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
