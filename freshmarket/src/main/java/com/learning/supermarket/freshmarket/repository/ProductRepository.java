package com.learning.supermarket.freshmarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.supermarket.freshmarket.entity.UpComingProducts;

@Repository
public interface ProductRepository extends JpaRepository<UpComingProducts, Long>{

	List<UpComingProducts> findByStatus(String string);
	
	UpComingProducts findByProductCode(String productCode);

}
