package com.beini.product.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.beini.product.entity.Product;

public interface ProductRepository extends JpaSpecificationExecutor<Product>, JpaRepository<Product, String> {
	@Transactional
	@Modifying
	@Query(nativeQuery=true,value="update product set stock=stock-:stock where pro_uuid=:proUuid and stock-:stock>=0")
	Integer updateStock(@Param("proUuid")String proUuid,@Param("stock") double stock);
}
