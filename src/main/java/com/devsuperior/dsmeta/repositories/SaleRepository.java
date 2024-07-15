package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleAmountDateDTO;
import com.devsuperior.dsmeta.dto.SalesDateAmountNameSellerDTO;
import com.devsuperior.dsmeta.dto.SellerNameAmountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

//

        //GET  /report
        @Query( "SELECT new com.devsuperior.dsmeta.dto.SaleAmountDateDTO(SUM(obj.amount) as amount, " +
                "CONCAT(YEAR(obj.date),'-', MONTH(obj.date)) as date ) " +
                "FROM Sale obj " +
                "WHERE obj.date >= FUNCTION('DATEADD', MONTH, -11, (SELECT MAX(obj.date) FROM Sale obj)) " +
                "GROUP BY date " +
                "ORDER BY date DESC")
        Page<SaleAmountDateDTO> searchSaleForSeller(Pageable pageable);



        //GET  /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson
        @Query("SELECT new com.devsuperior.dsmeta.dto.SalesDateAmountNameSellerDTO( " +
                "obj.id , obj.date , obj.amount , obj.seller.name ) " +
                "FROM Sale obj " +
                "WHERE UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name , '%')) " +
                "AND obj.date BETWEEN :minDate AND :maxDate " )
        Page<SalesDateAmountNameSellerDTO> searchSaleByNameAndDate(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable);




        //GET  /Summary
        @Query("SELECT new com.devsuperior.dsmeta.dto.SellerNameAmountDTO( obj.seller.name, SUM(obj.amount)) " +
                "FROM Sale obj " +
                "WHERE obj.date >= FUNCTION('DATEADD', MONTH, -12, (SELECT MAX(obj.date) FROM Sale obj)) " +
                "GROUP BY obj.seller.name " +
                "ORDER BY SUM(obj.amount) DESC" )
        Page<SellerNameAmountDTO> searchSellerNameAmount(Pageable pageable);



        //GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30
        @Query("SELECT new com.devsuperior.dsmeta.dto.SellerNameAmountDTO( obj.seller.name , SUM(obj.amount)) " +
                "FROM Sale obj " +
                "WHERE obj.date BETWEEN :minDate AND :maxDate " +
                "GROUP BY obj.seller.name ")
        Page<SellerNameAmountDTO> searchSellerNameAmount(LocalDate minDate, LocalDate maxDate, Pageable pageable);



}




