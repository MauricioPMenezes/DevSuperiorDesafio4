package com.devsuperior.dsmeta.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsmeta.dto.SalesReportYearDTO;
import com.devsuperior.dsmeta.projections.SaleForSellerMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Transactional(readOnly = true)
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
//
//	@Transactional(readOnly = true)
//	public List<SalesReportYearDTO> busca12meses() {
//		List<SaleForSellerMinProjection> list= repository.searchSaleForSaller();
//		List <SalesReportYearDTO> result1 = list.stream().map(x-> new SalesReportYearDTO(x)).collect(Collectors. toList());
//		return result1;
//	}

	@Transactional(readOnly = true)
	public Page<SalesReportYearDTO> busca12meses(Pageable pageable) {
		Page<SalesReportYearDTO> list= repository.searchSaleForSaller(pageable);
		return list;
	}

//	@Transactional(readOnly = true)
//	public Page<SalesReportYearDTO> busca12meses(Pageable pageable) {
//		Page<SalesReportYearDTO> list = repository.searchSaleForSaller(pageable);
//		List < SalesReportYearDTO> entSale = list.stream().map(x-> new SalesReportYearDTO(x)).collect(Collectors. toList());
//		return entSale;
	}

