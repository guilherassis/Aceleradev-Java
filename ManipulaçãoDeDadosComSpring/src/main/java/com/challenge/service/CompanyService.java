package com.challenge.service;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyDAO;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements CompanyServiceInterface {

	@Autowired
	CompanyDAO companyDAO;

	@Override
	public Company save(Company object) {
		// TODO Auto-generated method stub
		return companyDAO.save(object);
	}

	@Override
	public Optional<Company> findById(Long id) {
		// TODO Auto-generated method stub
		return companyDAO.findById(id);
	}

	@Override
	public List<Company> findByAccelerationId(Long accelerationId) {
		// TODO Auto-generated method stub
		return companyDAO.findByAccelerationId(accelerationId);
	}

	@Override
	public List<Company> findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return companyDAO.findByUserId(userId);
	}

}
