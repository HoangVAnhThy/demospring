package com.thy.banhang.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class CartKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Username")
	String username;
	@Column(name = "MaMH")
	Long maMH;
}
