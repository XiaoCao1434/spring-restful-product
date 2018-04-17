package com.beini.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.beini.product.entity.Product;

public interface ProductRepository extends JpaSpecificationExecutor<Product>, JpaRepository<Product, String> {

}
