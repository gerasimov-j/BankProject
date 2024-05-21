package unitTests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import constants.Constants;
import models.DebitCard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.StringUtils;

@RunWith(DataProviderRunner.class)
public class DebitCardTests {

    @DataProvider
    public static Object[][] debitCardTest() {
        return new Object[][]{
                {"My card", 505},
                {"", Integer.MAX_VALUE},
                {"", 0}};
    }

    @Test
    @UseDataProvider(value = "debitCardTest")
    public void createDebitCardBalanceTest(String name, int value) {
        DebitCard debitCard = new DebitCard(name);
        Assert.assertEquals("Wrong init balance", 0, debitCard.getBalance().getValue());
    }

    @Test
    @UseDataProvider(value = "debitCardTest")
    public void createDebitCardNameTest(String name, int value) {
        DebitCard debitCard = new DebitCard(name);
        Assert.assertEquals("Wrong name", name, debitCard.getName());
    }

    @Test
    @UseDataProvider(value = "debitCardTest")
    public void createDebitCardCurrencyTest(String name, int value) {
        DebitCard debitCard = new DebitCard(name);
        Assert.assertEquals("Wrong currency", Constants.DEBIT_CURRENCY, debitCard.getCurrency());
    }

    @Test
    @UseDataProvider(value = "debitCardTest")
    public void createDebitCardBalanceStringTest(String name, int value) {
        DebitCard debitCard = new DebitCard(name);
        Assert.assertEquals("Wrong balance string",
                StringUtils.getMoneyToString(0, Constants.DEBIT_CURRENCY), debitCard.getBalanceString());
    }

    @Test
    @UseDataProvider(value = "debitCardTest")
    public void increaseBalanceDebitCardBalanceStringTest(String name, int value) {
        DebitCard debitCard = new DebitCard(name);
        debitCard.increaseBalance(value);
        Assert.assertEquals("Wrong balance string",
                StringUtils.getMoneyToString(value, Constants.DEBIT_CURRENCY), debitCard.getBalanceString());
    }

    @Test
    @UseDataProvider(value = "debitCardTest")
    public void increaseBalanceDebitCardBalanceTest(String name, int value) {
        DebitCard debitCard = new DebitCard(name);
        debitCard.increaseBalance(value);
        Assert.assertEquals("Wrong increasing balance", debitCard.getBalance().getValue(), value);
    }
}
