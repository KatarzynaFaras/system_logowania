package pl.kasia.faras.pgs;

import static pl.kasia.faras.pgs.BankMenu.startBank;
import static pl.kasia.faras.pgs.BankOperations.addAccountToBank;

public class App {

    public static void main(String[] args) {

        Account account1 = new Account("edi", "edi16");
        addAccountToBank(account1);
        //add some accounts to the bank

        startBank();
        //startBank
    }
}
