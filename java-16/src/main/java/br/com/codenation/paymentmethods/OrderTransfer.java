package br.com.codenation.paymentmethods;

public class OrderTransfer implements PriceStrategy {

    private final Double DESCONTO = 0.92;

    @Override
    public Double calculate(Double price) {
        return price * DESCONTO;
    }
}
