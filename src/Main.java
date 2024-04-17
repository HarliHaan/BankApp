import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for the banking application.
 * This class provides a simple command-line interface for managing bank accounts.
 * It allows users to create bank accounts, make transactions, and view balances and transaction history.
 */
import java.util.Scanner;

/**
 * This is your entry point for running the application.
 * It provides the user interface and orchestrates interactions between the user and the bank accounts.
 * It's responsible for handling user input, displaying menus, and invoking methods on the Bank and BankAccount classes.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        boolean running = true;
        while (running) {
            System.out.println("1. Create bank account number");
            System.out.println("2. Make a transaction");
            System.out.println("3. Show balance");
            System.out.println("4. Show transaction history");
            System.out.println("5. Exit");
            System.out.println("Please select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Enter bank account number: ");
                    String accountNumber = scanner.nextLine();
                    bank.createAccount(accountNumber);
                    System.out.println("Bank account created successfully.");
                    break;
                case 2:
                    performTransaction(scanner, bank);
                    break;
                case 3:
                    showBalance(scanner, bank);
                    break;
                case 4:
                    showTransactionHistory(scanner, bank);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void performTransaction(Scanner scanner, Bank bank) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = bank.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found with account number: " + accountNumber);
            return;
        }

        System.out.print("Enter transaction type (deposit/withdraw): ");
        String transactionType = scanner.next();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        try {
            if (transactionType.equalsIgnoreCase("deposit")) {
                account.deposit(amount);
                System.out.println("Deposit successful.");
            } else if (transactionType.equalsIgnoreCase("withdraw")) {
                account.withdraw(amount);
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Invalid transaction type.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showBalance(Scanner scanner, Bank bank) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = bank.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found with account number: " + accountNumber);
            return;
        }

        System.out.println("Balance: €" + account.getBalance());
    }

    private static void showTransactionHistory(Scanner scanner, Bank bank) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = bank.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found with account number: " + accountNumber);
            return;
        }

        System.out.println("Transaction History:");
        for (String transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}
