package com.challenge.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.User;

@Repository
@Component
public interface UserDAO extends JpaRepository<User, Long> {

	

	@Query(value = "SELECT u.* FROM acceleration a , candidate c , users u " +
			"WHERE a.name = :nome " +
			"AND c.acceleration_id = a.id " +
			"AND c.user_id = u.id"
			,nativeQuery = true)
	List<User> findByAccelerationName (@Param("nome") String nome);
	
	@Query(value = "SELECT u.* FROM company o , candidate c , users u " +
			"WHERE o.id = :companyId " +
			"AND c.company_id = o.id " +
			"AND c.user_id = u.id"
			,nativeQuery = true)
	List<User> findByCompanyId (@Param ("companyId") Long companyId);


	@Query(value = "select * from users u where u.full_name = :fullname",nativeQuery = true)
	User findUserName (@Param("fullname") String fullname);


}
