package com.example.dto;

import lombok.Data;

@Data
public class PriceDto {

	private Long productId;
	private Long brandId;
	private Float priceList;
	private String startDate;
	private String endDate;
	private Float finalPrice;

}
