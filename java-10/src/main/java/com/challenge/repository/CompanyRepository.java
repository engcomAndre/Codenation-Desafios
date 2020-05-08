package com.challenge.repository;

import com.challenge.entity.Company;
import com.challenge.repository.querys.CompanyQuerys;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends BaseRepository<Company, Long> {

    //Using SQL Querys
    @Query(value = CompanyQuerys.SELECT.FIND_BY_ACCELERATION_ID, nativeQuery = true)
    List<Company> findByAccelerationId(@Param(value = "accelerationId") Long accelerationId);

    @Query(value = CompanyQuerys.SELECT.FIND_BY_USER_ID, nativeQuery = true)
    List<Company> findByUserId(@Param(value = "userId") Long userId);

    //Using a Expressions Properties in JPQL
    List<Company> findDistinctByCandidates_Id_Acceleration_Id(Long accelerationId);

    List<Company> findDistinctByCandidates_Id_User_Id(Long accelerationId);

}
