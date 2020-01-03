package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.User;
import com.challenge.repository.UserDAO;
import com.challenge.service.interfaces.UserServiceInterface;


import javax.transaction.Transactional;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	private UserDAO userDao;

	@Override
	@Transactional
	public User save(User object) {
		// TODO Auto-generated method stub
		User usuario = userDao.findUserName(object.getFullName());
		
		
		return userDao.save(usuario);



	}

	@Override
	@Transactional
	public Optional<User> findById(Long userId) {
		// TODO Auto-generated method stub
		return userDao.findById(userId);


	}

	@Override
	@Transactional
	public List<User> findByAccelerationName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByAccelerationName(name);


	}

	@Override
	@Transactional
	public List<User> findByCompanyId(Long companyId) {
		// TODO Auto-generated method stub

		return userDao.findByCompanyId(companyId);


		}



}
