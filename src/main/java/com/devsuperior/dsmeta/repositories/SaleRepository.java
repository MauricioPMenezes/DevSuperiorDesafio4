package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SalesReportYearDTO;
import com.devsuperior.dsmeta.projections.SaleForSellerMinProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {


        @Query("SELECT new com.devsuperior.dsmeta.dto.SalesReportYearDTO(SUM(obj.amount) ,CONCAT(YEAR(obj.date), '-', MONTH(obj.date)) ) " +
                "FROM Sale obj " +
                "GROUP BY date " +
                "ORDER BY date DESC")
        Page<SalesReportYearDTO> searchSaleForSaller(Pageable pageable);
        

//        @Query(nativeQuery = true, value =
//                "SELECT SUM(TB_SALES.AMOUNT) AS amount, CONCAT(YEAR(date), '-', MONTH(date)) AS date " +
//                "FROM TB_SALES " +
//                "GROUP BY date " +
//                "ORDER BY date DESC " +
//                "Limit 0,12 " )
//        List<SaleForSellerMinProjection> searchSaleForSaller();
//
//
//        @Query(nativeQuery = true, value =
//                "SELECT TB_SELLER.NAME, SUM(TB_SALES.AMOUNT) AS Total "+
//                "FROM TB_SALES "+
//                "JOIN TB_SELLER ON TB_SALES.SELLER_ID = TB_SELLER.ID "+
//                "WHERE TB_SALES.DATE BETWEEN '2022-01-01' AND '2022-06-30' "+
//                "GROUP BY TB_SELLER.NAME ")
//        List<SaleForSellerMinProjection> searchSellerTotal();

}

