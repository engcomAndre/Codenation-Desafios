package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Arrays;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object obj) {
        return executarOperacao(obj, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        return executarOperacao(obj, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        return this.somar(obj).subtract(this.subtrair(obj));
    }

    private BigDecimal executarOperacao(Object obj, Class<? extends Annotation> annotationClass) {

        final BigDecimal[] out = {BigDecimal.ZERO};

        Arrays.asList(obj.getClass().getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);

            if (field.isAnnotationPresent(annotationClass) && BigDecimal.class.equals(field.getType())) {
                try {
                    out[0] = out[0].add((BigDecimal) field.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        });

        return out[0];

    }
}
