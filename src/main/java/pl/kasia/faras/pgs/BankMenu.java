package pl.kasia.faras.pgs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankMenu {

    public static void startBankMenu(){
        System.out.println("Witaj w naszym banku. " + "\n");
        selectOperationFromBankMenu();
    }

        public static void selectOperationFromBankMenu() {
            try {
                System.out.println("1 - Zaloguj się." + "\n"
                        + "2 - Zarejestruj się");
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
                        selectOperationFromBankMenu();
                }
            } catch (InputMismatchException ime) {
                System.out.println("Proszę wybrac opcję dostępną w menu.");
                selectOperationFromBankMenu();
            }
        }
    }
