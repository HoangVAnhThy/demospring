package com.thy.banhang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thy.banhang.entity.User;
import com.thy.banhang.repository.UserRepository;
import com.thy.banhang.security.CustomUserDetails;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(String id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> getUser = userRepository.findById(username);
		User user = getUser.orElse(null);
		if(user == null ) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(user);
	}
	
	public void regisUser(User user) {
		userRepository.save(user);
	}
	
	public List<User> getUserList(){
		return userRepository.findAll();
	}
}
