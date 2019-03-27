package pl.kasia.faras.pgs;

import java.util.Scanner;

public class Utils {

    public static String enterLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj login: ");
        return scanner.next();
    }

    public static String enterPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj hasło: ");
        return scanner.next();
    }

    public static void printBalance(Account account) {
        System.out.println("Twoje saldo: "
                + account.getBalance());
    }

}
