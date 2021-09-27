package com.example.api.rest;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.services.PriceService;
import com.example.commons.GenericServiceException;
import com.example.commons.ValidateServiceException;
import com.example.commons.WrapperResponse;
import com.example.dto.PriceDto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "${api.base.path}", produces = MediaType.APPLICATION_JSON_VALUE)
public class PriceRest {

	private static final Logger log = LoggerFactory.getLogger(PriceRest.class);

	@Autowired
	private PriceService priceService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "Retrieve price by date range, product and brand.")
	@GetMapping(path = "/price", consumes = MediaType.ALL_VALUE)
	public ResponseEntity<WrapperResponse<PriceDto>> getPrice(
			@ApiParam(example = "yyyy-MM-dd-hh.mm.ss") @RequestParam(name = "date", required = true) String date,
			@RequestParam(name = "productId", required = true) Long productId,
			@RequestParam(name = "brandId", required = true) Long brandId) {

		try {
			Optional<PriceDto> price = priceService.getPrice(date, productId, brandId);
			WrapperResponse response = new WrapperResponse(true);
			if (price.isPresent()) {
				response.setMessage("Successful query");
				response.setBody(price.get());
			} else {
				response.setMessage("No results found, please try another search");
			}
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (ValidateServiceException e) {
			log.error(e.getMessage());
			WrapperResponse response = new WrapperResponse(false, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		} catch (GenericServiceException e) {
			log.error(e.getMessage());
			WrapperResponse response = new WrapperResponse(false, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
