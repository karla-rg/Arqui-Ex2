package model;

public class Bank {
    private String bankName;
    private double fee;

    public Bank(String bankName, double fee) {
        this.bankName = bankName;
        this.fee = fee;
    }

    public String getBankName() {
        return bankName;
    }

    public double getFee() {
        return fee;
    }
}
