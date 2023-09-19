package com.thy.banhang.security;

import lombok.Data;

@Data
public class LoginResponse {
	private String accessToken;
	private String tokenType = "Bearer";

	public LoginResponse(String accessToken) {
		this.accessToken = accessToken;
	}
}
