package com.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionsDAO;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@Service
public class SubmissionService implements SubmissionServiceInterface{
	
	@Autowired
	private SubmissionsDAO submissionDAO;
	
	@Override
	public Submission save(Submission object) {
		// TODO Auto-generated method stub
		
		return submissionDAO.save(object);
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		// TODO Auto-generated method stub

		return submissionDAO.findHigherScoreByChallengeId(challengeId);

	}

	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
		// TODO Auto-generated method stub
		return submissionDAO.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
	}

}
