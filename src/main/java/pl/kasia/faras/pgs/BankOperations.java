package pl.kasia.faras.pgs;

import java.util.*;

public class BankOperations {

    private static Set<Account> accounts = new HashSet<>();

    public static void registration() {
        String enteredLogin = enterLogin();

        if (loginExists(enteredLogin)) {
            System.out.println("Podany login już istnieje, proszę podać inny");
            registration();
        } else {
            System.out.println("Login zaakceptowany. Proszę podać hasło: ");
            String enteredPassword = enterPassword();
            addAccountToBank(enteredLogin, enteredPassword);
            Account account = getThisAccountFromBank(enteredLogin,enteredPassword);
            System.out.println("Rejestracja konta przebiegła pomyślnie.");
            System.out.println("Witaj " + enteredLogin + "! \n");
            AccountMenu.startAccountMenu();
            account.selectOperation();
        }
    }

    public static void logIn() {
        String login = enterLogin();
        String password = enterPassword();
        Account account = getThisAccountFromBank(login,password);
        if (account == null) {
            System.out.println("Niepoprawny login lub hasło!");
            logIn();
        } else  {
            System.out.println("Zalogowano pomyślnie.");
            System.out.println("Witaj " + login + "! \n");
            AccountMenu.startAccountMenu();
            account.selectOperation();
        }
    }


    public static Account addAccountToBank(String login, String password) {
        if (!loginExists(login)) {
            Account account = new Account(login, password);
            accounts.add(account);
            return account;
        } return null;
    }

    public static Account getThisAccountFromBank(String login, String password) {
        for (Account account : accounts) {
            if (account.getLogin().equals(login)&&(account.getPassword().equals(password))) {
                return account;
            }
        }
        return null;
    }
    public static boolean loginExists(String login) {
        for (Account account : accounts) {
            if (account.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }



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
}




