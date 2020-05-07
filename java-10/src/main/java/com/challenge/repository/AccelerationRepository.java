package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends BaseRepository<Acceleration, Long> {

    Optional<Acceleration> findByName(String name);

    @Query(value = "SELECT ACC.*\n" +
            "FROM \n" +
            "  CANDIDATE C,\n" +
            "  ACCELERATION ACC\n" +
            "WHERE\n" +
            "    C.COMPANY_ID = :companyId\n" +
            "AND C.ACCELERATION_ID = ACC.ID ", nativeQuery = true)
    List<Acceleration> findCompanyById(@Param(value = "companyId") Long companyId);
}
