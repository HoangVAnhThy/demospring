package com.thy.banhang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thy.banhang.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	List<Bill> findAllByUserBillUsername(String username);
	Bill findByTrangThaiAndUserBillUsername(String trangThai,String username);
}
