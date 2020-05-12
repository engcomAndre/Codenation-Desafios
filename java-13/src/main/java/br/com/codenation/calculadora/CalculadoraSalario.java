package br.com.codenation.calculadora;


import br.com.codenation.calculadora.config.CalculadoraConfig.INSS;
import br.com.codenation.calculadora.config.CalculadoraConfig.IRRF;

import static br.com.codenation.calculadora.config.CalculadoraConfig.CALCULADORA_CONFIG.SALARIO_MINIMO;

public class CalculadoraSalario {

    public long calcularSalarioLiquido(double salarioBase) {
        double salarioLiquido = salarioBase < SALARIO_MINIMO ? 0.0 : salarioBase - calcularDescontos(salarioBase);
        return Math.round(salarioLiquido);
    }

    public double calcularDescontos(double salarioBase) {
        double descontoINSS = calcularInss(salarioBase);
        double descontoIRRF = calcularIRRF(salarioBase - descontoINSS);
        return descontoINSS + descontoIRRF;
    }

    public double calcularInss(double salarioBase) {

        if (salarioBase >= INSS.FAIXA_1.LIMITE_MIN && salarioBase <= INSS.FAIXA_1.LIMITE_MAX)
            return salarioBase * INSS.FAIXA_1.PORCENTAGEM_FAIXA;

        if (salarioBase > INSS.FAIXA_2.LIMIT_MIN && salarioBase <= INSS.FAIXA_2.LIMIT_MAX)
            return salarioBase * INSS.FAIXA_2.PORCENTAGEM_FAIXA;

        return salarioBase * INSS.FAIXA_3.PORCENTAGEM_FAIXA;
    }

    public double calcularIRRF(double valorReferencia) {
        if (valorReferencia >= IRRF.FAIXA_1.LIMITE_MIN && valorReferencia <= IRRF.FAIXA_1.LIMITE_MAX)
            return valorReferencia * IRRF.FAIXA_1.PORCENTAGEM_FAIXA;

        if (valorReferencia >= IRRF.FAIXA_2.LIMIT_MIN && valorReferencia <= IRRF.FAIXA_2.LIMIT_MAX)
            return valorReferencia * IRRF.FAIXA_2.PORCENTAGEM_FAIXA;

        return valorReferencia * IRRF.FAIXA_3.PORCENTAGEM_FAIXA;
    }
}
