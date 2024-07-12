package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SalesReportYearDTO;
import com.devsuperior.dsmeta.projections.SaleForSellerMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SalesReportYearDTO>>getReport(Pageable pageable) {
		Page<SalesReportYearDTO> dto = service.busca12meses(pageable);
		return ResponseEntity.ok(dto);

	}

//	@GetMapping(value = "/report")
//	public ResponseEntity<List<SalesReportYearDTO>>getReport() {
//		List<SalesReportYearDTO> dto = service.busca12meses();
//		return ResponseEntity.ok(dto);
//
//	}

	@GetMapping(value = "/summary")
	public ResponseEntity<?> getSummary() {
		// TODO
		return null;
	}
}
