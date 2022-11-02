package clientinterface;

import model.Account;
import repository.RepositorySingleton;
import service.AdminAcc;

public class Deposit implements BankOp{
    private String accountNumber;
    private double amount;
    private AdminAcc service;

    public Deposit(AdminAcc service, String accountNumber, double amount) {
        this.service = service;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        Account c = RepositorySingleton.getRepository().returnAccount(accountNumber);
        String output = String.format("Cuenta: %s \nNombre del titular de la cuenta: %s \nDeposito de %.2f" ,accountNumber, c.getName(), amount);
        System.out.println(output);
        boolean ok = service.deposit(accountNumber, amount);
        if (!ok) {
            System.out.println("               [ERROR] Deposito no realizado.");
        } else {
            System.out.println("*☆*――*☆*――*☆* Deposito realizado exitosamente *☆*――*☆*――*☆*");
        }
    }
}
