package com.challenge.repository;

import com.challenge.entity.Challenge;
import com.challenge.repository.querys.ChallengeQuerys;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends BaseRepository<Challenge, Long> {

    //Using SQL Querys
    @Query(value = ChallengeQuerys.SELECT.BY_USER_ID_AND_ACCELERATION_ID_AND_CHALLENGE_ID, nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param(value = "accelerationId") Long accelerationId, @Param(value = "userId") Long userId);

    //Using a Expressions Properties in JPQL
    List<Challenge> findByAccelerations_Candidates_Id_Acceleration_IdAndAccelerations_Candidates_Id_User_Id(Long accelerationId, Long userId);

}
