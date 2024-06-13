package model.entities;

import model.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;

    public Account(Integer number, String holder, Double initialDeposit, Double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.withDrawLimit = withDrawLimit;
        deposit(initialDeposit);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithDraw() {
        return withDrawLimit;
    }

    public void setWithDraw(Double withDraw) {
        this.withDrawLimit = withDraw;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withDraw(double amount) {

        if (amount > getWithDraw()) {
            throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (amount > getBalance()) {
            throw new DomainException("Withdraw error: Not enough balance");
        }
        balance-=amount;
        System.out.printf("New balance: $%.2f",balance);
    }
}
