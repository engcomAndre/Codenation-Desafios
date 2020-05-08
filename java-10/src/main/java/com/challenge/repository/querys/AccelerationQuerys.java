package com.challenge.repository.querys;

public class AccelerationQuerys {
    public static class SELECT {
        public static final String FIND_COMPANY_BY_ID =
                "SELECT ACC.*\n" +
                        "FROM \n" +
                        "  CANDIDATE C,\n" +
                        "  ACCELERATION ACC\n" +
                        "WHERE\n" +
                        "    C.COMPANY_ID = :companyId\n" +
                        "AND C.ACCELERATION_ID = ACC.ID ";
    }

}
