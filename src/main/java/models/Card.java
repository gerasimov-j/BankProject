package models;

import constants.Currency;

public abstract class Card extends Product {

    protected Card(String name, Currency currency) {
        super(name, currency);
    }

    public void decreaseBalance(int value) {
        getBalance().addValue(-value);
    }
}
