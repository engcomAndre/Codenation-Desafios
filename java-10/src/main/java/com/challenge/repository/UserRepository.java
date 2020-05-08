package com.challenge.repository;

import com.challenge.entity.User;
import com.challenge.repository.querys.UserQuerys;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    //Using SQL Querys
    @Query(value = UserQuerys.SELECT.FIND_BY_ACCELERATION_NAME, nativeQuery = true)
    List<User> findByAccelerationName(@Param(value = "name") String name);

    @Query(value = UserQuerys.SELECT.FIND_BY_COMPANY_ID, nativeQuery = true)
    List<User> findByCompanyId(@Param(value = "companyId") Long companyId);

    //Using a Expressions Properties in JPQL
    List<User> findByCandidates_Id_Acceleration_Name(String name);

    List<User> findByCandidates_Id_Company_Id(Long companyId);

}
