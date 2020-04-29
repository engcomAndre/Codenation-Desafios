package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesafioApplication {

    private static final Integer LIMIT = 350;

    public static List<Integer> fibonacci() {
        List<Integer> sequenciaFibonacci = new ArrayList<>(Arrays.asList(0, 1));

        for (int i = 1; sequenciaFibonacci.get(i) < LIMIT; i++) {
            sequenciaFibonacci.add(sequenciaFibonacci.get(i) + sequenciaFibonacci.get(i - 1));
        }

        return sequenciaFibonacci;
    }

    public static Boolean isFibonacci(Integer a) {
        return fibonacci().contains(a);
    }


}