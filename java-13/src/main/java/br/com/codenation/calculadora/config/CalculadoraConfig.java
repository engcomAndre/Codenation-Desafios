package br.com.codenation.calculadora.config;

public class CalculadoraConfig {
    public final static class CALCULADORA_CONFIG {
        public final static Integer SALARIO_MINIMO = 1039;
    }

    public final static class INSS {
        public static final class FAIXA_1 {
            public final static double LIMITE_MIN = 0;
            public final static double LIMITE_MAX = 1500;
            public final static double PORCENTAGEM_FAIXA = 0.08;
        }

        public static final class FAIXA_2 {
            public final static double LIMIT_MIN = 1500;
            public final static double LIMIT_MAX = 4000;
            public final static double PORCENTAGEM_FAIXA = 0.09;
        }

        public static final class FAIXA_3 {
            public final static double LIMIT_MIN = 4000.01;
            public final static double LIMIT_MAX = Double.POSITIVE_INFINITY;
            public final static double PORCENTAGEM_FAIXA = 0.11;
        }
    }

    public final static class IRRF {
        public static final class FAIXA_1 {
            public final static double LIMITE_MIN = 0;
            public final static double LIMITE_MAX = 3000;
            public final static double PORCENTAGEM_FAIXA = 0;
        }

        public static final class FAIXA_2 {
            public final static double LIMIT_MIN = 3000.01;
            public final static double LIMIT_MAX = 6000;
            public final static double PORCENTAGEM_FAIXA = 0.075;
        }

        public static final class FAIXA_3 {
            public final static double LIMIT_MIN = 6000;
            public final static double LIMIT_MAX = Double.POSITIVE_INFINITY;
            public final static double PORCENTAGEM_FAIXA = 0.15;
        }
    }
}
