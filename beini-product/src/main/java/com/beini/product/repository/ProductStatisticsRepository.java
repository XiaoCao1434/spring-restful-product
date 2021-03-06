package com.beini.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.beini.product.entity.ProductStatistics;

public interface ProductStatisticsRepository extends JpaRepository<ProductStatistics, Integer>, JpaSpecificationExecutor<ProductStatistics> {

}
