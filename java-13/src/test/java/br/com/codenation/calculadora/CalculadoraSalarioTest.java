package br.com.codenation.calculadora;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculadoraSalarioTest {

    CalculadoraSalario calculadoraSalario = new CalculadoraSalario();

    @Test
    public void salarioLiquidoIsNotNull() {
        assertNotNull(new CalculadoraSalario().calcularSalarioLiquido(1000.00));
    }

    @Test
    public void calcularValorINSS1000() {
        assertEquals(80, Math.round(calculadoraSalario.calcularInss(1000)));
    }

    @Test
    public void calcularValorINSS1500() {
        assertEquals(120, Math.round(calculadoraSalario.calcularInss(1500)));
    }

    @Test
    public void calcularValorINSS1500_01() {
        assertEquals(135, Math.round(calculadoraSalario.calcularInss(1500.01)));
    }

    @Test
    public void calcularValorINSS10000() {
        assertEquals(1100, Math.round(calculadoraSalario.calcularInss(10000)));
    }

    @Test
    public void calcularValorIRRF1320() {
        assertEquals(0, Math.round(calculadoraSalario.calcularIRRF(1320)));
    }

    @Test
    public void calcularValorIRRF8900() {
        assertEquals(1335, Math.round(calculadoraSalario.calcularIRRF(8900)));
    }

    @Test
    public void calcularSalarioLiquido1000() {
        assertEquals(0, Math.round(calculadoraSalario.calcularSalarioLiquido(1000)));
    }

    @Test
    public void calcularSalarioLiquidomenor1039() {
        assertEquals(0, Math.round(calculadoraSalario.calcularSalarioLiquido(1000)));
    }

    @Test
    public void calcularSalarioLiquido1500() {
        assertEquals(1380, Math.round(calculadoraSalario.calcularSalarioLiquido(1500)));
    }

    @Test
    public void calcularSalarioLiquido10000() {
        assertEquals(7565, Math.round(calculadoraSalario.calcularSalarioLiquido(10000)));
    }
}