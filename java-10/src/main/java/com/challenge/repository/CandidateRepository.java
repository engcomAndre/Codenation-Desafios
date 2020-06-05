package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.querys.CandidateQuerys;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends BaseRepository<Candidate, CandidateId> {

    //Using SQL Querys
    @Query(value = CandidateQuerys.SELECT.BY_USER_ID_AND_COMPANY_ID_AND_ACCELERATION_ID, nativeQuery = true)
    Optional<Candidate> findByUserIdCompanyIdAccelerationId(@Param(value = "userId") Long userId, @Param(value = "companyId") Long companyId, @Param(value = "accelerationId") Long accelerationId);

    //Using a Expressions Properties in JPQL
    List<Candidate> findById_Company_Id(Long companyId);

    List<Candidate> findById_Acceleration_Id(Long accelerationId);
}
