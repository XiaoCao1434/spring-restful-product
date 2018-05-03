package com.beini.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.beini.product.entity.ProductBrand;

public interface ProductBrandRepository extends JpaRepository<ProductBrand, String>, JpaSpecificationExecutor<ProductBrand> {
	@Query(value="select pb from ProductBrand pb where pcUuid=:pcUuid")
	Page<ProductBrand> findAllByPcUuid(@Param("pcUuid")String pcUuid, Pageable pageable);
}
