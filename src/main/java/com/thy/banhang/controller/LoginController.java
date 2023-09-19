package com.thy.banhang.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thy.banhang.entity.User;
import com.thy.banhang.security.CustomUserDetails;
import com.thy.banhang.security.JwtTokenProvider;
import com.thy.banhang.security.LoginRequest;
import com.thy.banhang.security.LoginResponse;
import com.thy.banhang.service.UserService;

@RestController
public class LoginController {
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@CrossOrigin
	@PostMapping("/login")
	public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
				);
		System.out.println(loginRequest);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
	}
	
	@CrossOrigin
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.regisUser(user);
		return user;
	}
	
}
