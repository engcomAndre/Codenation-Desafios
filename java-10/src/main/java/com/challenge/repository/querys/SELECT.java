package com.challenge.repository.querys;

public abstract class SELECT {


    public static final String GET_USERS_BY_ACCELERATION_NAME =
            "SELECT U.*\n" +
            "FROM \n" +
            "  USERS U,\n" +
            "  ACCELERATION A,\n" +
            "  CANDIDATE C\n" +
            "WHERE \n" +
            "         A.NAME =:name\n" +
            "AND C.ACCELERATION_ID  = A.ID \n" +
            "AND C.USER_ID = U.ID; ";

    public static final String FIND_BY_COMPANY_ID = "SELECT U.*\n" +
            "FROM \n" +
            "  USERS U,\n" +
            "  CANDIDATE C\n" +
            "WHERE \n" +
            "  C.COMPANY_ID =  :companyId \n" +
            "AND C.USER_ID = U.ID;";


}
