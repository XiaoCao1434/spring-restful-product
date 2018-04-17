package com.beini.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.beini.product.entity.ProductAndAttribute;

public interface ProductAndAttributeRepository extends JpaRepository<ProductAndAttribute, Integer>, JpaSpecificationExecutor<ProductAndAttribute> {

}
