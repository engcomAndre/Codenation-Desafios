package br.com.codenation.paymentmethods;

public class OrderCash implements PriceStrategy {

    private final Double DESCONTO = 0.9;

    @Override
    public Double calculate(Double price) {
        return price * DESCONTO;
    }
}
