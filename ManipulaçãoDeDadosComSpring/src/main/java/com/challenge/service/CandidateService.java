package com.challenge.service;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.repository.CandidateDAO;
import com.challenge.service.interfaces.CandidateServiceInterface;

@Service
public class CandidateService  implements CandidateServiceInterface {

	@Autowired
	private CandidateDAO candidateDAO;
	
	@Override
	public Candidate save(Candidate object) {
		
		return candidateDAO.save(object);
	}

	@Override
	public Optional<Candidate> findById(CandidateId id) {
		// TODO Auto-generated method stub

			Acceleration objacceleration =  id.getAcceleration();
			User objuser = id.getUser();
			Company objcompany = id.getCompany();

			Long companyId = objcompany.getId();
			Long userId = objuser.getId();
			Long accelerationId = objacceleration.getId();


		return candidateDAO.findByIdCandidate(userId,accelerationId,companyId);
	}

	@Override
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
		// TODO Auto-generated method stub


		return candidateDAO.findByIdCandidate(userId,accelerationId,companyId);
	}

	@Override
	public List<Candidate> findByCompanyId(Long companyId) {
		// TODO Auto-generated method stub
		
		return candidateDAO.findByCompanyId(companyId);
		
	}

	@Override
	public List<Candidate> findByAccelerationId(Long accelerationId) {
		// TODO Auto-generated method stub

       	return candidateDAO.findByAccelerationId(accelerationId);
	}

}
