package model;

public class Account {
    private double amount;
    private String name;
    private String accountNumber;

    public Account(String name, String accountNumber) {
        amount = 0;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public Account(String name, String accountNumber, double amount) {
        this.amount = amount;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
