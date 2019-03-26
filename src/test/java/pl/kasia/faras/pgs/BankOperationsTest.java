package pl.kasia.faras.pgs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankOperationsTest {

    private BankOperations bankOperations;

    @Before
    public void setUp() {

        BankOperations.addAccountToBank("kasia", "123");

    }

    @Test
    public void addAccountWhenPossible() {
        Account account = BankOperations.addAccountToBank("ewa", "123");
        Assert.assertEquals(BankOperations.getThisAccountFromBank("ewa", "123"), account);
    }

    @Test
    public void addAccountWhenInPossible() {
        BankOperations.addAccountToBank("kasia", "xxx");
        Assert.assertNull(BankOperations.getThisAccountFromBank("kasia", "xxx"));

    }

    @Test
    public void getThisAccountFromBankWhenItIsNotAddToBank() {

        Assert.assertNull(BankOperations.getThisAccountFromBank("kasia", "xxx"));

    }
    @Test
    public void getThisAccountFromBank() {

        Assert.assertNotNull(BankOperations.getThisAccountFromBank("kasia", "123"));

    }

}