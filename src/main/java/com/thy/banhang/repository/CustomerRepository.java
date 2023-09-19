package com.thy.banhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thy.banhang.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByEmail(String email);
	Customer findByUserUsername(String username);
}
