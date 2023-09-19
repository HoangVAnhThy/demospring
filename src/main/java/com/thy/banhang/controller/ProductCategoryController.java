package com.thy.banhang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thy.banhang.entity.ProductCategory;
import com.thy.banhang.service.ProductCategoryService;

@RestController
public class ProductCategoryController {
	@Autowired
	ProductCategoryService productCategoryService;
	
	@CrossOrigin
	@GetMapping("/product-category")
	public List<ProductCategory> getCategories(){
		List<ProductCategory> productCategories = productCategoryService.getAllCategories();
		return productCategories;
	}
	

}
