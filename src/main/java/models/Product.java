package models;

import constants.Currency;
import lombok.Getter;
import lombok.Setter;


@Getter
public abstract class Product {

    private final Balance balance;
    @Setter
    private String name;

    protected Product(String name, Currency currency) {
        this.name = name;
        this.balance = new Balance(currency);
    }

    public String getBalanceString() {
        return getBalance().toString();
    }

    public Currency getCurrency() {
        return getBalance().getCurrency();
    }

    public void increaseBalance(int value) {
        getBalance().addValue(value);
    }
}
