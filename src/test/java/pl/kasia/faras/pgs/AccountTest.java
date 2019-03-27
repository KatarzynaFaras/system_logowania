package pl.kasia.faras.pgs;

import org.junit.*;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;
import static pl.kasia.faras.pgs.BankOperations.addAccountToBank;

public class AccountTest {

    Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account("jaki", "234");
        addAccountToBank(account);
    }

    @Test
    public void getLogin() {
        assertEquals(account.getLogin(), "jaki");
    }

    @Test
    public void getPassword() {
        assertEquals(account.getPassword(), "234");
    }

    @Test
    public void getBalance() {
        assertEquals(account.getBalance(), BigDecimal.ZERO);
    }

    @Test
    public void remittanceToAccount() {
        account.remittanceToAccount(BigDecimal.valueOf(100));
        assertEquals(account.getBalance(), BigDecimal.valueOf(100));
    }

    @Test
    public void payOutFromAccountWhenPossible() {
        account.remittanceToAccount(BigDecimal.valueOf(100));
        account.payOutFromAccount(BigDecimal.valueOf(100));
        assertEquals(account.getBalance(), BigDecimal.ZERO);
    }

    @Test
    public void payOutFromAccountWhenImpossible() {
        account.remittanceToAccount(BigDecimal.valueOf(100));
        account.payOutFromAccount(BigDecimal.valueOf(200));
        Assert.assertEquals(account.getBalance(), BigDecimal.valueOf(100));
    }
}