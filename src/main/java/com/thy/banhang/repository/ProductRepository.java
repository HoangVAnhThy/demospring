package com.thy.banhang.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thy.banhang.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByProductCategoryMaLoai(String maLoai);
	List<Product> findByProductCategoryMaLoai(String maLoai,Pageable pageable);
	List<Product> findAllByTenMHContainingIgnoreCase(String tenMH);
	List<Product> findAllByTenMHContainingIgnoreCase(String tenMH,Pageable pageable);
}
