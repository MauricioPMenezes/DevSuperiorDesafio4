package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleForSellerMinProjection;

import java.time.LocalDate;

public class SalesReportYearDTO {

    private Double amount;
    private String date;

    public SalesReportYearDTO() {
    }

    public SalesReportYearDTO(Double amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public SalesReportYearDTO(Sale entity) {
        amount = entity.getAmount();
        date = entity.getDate().toString();
    }


    public SalesReportYearDTO(SaleForSellerMinProjection entity) {
        amount = entity.getAmount();
        date = entity.getDate();
    }

    public Double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "SalesReportYearDTO{" +
                "amount=" + amount +
                ", date=" + date +
                '}';
    }
}
