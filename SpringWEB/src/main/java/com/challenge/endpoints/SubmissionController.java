package com.challenge.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.service.impl.SubmissionService;

@RestController
@RequestMapping("submission")
public class SubmissionController {

	@Autowired
	SubmissionService service;
	 
	@GetMapping(params = {"challengeId","accelerationId"})
	public ResponseEntity findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, 
															 @Param("accelerationId") Long accelerationId) {
	return ResponseEntity.ok(service.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
		
	}
}
