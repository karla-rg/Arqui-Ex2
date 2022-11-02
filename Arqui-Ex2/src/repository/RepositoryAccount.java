package repository;

import model.Bank;
import model.Account;
import java.util.ArrayList;
import java.util.List;

public class RepositoryAccount{
    private List<Account> accounts;
    private List<Bank> banks;

    RepositoryAccount(){
        Bank A = new Bank("A", 30);
        Bank B = new Bank("B", 15);
        Bank C = new Bank("C", 10);

        banks = new ArrayList<>();
        banks.add(A);
        banks.add(B);
        banks.add(C);

        Account acc1 = new Account("Karla Garcia", "A01655768", 15000.00);
        Account acc2 = new Account("Pepe Diaz", "A01051951");
        Account acc3 = new Account("America Chavez", "A01840787", 1000.00);
        Account acc4 = new Account("Dieguito Maradona", "A01123456", 5000.00);
        Account acc5 = new Account("Adrian Marcelo", "A01494684");
        Account acc6 = new Account("Belinda Torres", "A01544623");
        Account acc7 = new Account("Samuel Garcia", "A01919294", 3500.00);
        Account acc8 = new Account("Roberto Martinez", "A01031478");
        Account acc9 = new Account("Leo Fernandez", "A01366904");
        Account acc10 = new Account("Benito Ocasio", "A01359146", 25000.00);
        accounts = new ArrayList<Account>(List.of(new Account[]{acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8, acc9, acc10}));
    }

    public Account returnAccount(String accountNumber){
        for (Account c: accounts) {
            if(c.getAccountNumber().equalsIgnoreCase(accountNumber)){
                return c;
            }
        }
        return null;
    }

    public void updateAmount(String accountNumber, double amount){
        Account c = returnAccount(accountNumber);
        if (c != null) {
            c.setAmount(amount);
        }
    }

    public List<Bank> getBanks() {
        return banks;
    }

}

