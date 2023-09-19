package com.thy.banhang.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "Cart")
@Data
public class Cart {
	
	@EmbeddedId
	private CartKey cartKey;
	
	@ManyToOne
	@MapsId("username")
	@JoinColumn(name = "Username")
	private User user;
	@ManyToOne
	@MapsId("maMH")
	@JoinColumn(name = "MaMH")
	private Product product;
	@Column(name = "SoLuongMua")
	private int soLuongMua;
}
