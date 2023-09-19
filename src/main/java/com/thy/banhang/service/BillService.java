package com.thy.banhang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thy.banhang.entity.Bill;
import com.thy.banhang.entity.BillDetail;
import com.thy.banhang.entity.Product;
import com.thy.banhang.entity.User;
import com.thy.banhang.repository.BillDetailRepository;
import com.thy.banhang.repository.BillRepository;
import com.thy.banhang.repository.ProductRepository;
import com.thy.banhang.repository.UserRepository;

@Service
public class BillService {
	@Autowired
	BillRepository billRepository;
	@Autowired
	BillDetailRepository billDetailRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	
	public void createBill(String username,Long maMH,int soLuong, Bill bill) {
		User user = userRepository.findById(username).orElse(null);
		long millis=System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		bill.setUserBill(user);		bill.setNgayLap(date);
		billRepository.saveAndFlush(bill);
		Product product = productRepository.findById(maMH).orElse(null);
		BillDetail billDetail = new BillDetail();
		billDetail.setProductBill(product);
		billDetail.setBill(bill);
		billDetail.setSoLuong(soLuong);
		billDetailRepository.saveAndFlush(billDetail);
	}
	
	public List<Bill> getBillList(String username) {
		return billRepository.findAllByUserBillUsername(username);
	}
	
	public List<BillDetail> getBillDetailList(Long maHD){
		return billDetailRepository.findAllByBillMaHD(maHD);
	}
	
	public void cancelBill(Long maHD) {
		Bill bill = billRepository.findById(maHD).orElse(null);
		bill.setTrangThai("Đã hủy");
		billRepository.saveAndFlush(bill);
	}
	
	public void addProductToBill(Long maMH, int soLuong, String username) {
		Bill bill = billRepository.findByTrangThaiAndUserBillUsername("1", username);
		Product product = productRepository.findById(maMH).orElse(null);
		BillDetail billDetail = new BillDetail();
		billDetail.setBill(bill);
		billDetail.setProductBill(product);
		billDetail.setSoLuong(soLuong);
		billDetailRepository.saveAndFlush(billDetail);
	}
	
	public void changeStatusToAwait(String username,Bill bill,Long maMH,int soLuong) {
		Bill updateBill = billRepository.findByTrangThaiAndUserBillUsername("1", username);
		Product product = productRepository.findById(maMH).orElse(null);
		BillDetail billDetail = new BillDetail();
		billDetail.setBill(updateBill);
		billDetail.setProductBill(product);
		billDetail.setSoLuong(soLuong);
		billDetailRepository.saveAndFlush(billDetail);
		updateBill.setTrangThai(bill.getTrangThai());
		billRepository.saveAndFlush(updateBill);
	}
	
	public List<Bill> getList(){
		return billRepository.findAll();
	}
	
	public void handleOrder(Long maHD) {
		Bill updateBill = billRepository.findById(maHD).orElse(null);
		updateBill.setTrangThai("Hoàn thành");
		billRepository.saveAndFlush(updateBill);
	}
}
