package services;

import models.Card;
import models.CreditCard;
import models.Deposit;
import models.Product;
import utils.BalanceUtils;
import utils.StringUtils;


public class BankSingleWindow {
    public BankSingleWindow() {
    }

    public void increaseBalance(Product product, float sum) {
        if (sum < 0) {
            throw new RuntimeException("Wrong sum");
        }
        int value = BalanceUtils.getBalanceValue(sum);
        product.increaseBalance(value);
    }

    public void decreaseBalance(Card card, float sum) {
        int value = BalanceUtils.getBalanceValue(sum);
        if (value > card.getBalance().getValue()) {
            throw new RuntimeException("Sum is greater than balance");
        }
        card.decreaseBalance(value);
    }

    public String getBalance(Product product) {
        return product.getBalanceString();
    }

    public void closeDeposit(Deposit deposit) {
        if (!deposit.isOpen()) {
            System.out.println("Deposit is already closed");
        } else {
            deposit.close();
        }
    }

    public String getDebt(CreditCard creditCard) {
        return StringUtils.getMoneyToString(creditCard.requestDebt(), creditCard.getCurrency());
    }
}
