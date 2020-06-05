package com.challenge.repository.querys;

public final class SubmissionQuerys {
    public static final class SELECT {
        public static final String BY_CHALLENGE_ID =
                "SELECT MAX(SUB.SCORE) \n" +
                "FROM \n" +
                "    SUBMISSION SUB\n" +
                "WHERE\n" +
                "    SUB.CHALLENGE_ID = :challengeId";

        public static final String BY_CHALLENGE_ID_AND_ACCELERATION_ID =
                "SELECT SUB.*\n" +
                "FROM \n" +
                "    SUBMISSION SUB,\n" +
                "    ACCELERATION ACC        \n" +
                "WHERE\n" +
                "    SUB.CHALLENGE_ID = :challengeId\n" +
                "AND ACC.ID  = :accelerationId";
    }
}
