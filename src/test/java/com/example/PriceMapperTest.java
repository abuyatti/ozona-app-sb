package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.api.dao.IPriceDao;
import com.example.dto.PriceDto;
import com.example.entity.Currency;
import com.example.entity.Price;
import com.example.mapper.PriceMapper;

@SpringBootTest(properties = { "spring.jpa.properties.hibernate.enable_lazy_load_no_trans = true" })
class PriceMapperTest {

	@Autowired
	private IPriceDao priceDao;

	@Test
	void shouldMapPriceToDto() {
		// given
		Price price = priceDao.getOne(1L);

		// when
		PriceDto priceDto = PriceMapper.MAPPER.priceToPriceDto(price);

		// then
		assertThat(price).isNotNull();
		assertThat(price.getBrand().getName()).isEqualTo("ZARA");
		assertThat(price.getProduct().getId()).isEqualTo(35455);
		assertThat(price.getCurr()).isEqualTo(Currency.EUR);

		assertThat(priceDto.getBrandId()).isEqualTo(1);
		assertThat(priceDto.getProductId()).isEqualTo(35455);
		assertThat(priceDto.getPriceList()).isEqualTo(1);
		assertThat(priceDto.getStartDate()).isEqualTo("2020-06-14T00:00:00Z");
		assertThat(priceDto.getEndDate()).isEqualTo("2020-12-31T23:59:59Z");
		assertThat(priceDto.getFinalPrice()).isEqualTo(35.50f);
	}

}
