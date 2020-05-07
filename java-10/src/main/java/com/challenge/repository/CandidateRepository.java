package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends BaseRepository<Candidate, Long> {

    Optional<Candidate> findById(CandidateId candidateId);

//    @Query(value = "select * from candidate where acceleration_id = :accelerationId")
//    List<Candidate> findByAccelerationId(@Param("id") Long accelerationId);
//
////    Optional<Candidate> findByUserIdCompanyIdAccelerationId(Long userId, Long companyId, Long accelerationId);


//    Optional<Candidate> findBy(Long userId, Long companyId, Long accelerationId);
}
