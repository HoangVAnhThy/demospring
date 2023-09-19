package com.thy.banhang.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class User {
	
	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Cart> carts;
	@OneToMany(mappedBy = "userBill",cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	@JsonIgnore
	private Set<Bill> bills;
}
