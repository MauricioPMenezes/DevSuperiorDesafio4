package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import org.apache.juli.logging.Log;

import java.time.LocalDate;

public class SalesDateAmountNameSellerDTO {

    private Long id;
    private LocalDate date;
    private Double amount;
    private String sellerName;

    public SalesDateAmountNameSellerDTO() {
    }

    public SalesDateAmountNameSellerDTO(Long id, LocalDate date, Double amount, String sellerName) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.sellerName = sellerName;
    }

    public SalesDateAmountNameSellerDTO(Sale entity) {
        id = entity.getId();
        date = entity.getDate();
        amount = entity.getAmount();
        sellerName = entity.getSeller().getName();
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSellerName() {
        return sellerName;
    }
}
