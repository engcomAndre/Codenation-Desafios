package br.com.codenation.paymentmethods;

import br.com.codenation.paymentmethods.PriceStrategy;

public class OrderDebitCard implements PriceStrategy {

    private final Double DESCONTO = 0.95;

    @Override
    public Double calculate(Double price) {
        return price * DESCONTO;
    }
}
