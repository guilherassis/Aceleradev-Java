package com.challenge.endpoints;


import com.challenge.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.challenge.service.impl.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("/{userId}")
	public ResponseEntity findById(@PathVariable("userId") Long userId) {
		return ResponseEntity.ok(service.findById(userId));
	
	}
	
	
	@GetMapping(params = {"accelerationName"})
	public List<User> findByAccelerationName(@Param("accelerationName") String accelerationName) {
		
		return service.findByAccelerationName(accelerationName);
	}
	
	
	@GetMapping(params ={"companyId"})
	public ResponseEntity findByCompanyId(@Param("companyId") Long companyId) {
		return ResponseEntity.ok(service.findByCompanyId(companyId));
	}
	
	
	
}
