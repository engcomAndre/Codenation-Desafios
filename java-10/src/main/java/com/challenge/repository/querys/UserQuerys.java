package com.challenge.repository.querys;

public final class UserQuerys {
    public static final class SELECT {
        public static final String BY_ACCELERATION_NAME_AND_USER_ID =
                "SELECT U.*\n" +
                "FROM\n" +
                "    ACCELERATION ACC,\n" +
                "    CANDIDATE C,\n" +
                "    USERS U\n" +
                "WHERE\n" +
                "    ACC.NAME = :name " +
                "AND ACC.ID = C.ACCELERATION_ID \n" +
                "AND C.USER_ID = U.ID";

        public static final String BY_COMPANY_ID_AND_USER_ID =
                "SELECT U.*\n" +
                "FROM \n" +
                "    CANDIDATE C,\n" +
                "    USERS U\n" +
                "WHERE\n" +
                "    C.COMPANY_ID = :companyId\n" +
                "AND C.USER_ID = U.ID ";
    }

}
