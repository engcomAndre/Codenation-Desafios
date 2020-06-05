package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Set<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);

    Set<Company> findByCandidatesIdUserId(Long userId);

}
