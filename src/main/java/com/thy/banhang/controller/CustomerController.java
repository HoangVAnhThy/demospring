package com.thy.banhang.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thy.banhang.entity.Cart;
import com.thy.banhang.entity.Customer;
import com.thy.banhang.entity.Product;
import com.thy.banhang.entity.User;
import com.thy.banhang.repository.UserRepository;
import com.thy.banhang.service.CartService;
import com.thy.banhang.service.CustomerService;
import com.thy.banhang.service.UserService;

@RestController
public class CustomerController {
	@Autowired
	UserService userService;
	@Autowired
	CustomerService customerService;
	@Autowired
	CartService cartService;
	
	@CrossOrigin
	@GetMapping("/customer/{username}")
	public ResponseEntity<Customer> getCustomerByUsername(@PathVariable(name = "username") String username){
		Customer customer = customerService.getCustomerByUsername(username);
		if(customer!=null) {
			return ResponseEntity.ok(customer);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@CrossOrigin
	@GetMapping("/user/cart/{username}")
	public List<Cart> getCart(@PathVariable(name = "username") String username ){
		User user = userService.getUserById(username);
		return user.getCarts();
	}
	
	@CrossOrigin
	@PostMapping("/user/info")
	public ResponseEntity<HttpStatus> createCustomer(@RequestBody Customer customer){
		customerService.createCustomer(customer);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/user/info")
	public ResponseEntity<HttpStatus> changeCustomer(@RequestBody Customer customer){
		customerService.updateCustomer(customer);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/user/cart/{username}/{maMH}")
	public ResponseEntity<Cart> getCartProduct(@PathVariable(name = "username") String username, @PathVariable(name = "maMH") Long maMH) {
		Cart cart = cartService.findCartByUsernameAndProductId(username, maMH);
		if(cart!=null) {
			return ResponseEntity.ok(cart);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@CrossOrigin
	@GetMapping("/user/{username}")
	public User getUser(@PathVariable(name = "username") String username) {
		User user = userService.getUserById(username);
		return user;
	}
	
	@CrossOrigin
	@PostMapping("/user/cart/add")
	public ResponseEntity<HttpStatus> addCart(@RequestBody Cart cart){
		cartService.addCart(cart);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/user/cart/{username}/delete/{maMH}")
	public ResponseEntity<HttpStatus> deleteItemCart(
			@PathVariable(name = "username") String username,
			@PathVariable(name = "maMH")Long maMH){
		cartService.deleteCart(username, maMH);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@GetMapping("/user/list")
	public List<User> getUserList(){
		return userService.getUserList();	
	}
	
	@CrossOrigin
	@GetMapping("/user/customer/{username}")
	public ResponseEntity<Customer> checkCustomerInfo(@PathVariable(name = "username") String username) {
		Customer customer = customerService.getCustomerByUsername(username);
		if(customer !=null) {
			return ResponseEntity.ok(customer);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@CrossOrigin
	@GetMapping("/user/customer")
	public List<Customer> getListCustomers(){
		return customerService.getListCustomer();
	}
	
//	@CrossOrigin
//	@GetMapping("/user/{username}")
//	public Customer getCustomerById(@PathVariable(name="username") String userName) {
//		Optional<User> getUser = userService.getUserById(userName);
//		User user = getUser.orElse(null);
//		return user.getCustomer();
//	}
//	@CrossOrigin
//	@PostMapping("/customer")
//	public Customer createCustomer(@RequestBody Customer customer) {
//		customerService.createCustomer(customer);
//		return customer;
//	}
//	@CrossOrigin
//	@GetMapping("/customer")
//	public Customer getCustomer(@RequestParam(value="email") String email) {
//		return customerService.findCustomerByEmail(email);
//	}
}
