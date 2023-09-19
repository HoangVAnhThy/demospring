package com.thy.banhang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thy.banhang.entity.ProductCategory;
import com.thy.banhang.repository.ProductCategoryRepository;


@Service
public class ProductCategoryService {
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	public List<ProductCategory> getAllCategories(){
		return productCategoryRepository.findAll();
	}
}
