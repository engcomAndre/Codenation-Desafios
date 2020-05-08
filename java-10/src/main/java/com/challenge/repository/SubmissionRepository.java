package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.repository.querys.SubmissionQuerys;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface SubmissionRepository extends BaseRepository<Submission, Long> {
    //Using SQL Querys
    @Query(value = SubmissionQuerys.SELECT.FIND_HIGHER_SCORE_BY_CHALLENGE_ID, nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param(value = "challengeId") Long challengeId);

    @Query(value = SubmissionQuerys.SELECT.FIND_BY_CHALLENGE_ID_AND_ACCELERATION_ID, nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param(value = "challengeId") Long challengeId, @Param(value = "accelerationId") Long accelerationId);

    //Using a Expressions Properties in JPQL
    Optional<Submission> findFirstScoreById_Challenge_IdOrderByScoreDesc(Long challengeId);


}
