package clientinterface;

import service.AdminAcc;

public class Withdrawal implements BankOp {

    private AdminAcc service;
    private String accountNumber;
    private double amount;

    public Withdrawal(AdminAcc service, String accountNumber, double amount) {
        this.service = service;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        service.withdrawal(accountNumber, amount);
    }
}
