package models;

import constants.Constants;

public class DebitCard extends Card {

    public DebitCard(String name) {
        super(name, Constants.DEBIT_CURRENCY);
    }
}
