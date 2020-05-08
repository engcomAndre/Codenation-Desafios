package com.challenge.repository.querys;

public class UserQuerys {
    public static class SELECT {

        public static final String FIND_BY_ACCELERATION_NAME =
                "SELECT U.*\n" +
                        "FROM\n" +
                        "  ACCELERATION ACC,\n" +
                        "  CANDIDATE C,\n" +
                        "  USERS U\n" +
                        "WHERE\n" +
                        "         ACC.NAME = :name " +
                        "AND ACC.ID = C.ACCELERATION_ID \n" +
                        "AND C.USER_ID = U.ID";

        public static final String FIND_BY_COMPANY_ID =
                "SELECT U.*\n" +
                        "FROM \n" +
                        "  CANDIDATE C,\n" +
                        "  USERS U\n" +
                        "WHERE\n" +
                        "          C.COMPANY_ID = :companyId\n" +
                        "AND  C.USER_ID = U.ID ";


    }

}
