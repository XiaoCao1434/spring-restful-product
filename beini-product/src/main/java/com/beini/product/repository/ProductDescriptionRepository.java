package com.beini.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.beini.product.entity.ProductDescription;

public interface ProductDescriptionRepository extends JpaRepository<ProductDescription, Integer>, JpaSpecificationExecutor<ProductDescription> {

}
