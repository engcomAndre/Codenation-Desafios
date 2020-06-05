package com.challenge.repository.querys;

public final class CompanyQuerys {
    public static final class SELECT {
        public static final String BY_ACCELERATION_ID_AND_COMPANY_ID =
                        "SELECT DISTINCT COM.* \n" +
                        "FROM\n" +
                        "    CANDIDATE CAN,\n" +
                        "    COMPANY COM\n" +
                        "WHERE\n" +
                        "    CAN.ACCELERATION_ID = :accelerationId\n" +
                        "AND CAN.COMPANY_ID = COM.ID";

        public static final String BY_USER_ID =
                "SELECT COM.*\n" +
                        "FROM \n" +
                        "    CANDIDATE CAN,\n" +
                        "    COMPANY COM\n" +
                        "WHERE\n" +
                        "    CAN.USER_ID = :userId\n" +
                        "AND CAN.COMPANY_ID = COM.ID";
    }
}
