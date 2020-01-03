package com.challenge.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.challenge.service.impl.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {

	@Autowired
	CompanyService service;

	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.findById(id));

	}

	@GetMapping(params = {"accelerationId"})
	public ResponseEntity findByAccelerationId(@Param("accelerationId") Long accelerationId) {
		return ResponseEntity.ok(service.findByAccelerationId(accelerationId));

	}

	@GetMapping(params = {"userId"})
	public ResponseEntity findByUserId(@Param("userId") Long userId) {
		return ResponseEntity.ok(service.findByUserId(userId));

	}

}
