package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.api.dao.IPriceDao;
import com.example.api.services.PriceService;
import com.example.commons.GenericServiceException;
import com.example.commons.ValidateServiceException;
import com.example.dto.PriceDto;
import com.example.entity.Price;

@ExtendWith(MockitoExtension.class)
class NoSpringContextTest {

	@Mock
	private PriceService priceService;

	@Mock
	private IPriceDao priceDao;

	@Test
	void should_Present_When_InputOK() throws ValidateServiceException, GenericServiceException {
		String date = "2020-06-14-14.00.00";
		Long productId = 35455L;
		Long brandId = 1L;

		when(priceService.getPrice(date, productId, brandId)).thenReturn(Optional.of(new PriceDto()));

		Optional<PriceDto> actual = priceService.getPrice(date, productId, brandId);

		assertTrue(actual.isPresent());
	}

	@Test
	void should_NotPresent_When_InputNotMatch() throws ValidateServiceException, GenericServiceException {
		String date = "2020-06-14-14.00.00";
		Long productId = 35455L;
		Long brandId = 2L;

		when(priceService.getPrice(date, productId, brandId)).thenReturn(Optional.ofNullable(null));

		Optional<PriceDto> actual = priceService.getPrice(date, productId, brandId);

		assertFalse(actual.isPresent());
	}

	@Test
	void should_List_When_InputOK() {
		when(priceDao.retrieveByDateProductBrand(any(), anyLong(), anyLong())).thenReturn(Arrays.asList(new Price()));

		List<Price> list = priceDao.retrieveByDateProductBrand(any(), anyLong(), anyLong());

		assertFalse(list.isEmpty());
	}

	@Test
	void should_EmptyList_When_InputNotMatch() {
		when(priceDao.retrieveByDateProductBrand(any(), anyLong(), anyLong())).thenReturn(Collections.emptyList());

		List<Price> list = priceDao.retrieveByDateProductBrand(any(), anyLong(), anyLong());

		assertTrue(list.isEmpty());
	}

}
