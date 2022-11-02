package clientinterface;

import model.Bank;
import service.AdminAcc;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientInterface{
    AdminAcc service;
    private BankOps ops;
    private ArrayList<Bank> banks;
    private boolean end;
    private Scanner in;

    private final String[] options = {
            "Buscar detalles cuenta",
            "Realizar un deposito  ",
            "Realizar un retiro    ",
            "Realizar retiro en ATM",
    };

    public ClientInterface() {
        service = new AdminAcc();
        ops = new BankOps(service);
        banks = (ArrayList<Bank>) service.getSupportedBanks();
        end = false;
        in = new Scanner(System.in);
        System.out.println("★・・・・・・・★・・・・・ SISTEMA BANCARIO ALIANZZA ・・・・・★・・・・・・・★\n");
    }

    private void choose() {
        for (int i=0; i<options.length; i++) {
            System.out.printf(" ░▒▓█ ░▒▓█▓▒░▒▓█▓▒░▒▓ %d.- %s ░▒▓█ ░▒▓█▓▒░▒▓█▓▒░▒▓ %n", i+1, options[i]);
        }
        System.out.println("\n !! ━―━―━―━―━―━―━―━―━―━― Presiona 5 para salir ━―━―━―━―━―━―━―━―━―━― !!\n");
    }

    private Bank selectBank() {
        int i = 0;
        for (Bank b : banks) {
            System.out.println("★━━━━━━━━━━━━━━━━★ %d -- Banco %s (Comision de $%.2f) ★━━━━━━━━━━━━━━━━★".formatted(i + 1, b.getBankName(), b.getFee()));
            i++;
        }
        Integer selection = -1;
        while (true) {
            System.out.print("Selecciona el banco de tu preferencia: ");
            selection = in.nextInt();
            in.nextLine();
            if (selection > 0 && selection <= banks.size()) {
                break;
            }
            else {
                System.out.println("[ERROR] Opcion invalida.");
            }
        }
        return banks.get(selection - 1);
    }

    public void displayOptions() {
        int selection = -1;
        choose();
        System.out.print("Selecciona una opcion: ");
        selection = in.nextInt();
        in.nextLine();

        switch (selection) {
            case 1:
                System.out.println("～●～●～●～●～●～●～●～●～●～ CONSULTAR CUENTA ～●～●～●～●～●～●～●～●～●～");
                letsQuery();
                break;
            case 2:
                System.out.println("～●～●～●～●～●～●～●～●～●～●～ DEPOSITO ～●～●～●～●～●～●～●～●～●～●～");
                letsDeposit();
                break;
            case 3:
                System.out.println("～●～●～●～●～●～●～●～●～●～●～ RETIRO ～●～●～●～●～●～●～●～●～●～●～");
                letsWithdrawal();
                break;
            case 4:
                System.out.println("～●～●～●～●～●～●～●～●～ RETIRO EN ATM ～●～●～●～●～●～●～●～●～");
                letsWithdrawalWfee();
                break;
            case 5:
                end = true;
                System.out.println("♡♥ GRACIAS POR UTILIZAR EL SISTEMA BANCARIO ALIANZZA - Vuelve pronto ♡♥");
                System.exit(0);
                break;
            default:
                System.out.println("[ERROR] Opcion invalida.");
        }
        System.out.println("1 -- Menu principal");
        System.out.println("2 -- Salir");
        System.out.print("-> ");
        int again = in.nextInt();
        in.nextLine();
        if (again!= 1) {
            end = true;
        }
    }

    private void letsQuery() {
        System.out.print("Ingresa no. de Cuenta de 9 digitos: ");
        String accountNum = in.nextLine();
        BankOp query = ops.createQuery(accountNum);
        sendOperation(query);
    }

    private void letsDeposit() {
        System.out.print("Ingresa no. de Cuenta de 9 digitos: ");
        String accountNum = in.nextLine();
        System.out.print("Monto de deposito -> $");
        Double amount = in.nextDouble();
        BankOp deposit = ops.createDeposit(accountNum, amount);
        sendOperation(deposit);
    }

    private void letsWithdrawalWfee() {
        Bank bank = selectBank();
        System.out.print("Ingresa no. de Cuenta de 9 digitos: ");
        String accountNum = in.nextLine();
        System.out.print("Monto de retiro -> $");
        Double amount = in.nextDouble();
        BankOp createWithdrawalWfee = ops.createWithdrawalWfee(accountNum, amount, bank);
        sendOperation(createWithdrawalWfee);
    }

    private void letsWithdrawal() {
        System.out.print("Ingresa no. de Cuenta de 9 digitos: ");
        String accountNum = in.nextLine();
        System.out.print("Monto de retiro -> $");
        Double amount = in.nextDouble();
        BankOp withdrawal = ops.createWithdrawal(accountNum, amount);
        sendOperation(withdrawal);
    }

    private void sendOperation(BankOp command) {
        command.execute();
    }

    public boolean isDone() {
        return end;
    }
}