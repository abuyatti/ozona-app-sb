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
class PriceControllerTest {

	@Value("${api.base.path}")
	private String basePath;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void should_GetPrice_When_InputOK() throws Exception {
		// @formatter:off
		this.mockMvc.perform(get(basePath + "/price")
				.param("date", "2020-06-14-14.00.00")
				.param("productId", "35455")
				.param("brandId", "1"))
				.andDo(print())

		.andExpect(status().isOk())
		.andExpect(jsonPath("$.message").value("Successful query"))
		.andExpect(jsonPath("$.body.finalPrice").value(35.5));
		// @formatter:on
	}

	@Test
	void should_NoResultsFound_When_InputNotMatch() throws Exception {
		// @formatter:off
		this.mockMvc.perform(get(basePath + "/price")
				.param("date", "2020-06-14-14.00.00")
				.param("productId", "35455")
				.param("brandId", "2"))
				.andDo(print())

		.andExpect(status().isOk())
		.andExpect(jsonPath("$.message").value("No results found, please try another search"));
		// @formatter:on
	}

	@Test
	void whenNoParams_thenBadRequest() throws Exception {
		// @formatter:off
		// when
		this.mockMvc.perform(get(basePath + "/price")).andDo(print())

		// then
		.andExpect(status().isBadRequest());
		// @formatter:on
	}

	@Test
	void whenInvalidParamType_thenBadRequest() throws Exception {
		// @formatter:off
		// when
		this.mockMvc.perform(get(basePath + "/price")
				.param("date", "2020-06-14-14.00.00")
				.param("productId", "35455")
				.param("brandId", "a"))
				.andDo(print())

		// then
		.andExpect(status().isBadRequest());
		// @formatter:on
	}

	@Test
	void whenInvalidDateFormat_thenBadRequest() throws Exception {
		// @formatter:off
		// when
		this.mockMvc.perform(get(basePath + "/price")
				.param("date", "2020-06-14 14:00:00")
				.param("productId", "35455")
				.param("brandId", "1"))
				.andDo(print())

		// then
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.ok").value(false))
		.andExpect(jsonPath("$.message").value("Unparseable date. It must be in the format yyyy-MM-dd-hh.mm.ss"));
		// @formatter:on
	}

}
