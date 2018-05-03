package com.beini.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.beini.product.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaSpecificationExecutor<ProductCategory>,JpaRepository<ProductCategory, String>{

}
