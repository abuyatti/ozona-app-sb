package com.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.dto.PriceDto;
import com.example.entity.Price;

@Mapper
public interface PriceMapper {

	PriceMapper MAPPER = Mappers.getMapper(PriceMapper.class);

	@Mapping(source = "product.id", target = "productId")
	@Mapping(source = "brand.id", target = "brandId")
	@Mapping(source = "priceList", target = "priceList")
	@Mapping(source = "startDate", target = "startDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@Mapping(source = "endDate", target = "endDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@Mapping(source = "finalPrice", target = "finalPrice")
	PriceDto priceToPriceDto(Price price);

}
