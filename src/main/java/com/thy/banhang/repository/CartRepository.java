package com.thy.banhang.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thy.banhang.entity.Cart;
import com.thy.banhang.entity.CartKey;
import com.thy.banhang.entity.Product;
import com.thy.banhang.entity.User;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, CartKey> {
	Cart findByUserAndProduct(User user, Product product);
	Cart findByUserUsernameAndProductMaMH(String username, Long maMH);
	void deleteByUserUsernameAndProductMaMH(String username, Long maMH);
}
