package com.thy.banhang.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thy.banhang.entity.Cart;
import com.thy.banhang.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	
	public void addCart(Cart cart) {
		if(cartRepository.findByUserAndProduct(cart.getUser(), cart.getProduct())==null) {
			cartRepository.save(cart);
		}
		else {
			Cart cartTemp = cartRepository.findByUserAndProduct(cart.getUser(), cart.getProduct());
			cartTemp.setSoLuongMua(cartTemp.getSoLuongMua()+cart.getSoLuongMua());
			cartRepository.saveAndFlush(cartTemp);
		}
	}
	
	public Cart findCartByUsernameAndProductId(String username, Long maMH) {
		return cartRepository.findByUserUsernameAndProductMaMH(username, maMH);
	}
	
	public void deleteCart(String username,Long maMH) {
		cartRepository.deleteByUserUsernameAndProductMaMH(username, maMH);
	}
}
