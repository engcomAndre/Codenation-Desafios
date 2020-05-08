package com.challenge.repository.querys;

public class CompanyQuerys {
    public static class SELECT {
        public static final String FIND_BY_ACCELERATION_ID =
                "SELECT DISTINCT COM.* \n" +
                        "FROM\n" +
                        "  CANDIDATE CAN,\n" +
                        "  COMPANY COM\n" +
                        "WHERE\n" +
                        "    CAN.ACCELERATION_ID = :accelerationId\n" +
                        "AND CAN.COMPANY_ID = COM.ID";

        public static final String FIND_BY_USER_ID =
                "SELECT COM.*\n" +
                        "FROM \n" +
                        "   CANDIDATE CAN,\n" +
                        "   COMPANY COM\n" +
                        "WHERE\n" +
                        "          CAN.USER_ID = :userId\n" +
                        "AND  CAN.COMPANY_ID = COM.ID";
    }
}
