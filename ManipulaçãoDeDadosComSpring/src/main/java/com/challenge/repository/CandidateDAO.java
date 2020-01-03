package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.Company;
import com.challenge.entity.User;


@Repository
@Component
public interface CandidateDAO extends JpaRepository<Candidate, Long> {
	
	@Query(value = "SELECT c.* FROM candidate c WHERE \r\n" +
			"c.company_id = :id_company",nativeQuery = true)
	List<Candidate> findByCompanyId (@Param("id_company") Long id_company);
	

	@Query(value = "SELECT c.* FROM candidate c, acceleration a WHERE " +
			"a.id = c.acceleration_id " +
			"AND a.id = :id_acceleration ",nativeQuery = true)
	List<Candidate> findByAccelerationId (@Param("id_acceleration") Long id_acceleration);


	@Query(value = "SELECT c.* FROM candidate c, company co, users u, acceleration a WHERE \r\n" +
			"u.id = c.user_id\r\n" +
			"AND a.id = c.acceleration_id\r\n" +
			"AND co.id = c.company_id\r\n" +
			"AND a.id = :id_acceleration \r\n" +
			"AND co.id = :id_company " +
			"AND u.id = :id_user",nativeQuery = true)
	Optional<Candidate> findByIdCandidate (@Param("id_user")  Long id_user,
										   @Param("id_acceleration")  Long id_acceleration,
										   @Param("id_company") Long id_company);

}
