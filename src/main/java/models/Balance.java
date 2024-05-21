package models;

import constants.Currency;
import lombok.Getter;
import lombok.Setter;
import utils.StringUtils;


public class Balance {
    @Getter
    private final Currency currency;
    @Getter
    @Setter
    private int value;

    public Balance(Currency currency) {
        this.currency = currency;
        this.value = 0;
    }

    @Override
    public String toString() {
        return StringUtils.getMoneyToString(getValue(), getCurrency());
    }

    public void addValue(int value) {
        this.value += value;
    }
}
