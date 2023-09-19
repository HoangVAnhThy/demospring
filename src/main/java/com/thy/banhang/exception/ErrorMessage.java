package com.thy.banhang.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
	
	private int statusCode;
    private String message;
}
