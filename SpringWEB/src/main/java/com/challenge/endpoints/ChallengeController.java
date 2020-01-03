package com.challenge.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.challenge.service.impl.ChallengeService;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

	@Autowired
	ChallengeService service;
	
	
	@GetMapping(params = {"accelerationId","userId"})
	public ResponseEntity findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId,
														@Param("userId") Long userId) {
	return ResponseEntity.ok(service.findByAccelerationIdAndUserId(accelerationId, userId));	
		
		
	}
	
}
