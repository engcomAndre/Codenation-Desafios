package com.challenge.repository;

import com.challenge.entity.Acceleration;
import com.challenge.repository.querys.AccelerationQuerys;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends BaseRepository<Acceleration, Long> {

    Optional<Acceleration> findByName(String name);

    //Using SQL Querys
    @Query(value = AccelerationQuerys.SELECT.FIND_COMPANY_BY_ID, nativeQuery = true)
    List<Acceleration> findCompanyById(@Param(value = "companyId") Long companyId);

    //Using a Expressions Properties in JPQL
    List<Acceleration> findByCandidates_Id_Company_Id(Long companyId);
}
