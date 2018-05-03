package com.beini.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.beini.product.entity.ProductCategory;

public interface ProductCategoryRepository
		extends JpaSpecificationExecutor<ProductCategory>, JpaRepository<ProductCategory, String> {
	@Query("select pc from ProductCategory pc where pcPpuid=:pid")
	Page<ProductCategory> findPageByPcPpuid(@Param("pid") String pid, Pageable request);

}
