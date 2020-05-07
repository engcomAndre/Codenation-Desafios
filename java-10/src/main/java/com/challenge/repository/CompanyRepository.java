package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends BaseRepository<Company, Long> {
    @Query(value = "SELECT COM.* \n" +
            "FROM\n" +
            "  CANDIDATE CAN,\n" +
            "  COMPANY COM\n" +
            "WHERE\n" +
            "    CAN.ACCELERATION_ID = :accelerationId\n" +
            "AND CAN.COMPANY_ID = COM.ID", nativeQuery = true)
    List<Company> findByAccelerationId(@Param(value = "accelerationId") Long accelerationId);

    @Query(value = "SELECT COM.*\n" +
            "FROM \n" +
            "   CANDIDATE CAN,\n" +
            "   COMPANY COM\n" +
            "WHERE\n" +
            "          CAN.USER_ID = :userId\n" +
            "AND  CAN.COMPANY_ID = COM.ID",nativeQuery = true)
    List<Company> findByUserId(@Param(value = "userId") Long userId);
}
