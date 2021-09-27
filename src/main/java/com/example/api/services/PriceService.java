package com.example.api.services;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.api.dao.IPriceDao;
import com.example.commons.CustomTimestamp;
import com.example.commons.GenericServiceException;
import com.example.commons.ValidateServiceException;
import com.example.dto.PriceDto;
import com.example.entity.Price;
import com.example.mapper.PriceMapper;

@Component
public class PriceService {

	private static final Logger log = LoggerFactory.getLogger(PriceService.class);

	@Autowired
	private IPriceDao priceDao;

	public Optional<PriceDto> getPrice(String date, Long productId, Long brandId)
			throws ValidateServiceException, GenericServiceException {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(CustomTimestamp.dfIn().parse(date));
			List<Price> prices = priceDao.retrieveByDateProductBrand(cal, productId, brandId);
			if (!prices.isEmpty()) {
				return Optional.of(PriceMapper.MAPPER.priceToPriceDto(prices.get(0)));
			}
			return Optional.ofNullable(null);
		} catch (ParseException e) {
			log.error(e.getMessage());
			throw new ValidateServiceException("Unparseable date. It must be in the format yyyy-MM-dd-hh.mm.ss");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GenericServiceException("Internal Server Error");
		}
	}

}
