package pl.kasia.faras.pgs;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class AccountTest {

    private Account account1;

    @Before
    public void setUp() {

        this.account1 = BankOperations.addAccountToBank("max", "123");
    }

    @Test
    public void getLogin() {
        Assert.assertEquals(account1.getLogin(), "max");
    }

    @Test
    public void getPassword() {
        Assert.assertEquals(account1.getPassword(), "123");
    }

    @Test
    public void getBalance() {
       Assert.assertEquals(account1.getBalance(), BigDecimal.valueOf(0));
    }

    @Test
    public void remittance200WhenBalance0() {
        account1.remittanceToAccount(BigDecimal.valueOf(200));
        Assert.assertEquals(account1.getBalance(), BigDecimal.valueOf(200));
    }

    @Test
    public void payOut200WhenBalance100() {
        account1.payOutFromAccount(BigDecimal.valueOf(200));
        Assert.assertEquals(account1.getBalance(), BigDecimal.valueOf(0));
    }

    @Test
    public void payOut100WhenBalance100() {
        account1.remittanceToAccount(BigDecimal.valueOf(100));
        account1.payOutFromAccount(BigDecimal.valueOf(100));
        Assert.assertEquals(account1.getBalance(), BigDecimal.ZERO);
    }
}