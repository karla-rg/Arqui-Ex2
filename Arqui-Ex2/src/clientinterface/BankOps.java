package clientinterface;

import model.Bank;
import service.AdminAcc;

public class BankOps
{
    private AdminAcc service;

    public BankOps(AdminAcc service) {
        this.service = service;
    }

    public AdminAcc getService() {
        return service;
    }

    public void setService(AdminAcc service) {
        this.service = service;
    }

    public BankOp createDeposit(String accountNumber, double amount) {
        return new Deposit(this.service, accountNumber, amount);
    }

    public BankOp createWithdrawal(String accountNumber, double amount) {
        return new Withdrawal(this.service, accountNumber, amount);
    }

    public BankOp createWithdrawalWfee(String accountNumber, double amount, Bank bank) {
        return new WithdrawalWfee(this.service, accountNumber, amount, bank);
    }

    public BankOp createQuery(String accountNum) {
        return new SearchAccount(this.service, accountNum);
    }
}