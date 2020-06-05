package com.challenge.repository.querys;

public final class AccelerationQuerys {
    public static final class SELECT {
        public static final String BY_COMPANY_ID_AND_ACCLERATION_ID =
                "SELECT ACC.*\n" +
                        "FROM \n" +
                        "  CANDIDATE C,\n" +
                        "  ACCELERATION ACC\n" +
                        "WHERE\n" +
                        "    C.COMPANY_ID = :companyId\n" +
                        "AND C.ACCELERATION_ID = ACC.ID ";
    }

}
