package pl.kasia.faras.pgs;

import java.util.InputMismatchException;
import java.util.Scanner;
import static pl.kasia.faras.pgs.AccountMenu.selectOperation;

public class AccountOperations {

    public static   void chooseRemittance(Account account) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj kwotę wpłaty: ");
            account.remittanceToAccount(scanner.nextBigDecimal());
            AccountMenu.startAccountMenu();
            selectOperation(account);
        } catch (InputMismatchException iMe) {
            System.out.println("Proszę wpisać kwotę z przecinkiem zamiast kropki.");
            chooseRemittance(account);
        }
    }
    public static void choosePayOut(Account account) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj kwotę do wypłacenia: ");
            account.payOutFromAccount(scanner.nextBigDecimal());
            AccountMenu.startAccountMenu();
            selectOperation(account);
        } catch (InputMismatchException iMe) {
            System.out.println("Proszę wpisać kwotę z przecinkiem zamiast kropki");
            choosePayOut(account);
        }
    }
}
