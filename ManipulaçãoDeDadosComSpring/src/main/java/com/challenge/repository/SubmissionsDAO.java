package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Submission;

@Repository
@Component
public interface SubmissionsDAO extends JpaRepository<Submission, Long> {
	
	@Query(value = "SELECT COALESCE(max(s.score),0) FROM submission s, challenge c WHERE \r\n" +
			"c.id = :id_challenge\r\n" + 
			"AND c.id = s.challenge_id", nativeQuery = true)
	BigDecimal findHigherScoreByChallengeId (@Param("id_challenge") Long id_challenge);
	
	
	@Query(value = "SELECT s.* FROM submission s, acceleration a, challenge c WHERE \r\n" + 
			"a.challenge_id = c.id\r\n" + 
			"AND c.id = s.challenge_id\r\n" + 
			"AND c.id = :id_challenge\r\n" + 
			"AND a.id = :id_acceleration ", nativeQuery = true)
	List<Submission> findByChallengeIdAndAccelerationId(@Param("id_challenge") Long id_challenge,
														@Param("id_acceleration") Long id_acceleration);	

}
