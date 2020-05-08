package com.challenge.repository.querys;

public class CandidateQuerys {
    public static class SELECT {
        public static final String FIND_BY_USER_COMPANY_ID_ACCELERATION_ID =
                "SELECT CAN.*\n" +
                        "FROM CANDIDATE CAN\n" +
                        "WHERE\n" +
                        "         CAN.USER_ID = :userId\n" +
                        "AND CAN.COMPANY_ID =:companyId\n" +
                        "AND CAN.ACCELERATION_ID =:accelerationId";
    }
}
