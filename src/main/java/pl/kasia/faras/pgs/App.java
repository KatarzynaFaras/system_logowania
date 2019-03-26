package pl.kasia.faras.pgs;

public class App {

    public static void main(String[] args) {
//add some accounts to the bank
        BankOperations.addAccountToBank("kasia", "123");
        BankOperations.addAccountToBank("edi", "edi16");
        BankOperations.addAccountToBank("czarnula123", "fafik");
//startBankMenu
        BankMenu.startBankMenu();
    }
}
