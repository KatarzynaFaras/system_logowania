package pl.kasia.faras.pgs;

import java.util.Scanner;

import static pl.kasia.faras.pgs.Utils.printBalance;
import static pl.kasia.faras.pgs.AccountOperations.*;

public class AccountMenu {

    public static void startAccountMenu() {
        System.out.println(
                "1 - Wpłata." + "\n"
                        + "2 - Wypłata" + "\n"
                        + "3 - Saldo." + "\n"
                        + "4 - Wyloguj." + "\n");
    }

    public static void selectOperation(Account account) {
        Scanner scanner = new Scanner(System.in);
        Integer a = scanner.nextInt();

        switch (a) {
            case 1:
                chooseRemittance(account);
                break;
            case 2:
                choosePayOut(account);
                break;
            case 3:
                printBalance(account);
                startAccountMenu();
                selectOperation(account);
                break;
            case 4:
                System.out.println("Wylogowano pomyślnie.");
                BankMenu.startBankMenu();
                BankMenu.selectOperationFromBankMenu();
                break;
            default:
                System.out.println("Proszę wybrac opcję dostępną w menu.");
                startAccountMenu();
                selectOperation(account);
        }
    }
}
