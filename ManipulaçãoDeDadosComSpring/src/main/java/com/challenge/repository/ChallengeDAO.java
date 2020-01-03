package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface ChallengeDAO extends JpaRepository<Challenge, Long> {


    @Query(value = "SELECT c.* FROM challenge c, users u, candidate ca, acceleration a  WHERE " +
            "u.id = ca.user_id " +
            "AND a.id = ca.acceleration_id " +
            "AND c.id = a.challenge_id " +
            "AND a.id = :id_acceleration " +
            "AND u.id = :id_user",nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId (@Param("id_acceleration") Long id_acceleration,
                                                   @Param("id_user") Long id_user);

}
