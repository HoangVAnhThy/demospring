package com.thy.banhang.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="Product")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaMH")
	private Long maMH;
	@Column(name="TenMH",columnDefinition = "nvarchar(max)")
	private String tenMH;
	@ManyToOne
	@JoinColumn(name = "MaLoai")
	private ProductCategory productCategory;
	@Column(name="Gia")
	private double gia;
	@Column(name="Image")
	private String image;
	@Column(name="SoLuong")
	private int soLuong;
	@Column(name="hangSanXuat",columnDefinition = "nvarchar(255)")
	private String hangSanXuat;
	@Column(name="xuatXu",columnDefinition = "nvarchar(255)")
	private String xuatXu;
	@OneToMany(mappedBy = "productBill",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<BillDetail> billDetails;
	
}
