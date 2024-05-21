package unitTests;

import models.DebitCard;
import org.junit.Assert;
import org.junit.Test;
import services.BankSingleWindow;
import utils.BalanceUtils;

public class BankIncreaseBalanceTests {

    @Test
    public void debitCardBalanceTest() {
        float sum = 3.32f;
        DebitCard debitCard = new DebitCard("Card");
        BankSingleWindow bank = new BankSingleWindow();
        bank.increaseBalance(debitCard, sum);
        Assert.assertEquals("Wrong balance",
                BalanceUtils.getBalanceValue(sum), debitCard.getBalance().getValue());
    }

    @Test
    public void creditCardBalanceTest() {
        float sum = -3.55f;
        DebitCard debitCard = new DebitCard("Card");
        BankSingleWindow bank = new BankSingleWindow();
        Assert.assertThrows(RuntimeException.class, () -> bank.increaseBalance(debitCard, sum));
    }

}
