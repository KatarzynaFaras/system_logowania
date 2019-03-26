package pl.kasia.faras.pgs;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Account {

    private String login;
    private String password;
    private BigDecimal balance;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
        this.balance = BigDecimal.ZERO;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void printBalance() {
        System.out.println("Twoje saldo: " + this.balance);
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public  void remittanceToAccount(BigDecimal remittanceValue) {
        balance = this.balance.add(remittanceValue);
        System.out.println("Twoje saldo po wpłacie: " + balance);
    }

    public void payOutFromAccount(BigDecimal payOutValue) {
        if (payOutValue.doubleValue() <= this.balance.doubleValue()) {
            this.balance = balance.subtract(payOutValue);
            System.out.println("Twoje saldo po wypłacie: " + this.balance);
        } else {
            System.out.println("Zbyt mało pieniędzy na koncie.");
        }
    }
    public  void selectOperation() {
        Scanner scanner = new Scanner(System.in);
        Integer a = scanner.nextInt();

        switch (a) {
            case 1:
                chooseRemittance();
                break;
            case 2:
                choosePayOut();
                break;
            case 3:
                printBalance();
                AccountMenu.startAccountMenu();
                selectOperation();
                break;
            case 4:
                System.out.println("Wylogowano pomyślnie.");
                BankMenu.selectOperationFromBankMenu();
                break;
            default:
                System.out.println("Proszę wybrac opcję dostępną w menu.");
                AccountMenu.startAccountMenu();
                selectOperation();
        }

    }

    public void chooseRemittance() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj kwotę wpłaty: ");
            remittanceToAccount(scanner.nextBigDecimal());
            AccountMenu.startAccountMenu();
            selectOperation();
        } catch (InputMismatchException iMe) {
            System.out.println("Proszę wpisać kwotę z przecinkiem zamiast kropki.");
            chooseRemittance();
        }
    }
    public  void choosePayOut() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj kwotę do wypłacenia: ");
            payOutFromAccount(scanner.nextBigDecimal());
            AccountMenu.startAccountMenu();
            selectOperation();
        } catch (InputMismatchException iMe) {
            System.out.println("Proszę wpisać kwotę z przecinkiem zamiast kropki");
            choosePayOut();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(login, account.login) &&
                Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return "Account: " +
                "login " + login;
    }
}
