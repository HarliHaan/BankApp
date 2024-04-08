import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for the banking application.
 * This class provides a simple command-line interface for managing bank accounts.
 * It allows users to create bank accounts, make transactions, and view balances and transaction history.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        boolean running = true;
        while (running) {
            System.out.println("1. Create bank account number");
            System.out.println("2. Make a transaction");
            System.out.println("3. Show balance");
            System.out.println("4. Show transaction history");
            System.out.println("5. Exit");
            System.out.println("Please select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter bank account number: ");
                    String accountNumber = scanner.nextLine();
                    account = new BankAccount(accountNumber); // Create bank account
                    System.out.println("Bank account created successfully.");
                    break;
                case 2:
                    if (account == null) {
                        System.out.println("Please create a bank account first.");
                        break;
                    }
                    System.out.println("Enter transaction type (deposit/ withdraw): ");
                    String transactionType = scanner.next();
                    System.out.println("Enter amount: ");
                    double amount = scanner.nextDouble();
                    try {
                        if (transactionType.equalsIgnoreCase("deposit")) {
                            account.deposit(amount);
                            System.out.println("Deposit successful.");
                        } else if (transactionType.equalsIgnoreCase("withdraw")) {
                            account.withdraw(amount);
                            System.out.println("Withdrawal successful. ");
                        } else {

                            System.out.println("Invalid transaction type.");
                        }
                    }catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case 3:
                    if (account == null) {
                        System.out.println("Please create a bank account first.");
                        break;
                    }
                    System.out.println("Balance: €" + account.getBalance());
                    break;
                case 4:
                    if (account == null){
                        System.out.println("Please create a bank account first.");
                        break;
                    }
                    ArrayList<String> history = account.getTransactionHistory();
                    System.out.println("Transaction History:");
                    for (String transaction : history){
                        System.out.println(transaction);
                    }
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

}

