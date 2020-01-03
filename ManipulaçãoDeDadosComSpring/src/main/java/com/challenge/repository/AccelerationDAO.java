package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Acceleration;

@Repository
@Component
public interface AccelerationDAO extends JpaRepository<Acceleration, Long> {
	
	@Query(value = "SELECT a.* FROM candidate c, company o, acceleration a WHERE " +
			"o.id = c.company_id " +
			"AND a.id = c.acceleration_id " +
			"AND o.id = :id_company",nativeQuery = true)
	List<Acceleration> findByCompanyId (@Param("id_company") Long id_company);

}
