package br.com.codenation.paymentmethods;

public enum PaymentMethod {

    CASH(new OrderCash()), DEBIT_CARD(new OrderDebitCard()), CREDIT_CARD(new OrderCreditCard()), TRANSFER(new OrderTransfer());

    private PriceStrategy priceStrategy;

    PaymentMethod(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPaymentStrategy() {
        return priceStrategy;
    }
}