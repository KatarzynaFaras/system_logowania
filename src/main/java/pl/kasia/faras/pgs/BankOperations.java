package pl.kasia.faras.pgs;

import java.util.*;

import static pl.kasia.faras.pgs.Utils.*;
import static pl.kasia.faras.pgs.AccountMenu.selectOperation;

public class BankOperations {

    private static Set<Account> accounts = new HashSet<>();

    public static void registration() {
        String enteredLogin = enterLogin();

        if (accountExistsInBank(enteredLogin)) {
            System.out.println("Podany login już istnieje, proszę podać inny");
            registration();
        } else {
            System.out.println("Login zaakceptowany. Proszę podać hasło: ");
            String enteredPassword = enterPassword();
            Account account = new Account(enteredLogin, enteredPassword);
            addAccountToBank(account);
            System.out.println("Rejestracja konta przebiegła pomyślnie.");
            System.out.println("Witaj " + enteredLogin + "! \n");
            AccountMenu.startAccountMenu();
            selectOperation(account);
        }
    }

    public static Account logIn() {
        String login = enterLogin();
        String password = enterPassword();
        Account account = getThisAccountFromBank(login, password);
        if (!accounts.contains(account)) {
            System.out.println("Niepoprawny login lub hasło!");
            logIn();
        } else {
            System.out.println("Zalogowano pomyślnie.");
            System.out.println("Witaj " + login + "! \n");
            AccountMenu.startAccountMenu();
            selectOperation(account);
        }
        return account;
    }

    public static Account addAccountToBank(Account account) {
        for (Account a : accounts) {
            if (a.getLogin().equals(account.getLogin())) {
                return null;
            }
        }
        accounts.add(account);
        return account;
    }

    public static Account getThisAccountFromBank(String login, String password) {
        for (Account account : accounts) {
            if (account.getLogin().equals(login) && (account.getPassword().equals(password))) {
                return account;
            }
        }
        return null;
    }

    public static boolean accountExistsInBank(String login) {
        for (Account account : accounts) {
            if (account.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}






