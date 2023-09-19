package com.thy.banhang.service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.thy.banhang.entity.Product;
import com.thy.banhang.entity.ProductCategory;
import com.thy.banhang.repository.ProductCategoryRepository;
import com.thy.banhang.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	public List<Product> getAllList(){
		return productRepository.findAll();
	}
	
	public List<Product> getAllListPage(int page){
		Page<Product> pageProduct = productRepository.findAll(PageRequest.of(page-1, 15));
		List<Product> products = pageProduct.toList();
		return products;
	}
	
	public void insertMatHang(Product matHang) {
		productRepository.save(matHang);
	}
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public void updateMatHang(Product matHang) {
		productRepository.save(matHang);
	}
	public void deleteMatHang(Long id) {
		productRepository.deleteById(id);
	}
	
	public List<Product> getProductFindByCategory(String maLoai){
		return productRepository.findByProductCategoryMaLoai(maLoai);
	}
	
	public List<Product> getProductListPageFindByCategory(String maLoai,int page){
		return productRepository.findByProductCategoryMaLoai(maLoai, PageRequest.of(page-1, 15));
	}
	
	public List<Product> searchProductListPageByName(String searchString,int page){
		String tenMH = URLDecoder.decode(searchString, StandardCharsets.UTF_8);
		return productRepository.findAllByTenMHContainingIgnoreCase(tenMH, PageRequest.of(page-1, 15));
	}
	
	public List<Product> searchProductByName(String searchString){
		String tenMH = URLDecoder.decode(searchString, StandardCharsets.UTF_8);
		return productRepository.findAllByTenMHContainingIgnoreCase(tenMH);
	}
	
	public void addProduct(String maLoai,Product product) {
		ProductCategory productCategory = productCategoryRepository.findById(maLoai).orElse(null);
		product.setProductCategory(productCategory);
		productRepository.save(product);
	}
	
	public void updateProduct(String maLoai,Long maMH,Product product) {
		Product updateProduct = productRepository.findById(maMH).orElse(null);
		ProductCategory productCategory = productCategoryRepository.findById(maLoai).orElse(null);
		updateProduct.setGia(product.getGia());
		updateProduct.setHangSanXuat(product.getHangSanXuat());
		updateProduct.setImage(product.getImage());
		updateProduct.setProductCategory(productCategory);
		updateProduct.setTenMH(product.getTenMH());
		updateProduct.setXuatXu(product.getXuatXu());
		updateProduct.setSoLuong(product.getSoLuong());
		productRepository.saveAndFlush(updateProduct);
	}
}
