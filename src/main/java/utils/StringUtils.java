package utils;

import constants.Currency;

public class StringUtils {

    public static String getMoneyToString(int value, Currency currency) {
        return String.format("%.2f %s", value / 100.0, currency.getName());
    }
}
