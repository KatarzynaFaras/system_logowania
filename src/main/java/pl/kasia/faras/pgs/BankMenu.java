package pl.kasia.faras.pgs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankMenu {

    public static void startBank() {
        System.out.println("Witaj w naszym banku. " + "\n");
        startBankMenu();
        selectOperationFromBankMenu();
    }

    public static void startBankMenu() {

        System.out.println("1 - Zaloguj się." + "\n"
                + "2 - Zarejestruj się");
    }

    public static void selectOperationFromBankMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            Integer a = scanner.nextInt();

            switch (a) {
                case 1:
                    BankOperations.logIn();
                    break;
                case 2:
                    BankOperations.registration();
                    break;
                default:
                    System.out.println("Proszę wybrac opcję dostępną w menu.");
                    startBankMenu();
                    selectOperationFromBankMenu();
            }
        } catch (InputMismatchException ime) {
            System.out.println("Proszę wybrac opcję dostępną w menu.");
            startBankMenu();
            selectOperationFromBankMenu();
        }
    }
}
