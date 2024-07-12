package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

public class SallerMinDTO {

   private String name;
   private Double total;

    public SallerMinDTO() {
    }

    public SallerMinDTO(String name, Double total) {
        this.name = name;
        this.total = total;
    }


    public Double getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }



}
