package challenge;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.desafio.CalculadorDeClasses;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class DesafioTest {


    public class ClassA {
        @Somar
        public BigDecimal value = BigDecimal.valueOf(1);
        @Somar
        public BigDecimal valueA = BigDecimal.valueOf(10);
        @Somar
        public BigDecimal valueB = BigDecimal.valueOf(100);
        @Somar
        public BigDecimal valueC = BigDecimal.valueOf(1000);

        @Subtrair
        public BigDecimal valueD = BigDecimal.valueOf(1);
        @Subtrair
        public BigDecimal valueE = BigDecimal.valueOf(10);
        @Subtrair
        public BigDecimal valueF = BigDecimal.valueOf(100);
        @Subtrair
        public BigDecimal valueG = BigDecimal.valueOf(1000);

    }

    @Test
    public void somarTest() {
        BigDecimal total = new CalculadorDeClasses().somar(new ClassA());

        assertEquals(1111, total.intValue());

    }


    @Test
    public void subtrairTest() {
        BigDecimal total = new CalculadorDeClasses().subtrair(new ClassA());

        assertEquals(1111, total.intValue());

    }

    @Test
    public void totalizarTest() {
        BigDecimal total = new CalculadorDeClasses().totalizar(new ClassA());

        assertEquals(0, total.intValue());

    }





}
