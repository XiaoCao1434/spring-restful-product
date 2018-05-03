package com.beini.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.beini.product.entity.ProductSpecification;

public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, String>, JpaSpecificationExecutor<ProductSpecification> {

}
