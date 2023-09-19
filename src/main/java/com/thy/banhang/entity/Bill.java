package com.thy.banhang.entity;


import java.sql.Date;
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

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="BILL")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaHD")
	private long maHD;
	@Column(name="NgayLap")
	private Date ngayLap;
	@Column(name="TrangThai",columnDefinition = "nvarchar(255)")
	private String trangThai;
	@Column(name="TongTien")
	private double tongTien;
	@Column(name="Address",columnDefinition = "nvarchar(255)")
	private String address;
	@Column(name = "PhoneContact")
	private String phoneContact;
	@ManyToOne
	@JoinColumn(name="username")
	private User userBill;
	
	@OneToMany(mappedBy = "bill",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<BillDetail> billDetails;
	
}
