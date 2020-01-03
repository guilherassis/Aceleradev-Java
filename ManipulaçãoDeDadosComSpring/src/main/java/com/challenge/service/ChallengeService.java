package com.challenge.service;

import java.util.List;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeDAO;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService implements ChallengeServiceInterface{


	@Autowired
	ChallengeDAO challengeDAO;

	@Override
	public Challenge save(Challenge object) {
		// TODO Auto-generated method stub
		return challengeDAO.save(object);
	}

	@Override
	public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
		// TODO Auto-generated method stub
		return challengeDAO.findByAccelerationIdAndUserId(accelerationId,userId);
	}

}
