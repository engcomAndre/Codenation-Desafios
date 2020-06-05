package com.challenge.repository.querys;

public final class CandidateQuerys {
    public static final class SELECT {
        public static final String BY_USER_ID_AND_COMPANY_ID_AND_ACCELERATION_ID =
                "SELECT CAN.*\n" +
                        "FROM CANDIDATE CAN\n" +
                        "WHERE\n" +
                        "    CAN.USER_ID = :userId\n" +
                        "AND CAN.COMPANY_ID =:companyId\n" +
                        "AND CAN.ACCELERATION_ID =:accelerationId";
    }
}
