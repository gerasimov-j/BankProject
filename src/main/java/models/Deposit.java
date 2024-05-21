package models;

import constants.Currency;
import lombok.Getter;

public class Deposit extends Product {

    @Getter
    private boolean isOpen;
    protected Deposit(String name, Currency currency) {
        super(name, currency);
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }
}
