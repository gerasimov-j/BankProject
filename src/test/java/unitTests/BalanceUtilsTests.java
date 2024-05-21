package unitTests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BalanceUtils;

@RunWith(DataProviderRunner.class)
public class BalanceUtilsTests {

    @DataProvider
    public static Object[][] balanceTest() {
        return new Object[][]{
                {5.05f, 505},
                {-5f, -500},
                {5.050004f, 505}};
    }

    @Test
    @UseDataProvider(value = "balanceTest")
    public void balanceUtilsTest(float sum, int result) {
        int balanceValue = BalanceUtils.getBalanceValue(sum);
        Assert.assertEquals("Wrong value", result, balanceValue);
    }
}
