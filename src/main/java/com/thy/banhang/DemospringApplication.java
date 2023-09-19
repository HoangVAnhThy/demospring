package com.thy.banhang;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.thy.banhang.entity.User;
import com.thy.banhang.repository.UserRepository;

@SpringBootApplication
public class DemospringApplication{

	public static void main(String[] args)   {
		SpringApplication.run(DemospringApplication.class, args);
	}

}
