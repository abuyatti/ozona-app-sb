package com.example.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "PRICES")
public class Price {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "FK_BRAND", nullable = false, updatable = false)
	private Brand brand;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE")
	private Calendar startDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE")
	private Calendar endDate;

	@Column(name = "PRICE_LIST", nullable = false)
	private Float priceList;

	@ManyToOne(optional = false)
	@JoinColumn(name = "FK_PRODUCT", nullable = false, updatable = false)
	private Product product;

	@Column(name = "PRIORITY", nullable = false)
	private Integer priority;

	@Column(name = "FINAL_PRICE", nullable = false)
	private Float finalPrice;

	@Enumerated(EnumType.STRING)
	@Column(name = "CURR", nullable = false, length = 20)
	private Currency curr;

}
