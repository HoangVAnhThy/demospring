package com.thy.banhang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BILL_DETAIL")
public class BillDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "MaHD")
	private Bill bill;
	
	@ManyToOne
	@JoinColumn(name = "MaMH")
	private Product productBill;
	
	@Column(name = "SoLuong")
	private int soLuong;
}
