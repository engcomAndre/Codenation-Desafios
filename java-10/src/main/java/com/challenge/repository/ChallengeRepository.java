package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends BaseRepository<Challenge, Long> {

    @Query(value = "SELECT CHA.*\n" +
            "FROM\n" +
            "      CANDIDATE CAN, \n" +
            "      ACCELERATION ACC,\n" +
            "      CHALLENGE CHA\n" +
            "WHERE\n" +
            "    CAN.USER_ID = :userId\n" +
            "AND CAN.ACCELERATION_ID = :accelerationId\n" +
            "AND CAN.ACCELERATION_ID = ACC.ID \n" +
            "AND ACC.CHALLENGE_ID = CHA.ID", nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param(value = "accelerationId") Long accelerationId, @Param(value = "userId") Long userId);
}
