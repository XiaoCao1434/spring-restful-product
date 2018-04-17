package com.beini.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.beini.product.entity.ProductBrand;

public interface ProductBrandRepository extends JpaRepository<ProductBrand, String>, JpaSpecificationExecutor<ProductBrand> {

}
