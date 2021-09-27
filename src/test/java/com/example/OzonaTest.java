package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class OzonaTest {

	@Value("${api.base.path}")
	private String basePath;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void should_35_5_When_Date14Time10() throws Exception {
		// @formatter:off
		// when
		this.mockMvc.perform(get(basePath + "/price")
				.param("date", "2020-06-14-10.00.00")
				.param("productId", "35455")
				.param("brandId", "1"))
				.andDo(print())

		// then
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.body.priceList").value(1.0))
		.andExpect(jsonPath("$.body.finalPrice").value(35.5));
		// @formatter:on
	}

	@Test
	void should_25_45_When_Date14Time16() throws Exception {
		// @formatter:off
		// when
		this.mockMvc.perform(get(basePath + "/price")
				.param("date", "2020-06-14-16.00.00")
				.param("productId", "35455")
				.param("brandId", "1"))
				.andDo(print())

		// then
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.body.priceList").value(2.0))
		.andExpect(jsonPath("$.body.finalPrice").value(25.45));
		// @formatter:on
	}

	@Test
	void should_35_5_When_Date14Time21() throws Exception {
		// @formatter:off
		// when
		this.mockMvc.perform(get(basePath + "/price")
				.param("date", "2020-06-14-21.00.00")
				.param("productId", "35455")
				.param("brandId", "1"))
				.andDo(print())

		// then
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.body.priceList").value(1.0))
		.andExpect(jsonPath("$.body.finalPrice").value(35.5));
		// @formatter:on
	}

	@Test
	void should_30_5_When_Date15Time10() throws Exception {
		// @formatter:off
		// when
		this.mockMvc.perform(get(basePath + "/price")
				.param("date", "2020-06-15-10.00.00")
				.param("productId", "35455")
				.param("brandId", "1"))
				.andDo(print())

		// then
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.body.priceList").value(3.0))
		.andExpect(jsonPath("$.body.finalPrice").value(30.5));
		// @formatter:on
	}

	@Test
	void should_38_95_When_Date16Time21() throws Exception {
		// @formatter:off
		// when
		this.mockMvc.perform(get(basePath + "/price")
				.param("date", "2020-06-16-21.00.00")
				.param("productId", "35455")
				.param("brandId", "1"))
				.andDo(print())

		// then
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.body.priceList").value(4.0))
		.andExpect(jsonPath("$.body.finalPrice").value(38.95));
		// @formatter:on
	}

}
