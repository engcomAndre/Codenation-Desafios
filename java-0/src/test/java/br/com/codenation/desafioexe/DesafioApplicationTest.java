package br.com.codenation.desafioexe;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DesafioApplicationTest {

    @Test
    public void fibonacci() {
        assertNotNull(DesafioApplication.fibonacci());
    }

    @Test
    public void isFibonacci() {
        assertTrue(DesafioApplication.isFibonacci(1));
    }

    @Test
    public void test(){
        DesafioApplication.fibonacci();
    }


}
