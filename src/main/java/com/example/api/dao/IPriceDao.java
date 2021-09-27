package com.example.api.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Price;

@Repository
public interface IPriceDao extends JpaRepository<Price, Long> {

	@Query("SELECT p FROM Price p WHERE :date BETWEEN p.startDate AND p.endDate AND p.product.id = :productId AND p.brand.id = :brandId ORDER BY p.priority DESC")
	List<Price> retrieveByDateProductBrand(@Param("date") Calendar date, @Param("productId") Long productId,
			@Param("brandId") Long brandId);

}
