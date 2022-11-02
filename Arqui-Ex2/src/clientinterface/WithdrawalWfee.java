package clientinterface;

import model.Bank;
import service.AdminAcc;

public class WithdrawalWfee implements BankOp {

    private AdminAcc service;
    private String accountNumber;
    private double amount;
    private Bank bank;

    public WithdrawalWfee(AdminAcc service, String accountNumber, double amount, Bank bank) {
        this.service = service;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.bank = bank;
    }

    @Override
    public void execute() {
        service.withdrawal(accountNumber, amount, bank.getFee());
    }
}
