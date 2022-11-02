package clientinterface;

import service.AdminAcc;

public class SearchAccount implements BankOp {
    private String accountNumber;
    AdminAcc service;

    SearchAccount(AdminAcc service, String accountNumber) {
        this.service = service;
        this.accountNumber = accountNumber;
    }

    @Override
    public void execute() {
        service.queryAccount(accountNumber);
    }
}