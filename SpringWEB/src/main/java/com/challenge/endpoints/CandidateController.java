package com.challenge.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.challenge.service.impl.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	CandidateService service;
	
	@GetMapping("/{userId}/{accelerationId}/{companyId}")
	public ResponseEntity findById(@PathVariable("userId") Long userId,
								   @PathVariable("accelerationId") Long accelerationId,
								   @PathVariable("companyId") Long companyId) {
		return ResponseEntity.ok(service.findById(userId, companyId, accelerationId));
		
	}
	
	@GetMapping(params = {"companyId"})
	public ResponseEntity findByCompanyId(@Param("companyId") Long companyId) {
		return ResponseEntity.ok(service.findByCompanyId(companyId)); 
		
	}
	
	@GetMapping(params = {"accelerationId"})
	public ResponseEntity findByAccelerationId(@Param("accelerationId") Long accelerationId) {
		return ResponseEntity.ok(service.findByAccelerationId(accelerationId));
		
	}
	
}
