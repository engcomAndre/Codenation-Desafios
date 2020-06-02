package br.com.codenation.paymentmethods;

public class OrderCreditCard implements PriceStrategy {

    private final Double DESCONTO = 0.98;

    @Override
    public Double calculate(Double price) {
        return price * DESCONTO;
    }
}
