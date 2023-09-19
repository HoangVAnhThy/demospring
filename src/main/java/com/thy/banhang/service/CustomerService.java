package com.thy.banhang.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thy.banhang.entity.Customer;
import com.thy.banhang.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	public Customer findCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	public Customer getCustomerByUsername(String username) {
		return customerRepository.findByUserUsername(username);
	}
	
	public void updateCustomer(Customer customer) {
		Customer updateCustomer = customerRepository.findByUserUsername(customer.getUser().getUsername());
		updateCustomer.setTenKH(customer.getTenKH());
		updateCustomer.setPhone(customer.getPhone());
		updateCustomer.setEmail(customer.getEmail());
		customerRepository.save(updateCustomer);
	}
	
	public List<Customer> getListCustomer(){
		return customerRepository.findAll();
	}
}
