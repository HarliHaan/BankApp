import java.lang.IllegalArgumentException;
import java.util.ArrayList;

/**
 * This class represents individual bank accounts.
 * It manages account-specific operations such as deposit, withdrawal, balance retrieval, and transaction history.
 * It's focused on the behavior and data related to a single account.
 */

public class BankAccount {
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 5000;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.transactionHistory.add("Deposited €" + amount);
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance -= amount;
        this.transactionHistory.add("Withdrew €" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
}
