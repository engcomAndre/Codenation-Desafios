package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    @Query(value = "SELECT U.*\n" +
            "FROM\n" +
            "  ACCELERATION ACC,\n" +
            "  CANDIDATE C,\n" +
            "  USERS U\n" +
            "WHERE\n" +
            "         ACC.NAME = :name " +
            "AND ACC.ID = C.ACCELERATION_ID \n" +
            "AND C.USER_ID = U.ID ", nativeQuery = true)
    List<User> findByAccelerationName(@Param(value = "name") String name);


    @Query(value = "SELECT U.*\n" +
            "FROM \n" +
            "  CANDIDATE C,\n" +
            "  USERS U\n" +
            "WHERE\n" +
            "          C.COMPANY_ID = :companyId\n" +
            "AND  C.USER_ID = U.ID ", nativeQuery = true)
    List<User> findByCompanyId(@Param(value = "companyId") Long companyId);


}
