package com.thy.banhang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thy.banhang.entity.BillDetail;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {
	List<BillDetail> findAllByBillMaHD(Long maHD);
	BillDetail findByBillTrangThaiAndBillUserBillUsername(String trangThai,String username);
}
