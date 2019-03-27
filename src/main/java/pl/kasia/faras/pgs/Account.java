package pl.kasia.faras.pgs;

import java.math.BigDecimal;
import java.util.Objects;

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

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void remittanceToAccount(BigDecimal remittanceValue) {
        balance = this.balance.add(remittanceValue);
        System.out.println("Twoje saldo po wpłacie: " + balance);
    }

    public void payOutFromAccount(BigDecimal payOutValue) {
        if (payOutValue.doubleValue() <= balance.doubleValue()) {
            balance = balance.subtract(payOutValue);
            System.out.println("Twoje saldo po wypłacie: " + balance);
        } else {
            System.out.println("Zbyt mało pieniędzy na koncie.");
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
        return "login :" + login
                + "password: " + password;
    }
}
