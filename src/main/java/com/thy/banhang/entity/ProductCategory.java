package com.thy.banhang.entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Table(name="ProductCategory")
@Data
@Entity
public class ProductCategory {
	@Id
	@Column(name="MaLoai")
	private String maLoai;
	@Column(name="TenLoai",columnDefinition = "nvarchar(255)")
	private String tenLoai;
	@OneToMany(mappedBy = "productCategory",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Product> products;
}
