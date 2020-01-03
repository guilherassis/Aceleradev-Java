package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface CompanyDAO extends JpaRepository<Company, Long> {


    @Query(value = "SELECT distinct  co.* FROM company co , acceleration a, candidate c WHERE " +
            "a.id = c.acceleration_id " +
            "AND co.id = c.company_id " +
            "AND a.id = :id_acceleration",nativeQuery = true)
    List<Company> findByAccelerationId (@Param("id_acceleration") Long id_acceleration);

    @Query(value = "SELECT o.* FROM company o, candidate c, users u WHERE " +
            "o.id = c.company_id " +
            "AND u.id = c.user_id " +
            "AND u.id = :id_user", nativeQuery = true)
    List<Company> findByUserId (@Param("id_user") Long id_user);

}
