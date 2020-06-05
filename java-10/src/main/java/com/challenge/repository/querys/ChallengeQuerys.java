package com.challenge.repository.querys;

public final class ChallengeQuerys {
    public static final class SELECT {
        public static final String BY_USER_ID_AND_ACCELERATION_ID_AND_CHALLENGE_ID =
                "SELECT CHA.*\n" +
                "FROM\n" +
                "    CANDIDATE CAN, \n" +
                "    ACCELERATION ACC,\n" +
                "    CHALLENGE CHA\n" +
                "WHERE\n" +
                "    CAN.USER_ID = :userId\n" +
                "AND CAN.ACCELERATION_ID = :accelerationId\n" +
                "AND CAN.ACCELERATION_ID = ACC.ID \n" +
                "AND ACC.CHALLENGE_ID = CHA.ID";
    }
}
