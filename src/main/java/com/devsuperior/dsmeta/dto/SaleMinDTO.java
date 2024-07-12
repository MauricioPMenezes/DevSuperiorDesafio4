package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleForSellerMinProjection;

public class SaleMinDTO {

	private Long id;
	private Double amount;
	private String date;
	
	public SaleMinDTO(Long id, Double amount, String date) {
		this.id = id;
		this.amount = amount;
		this.date = date;
	}

	public SaleMinDTO(Sale entity) {
		id = entity.getId();
		amount = entity.getAmount();
		date = entity.getDate().toString();
	}

	public SaleMinDTO(SaleForSellerMinProjection entity) {
		amount = entity.getAmount();
		date = entity.getDate();
	}

	public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}
}
