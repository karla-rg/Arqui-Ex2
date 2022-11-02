package service;

import model.Bank;
import model.Account;
import repository.RepositorySingleton;
import java.util.List;

public class AdminAcc {
    public AdminAcc() {

    }

    //Retiro sin comision
    public void withdrawal(String id, double amount){
        Account c = RepositorySingleton.getRepository().returnAccount(id);
        if (c ==  null) {
            System.out.println("Cuenta invalida - Intenta otra vez [ERROR]");
            return;
        }
        if (amount <= c.getAmount()) {
            double newAmount = c.getAmount() - amount;
            RepositorySingleton.getRepository().updateAmount(id, newAmount);
            String output = String.format("Cuenta: %s \nNombre del titular de la cuenta: %s \nRetiro de %.2f \nSaldo anterior: %.2f \nSaldo nuevo: %.2f" , id, c.getName(), amount, c.getAmount()+amount, c.getAmount());
            System.out.println(output);
        } else {
            System.out.println("Saldo insuficiente - Intenta otra vez [ERROR]");
        }
    }

    //Retiro con comision
    public void withdrawal(String id, double amount, double fee) {
        Account c = RepositorySingleton.getRepository().returnAccount(id);
        if (c ==  null) {
            System.out.println("Cuenta invalida - Intenta otra vez [ERROR]");
            return;
        }
        if ( (amount + fee) <= c.getAmount()) {
            double newAmount = c.getAmount() - amount - fee;
            RepositorySingleton.getRepository().updateAmount(id, newAmount);
            String output = String.format("Cuenta: %s \nNombre del titular de la cuenta: %s \nRetiro con comision por %.2f " +
                    "\nSaldo anterior: %.2f \nSaldo nuevo: %.2f", id, c.getName(), amount + fee, c.getAmount()+amount+fee, c.getAmount());
            System.out.println(output);
        } else {
            System.out.println("Saldo insuficiente - Intenta otra vez [ERROR]");
        }
    }

    public boolean deposit(String id, double amount){
        Account c = RepositorySingleton.getRepository().returnAccount(id);
        if (c ==  null) {
            System.out.println("Cuenta invalida - Intenta otra vez [ERROR]");
            return false;
        }

        double newAmount = c.getAmount() + amount;
        RepositorySingleton.getRepository().updateAmount(id, newAmount);
        return true;
    }

    public void queryAccount(String numCuenta) {
        Account c = RepositorySingleton.getRepository().returnAccount(numCuenta);
        String output = String.format("\n ★彡 Nombre del titular: %s 彡★ \n ★彡  Numero  de  Cuenta: %s   彡★ \n ★彡          Saldo:  $%.2f       彡★ \n ", c.getName(), c.getAccountNumber(), c.getAmount());
        System.out.println(output);
    }

    public List<Bank> getSupportedBanks() {
        return RepositorySingleton.getRepository().getBanks();
    }
}
