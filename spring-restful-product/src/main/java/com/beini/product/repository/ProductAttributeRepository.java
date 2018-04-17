package com.beini.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.beini.product.entity.ProductAttribute;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, String>, JpaSpecificationExecutor<ProductAttribute> {

}
