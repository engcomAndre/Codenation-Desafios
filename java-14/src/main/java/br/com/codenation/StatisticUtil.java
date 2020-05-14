package br.com.codenation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StatisticUtil {

    public static int average(int[] elements) {
        return ((int) IntStream.of(elements).average().orElseThrow(IllegalAccessError::new));
    }

    public static int mode(int[] elements) {
        Arrays.sort(elements);

        int moda = elements[0];
        int qnts_moda = 1;
        int contador = 1;
        for (int el = 1; el < elements.length; el++) {

            if (moda == elements[el]) qnts_moda++;
            else if (elements[el - 1] == elements[el]) contador++;
            else if ((elements[el - 1] != elements[el])) contador = 1;

            if (contador > qnts_moda) {
                moda = elements[el];
                qnts_moda = contador;
                contador = 1;
            }
        }
        return moda;
    }

    public static int median(int[] elements) {
        Arrays.sort(elements);

        if ((elements.length % 2) != 0) {
            return elements[elements.length / 2];
        } else {
            return ((elements[-1 + elements.length / 2]) + (elements[elements.length / 2])) / 2;
        }
    }
}