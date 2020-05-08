package com.challenge.repository.querys;

public class ChallengeQuerys {
    public static class SELECT {
        public static final String FIND_BY_ACCELERATION_ID_AND_USER_ID =
                "SELECT CHA.*\n" +
                        "FROM\n" +
                        "      CANDIDATE CAN, \n" +
                        "      ACCELERATION ACC,\n" +
                        "      CHALLENGE CHA\n" +
                        "WHERE\n" +
                        "    CAN.USER_ID = :userId\n" +
                        "AND CAN.ACCELERATION_ID = :accelerationId\n" +
                        "AND CAN.ACCELERATION_ID = ACC.ID \n" +
                        "AND ACC.CHALLENGE_ID = CHA.ID";
    }
}
