package com.beini.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.beini.product.entity.ProductAndAttribute;
import com.beini.product.repository.ProductAndAttributeRepository;
import com.beini.product.service.ProductAndAttributeService;

@Service
public class ProductAndAttributeServiceImpl implements ProductAndAttributeService {
	@Autowired
	private ProductAndAttributeRepository repository;

	@Override
	public Page<ProductAndAttribute> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public ProductAndAttribute findById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public ProductAndAttribute save(ProductAndAttribute bean) {
		return repository.save(bean);
	}

	@Override
	public ProductAndAttribute update(ProductAndAttribute bean) {
		return repository.save(bean);
	}

	@Override
	public void delete(Integer... id) {
		try {
			for(Integer key:id) {
				repository.delete(key);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
