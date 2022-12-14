package com.reanima.exceptions;

class Amount {
    private String currency;
    private int amount;

    public Amount(String currency, int amount) {
        super();
        this.currency = currency;
        this.amount = amount;
    }
    public void add(Amount that) {
        if(!this.currency.equals(that.currency)) {
            //throw new Exception("Currencies don't match!");
            throw new CurrenciesDoNotMatchException("Currencies don't match!");
        }
        this.amount = this.amount + that.amount;
    }

    public String toString() {
        return amount + " " + currency;
    }
}

class CurrenciesDoNotMatchException extends RuntimeException {
    public CurrenciesDoNotMatchException(String msg) {
        super(msg);
    }
}
public class ThrowingExceptionRunner {
    public static void main(String[] args) {
        Amount amount1 = new Amount("USD", 10);
        Amount amount2 = new Amount("EUR", 20);
        amount1.add(amount2);
        System.out.println(amount1);
    }
}
