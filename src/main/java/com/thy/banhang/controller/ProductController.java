package com.thy.banhang.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thy.banhang.entity.Product;
import com.thy.banhang.repository.ProductRepository;
import com.thy.banhang.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@CrossOrigin
	@GetMapping("")
	public List<Product> getAll(){
		List<Product> products = productService.getAllList();
		return products;
	}
	
	@CrossOrigin
	@GetMapping("/category/{maLoai}")
	public List<Product> getProductFindByCategory(@PathVariable(name="maLoai") String maLoai){
		List<Product> products = productService.getProductFindByCategory(maLoai);
		return products;
	}
	
	@CrossOrigin
	@GetMapping("/search")
	public List<Product> searchProducts(@RequestParam(name = "string") String searchString){
		return productService.searchProductByName(searchString);
	}
	
	@CrossOrigin
	@GetMapping("/page/{pageNumber}")
	public List<Product> getPageProductList(@PathVariable(name = "pageNumber")int page){
		return productService.getAllListPage(page);
	}
	
	@CrossOrigin
	@GetMapping("/category/{maLoai}/page/{pageNumber}")
	public List<Product> getProductListByCategory(
			@PathVariable(name = "maLoai") String maLoai,
			@PathVariable(name = "pageNumber") int page ){
		return productService.getProductListPageFindByCategory(maLoai, page);
	}
	
	@CrossOrigin
	@GetMapping("/search/page/{pageNumber}")
	public List<Product> getListPageSearchProducts(
			@RequestParam(name = "string") String searchString,
			@PathVariable(name = "pageNumber")int page){
		return productService.searchProductListPageByName(searchString, page);
	}
	
//	@CrossOrigin
//	@PostMapping("/product")
//	public MatHang create(@RequestBody MatHang matHang) {
//		matHangService.insertMatHang(matHang);
//		return matHang;
//	}
//	
	@CrossOrigin
	@GetMapping("/{maMH}")
	public Product getById(@PathVariable(name="maMH") Long maMH) {
		Product product = productService.getProductById(maMH);
		return product;
	}
	
	@CrossOrigin
	@PostMapping("/add/{maLoai}")
	public ResponseEntity<HttpStatus> addProduct(
			@PathVariable(name = "maLoai") String maLoai,
			@RequestBody Product product){
		productService.addProduct(maLoai, product);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/update/{maMH}/{maLoai}")
	public ResponseEntity<HttpStatus> updateProduct(
			@PathVariable(name = "maLoai") String maLoai,
			@PathVariable(name = "maMH") Long maMH,
			@RequestBody Product product){
		productService.updateProduct(maLoai, maMH, product);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{maMH}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable(name = "maMH") Long maMH){
		productService.deleteMatHang(maMH);
		return ResponseEntity.ok(HttpStatus.OK);
	}
//	
//	@CrossOrigin
//	@PutMapping("/product/{maMH}")
//	public ResponseEntity<MatHang> update(@PathVariable(name="maMH") String maMH,@RequestBody MatHang matHang) {
//		Optional<MatHang> getMatHangById = matHangService.getMatHangById(maMH);
//		MatHang updateMatHang = getMatHangById.orElse(null);
//		updateMatHang.setTenMH(matHang.getTenMH());
//		updateMatHang.setMaLoai(matHang.getMaLoai());
//		updateMatHang.setSoLuong(matHang.getSoLuong());
//		updateMatHang.setMoTa(matHang.getMoTa());
//		matHangService.updateMatHang(updateMatHang);
//		return ResponseEntity.ok(updateMatHang);
//	}
//	@CrossOrigin
//	@DeleteMapping("/products/{maMH}")
//	public ResponseEntity<HttpStatus> delete(@PathVariable(name="maMH") String maMH){
//		matHangService.deleteMatHang(maMH);
//		return ResponseEntity.ok(HttpStatus.OK);
//	}
}
