package com.thy.banhang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thy.banhang.entity.Bill;
import com.thy.banhang.entity.BillDetail;
import com.thy.banhang.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	BillService billService;
	
	@CrossOrigin
	@PostMapping("/order/{username}/{maMH}/{soLuong}")
	public ResponseEntity<HttpStatus> createBill(
			@PathVariable(name = "username") String username,
			@RequestBody Bill bill,
			@PathVariable(name = "maMH")Long maMH,
			@PathVariable(name = "soLuong") int soLuong){
		billService.createBill(username,maMH,soLuong,bill);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/order/{username}/{maMH}/{soLuong}")
	public ResponseEntity<HttpStatus> addProductBill(
			@PathVariable(name = "maMH") Long maMH,
			@PathVariable(name = "soLuong")int soLuong,
			@PathVariable(name = "username")String username){
			billService.addProductToBill(maMH, soLuong, username);
			return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/order/{username}/{maMH}/{soLuong}/1")
	public ResponseEntity<HttpStatus> changeStatus(
			@PathVariable(name = "username")String username,
			@RequestBody Bill bill,
			@PathVariable(name = "maMH") Long maMH,
			@PathVariable(name = "soLuong")int soLuong){
		billService.changeStatusToAwait(username, bill,maMH,soLuong);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/order/{username}")
	public List<Bill> getBill(@PathVariable(name = "username") String username) {
		return billService.getBillList(username);
	}
	
	@CrossOrigin
	@GetMapping("/order/detail/{maHD}")
	public List<BillDetail> getBillDetail(@PathVariable(name = "maHD")Long maHD){
		return billService.getBillDetailList(maHD);
	}
	
	@CrossOrigin
	@PutMapping("/order/cancel/{maHD}")
	public ResponseEntity<HttpStatus> cancelBill(@PathVariable(name = "maHD")Long maHD){
		billService.cancelBill(maHD);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/order")
	public List<Bill> getOrderList(){
		return billService.getList();
	}
	
	@CrossOrigin
	@PutMapping("/order/handle/{maHD}")
	public ResponseEntity<HttpStatus> handleOrder(@PathVariable(name = "maHD") long maHD){
		billService.handleOrder(maHD);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
