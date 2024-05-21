package models;

import constants.Currency;

public abstract class CreditCard extends Card {

    private int rate;
    protected CreditCard(String name, Currency currency) {
        super(name, currency);
    }

    public abstract int requestDebt();
}
