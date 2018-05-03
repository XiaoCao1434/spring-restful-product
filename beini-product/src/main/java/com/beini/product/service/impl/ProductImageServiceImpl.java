package com.beini.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.beini.product.entity.ProductImage;
import com.beini.product.repository.ProductImageRepository;
import com.beini.product.service.ProductImageService;
@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Autowired
	private ProductImageRepository repository;

	@Override
	public Page<ProductImage> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public ProductImage findById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public ProductImage save(ProductImage bean) {
		return repository.save(bean);
	}

	@Override
	public ProductImage update(ProductImage bean) {
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
