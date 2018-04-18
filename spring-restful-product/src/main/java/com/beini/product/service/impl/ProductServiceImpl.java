package com.beini.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.beini.core.enums.KeyPrefixEnum;
import com.beini.core.utils.KeyUtil;
import com.beini.product.entity.Product;
import com.beini.product.repository.ProductRepository;
import com.beini.product.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repository;
	@Override
	public Page<Product> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Product findById(String id) {
		return repository.findOne(id);
	}

	@Override
	public Product save(Product bean) {
		bean.setProUuid(KeyUtil.genUniqueKey(KeyPrefixEnum.PRODUCT));
		return repository.save(bean);
	}

	@Override
	public Product update(Product bean) {
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
