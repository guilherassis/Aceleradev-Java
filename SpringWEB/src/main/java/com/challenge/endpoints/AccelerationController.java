package com.challenge.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.challenge.service.impl.AccelerationService;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

	@Autowired
	AccelerationService service;
	
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.findById(id));
		
	}
	
	@GetMapping
	public ResponseEntity findByCompanyId(@Param("companyId") Long companyId) {
		return ResponseEntity.ok(service.findByCompanyId(companyId));
		
	}
	
	
}
