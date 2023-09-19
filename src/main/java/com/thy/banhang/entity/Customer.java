package com.thy.banhang.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="KHACHHANG")
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaKH")
	private Long maKH;
	@Column(name="TenKH",columnDefinition = "nvarchar(255)")
	private String tenKH;
	@Column(name="Phone")
	private String phone;
	@Column(name="Email")
	private String email;
	@OneToOne
	@JoinColumn(name="username")
	private User user;
}
