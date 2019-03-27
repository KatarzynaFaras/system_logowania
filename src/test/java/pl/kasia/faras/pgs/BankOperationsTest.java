package pl.kasia.faras.pgs;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BankOperationsTest {

    @Test
    public void addAccountToBank() {
        Account account = new Account("jeremi", "3030");
        BankOperations.addAccountToBank(account);
        assertEquals(BankOperations.getThisAccountFromBank("jeremi", "3030"), account);
    }

    @Test
    public void addAccountToBankWhenImpossible() {
        Account account = new Account("jeremi", "3030");
        Account account2 = new Account("jeremi", "2030");
        BankOperations.addAccountToBank(account);
        BankOperations.addAccountToBank(account2);
        assertEquals(BankOperations.getThisAccountFromBank("jeremi", "2030"), null);
    }

    @Test
    public void getThisAccountFromBank() {
        Account account = new Account("jeremi", "3030");
        BankOperations.addAccountToBank(account);
        assertEquals(BankOperations.getThisAccountFromBank("jeremi", "3030"), account);
    }

    @Test
    public void accountExistsInBank() {
        Account account = new Account("jeremi", "3030");
        BankOperations.addAccountToBank(account);
        assertTrue(BankOperations.accountExistsInBank("jeremi"));
    }
}