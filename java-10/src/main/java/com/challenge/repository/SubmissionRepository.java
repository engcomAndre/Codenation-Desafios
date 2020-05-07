package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends BaseRepository<Submission, Long> {

    @Query(value = "SELECT MAX(SUB.SCORE) \n" +
            "FROM \n" +
            "    SUBMISSION SUB\n" +
            "WHERE\n" +
            "    SUB.CHALLENGE_ID = :challengeId", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param(value = "challengeId") Long challengeId);


    @Query(value = "SELECT SUB.*\n" +
            "FROM \n" +
            "    SUBMISSION SUB,\n" +
            "    ACCELERATION ACC        \n" +
            "WHERE\n" +
            "    SUB.CHALLENGE_ID = :challengeId\n" +
            "AND ACC.ID  = :accelerationId", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param(value = "challengeId") Long challengeId, @Param(value = "accelerationId") Long accelerationId);
}
