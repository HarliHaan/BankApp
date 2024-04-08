import java.lang.IllegalArgumentException;
import java.util.ArrayList;

/**
 * Represents a bank account with a unique account number and balance.
 * Provides methods for depositing and withdrawing funds, as well as accessing balance and transaction history.
 */

public class BankAccount {

    private String accountNumber;
    private double balance;
    private ArrayList<String>transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 5000;
        this.transactionHistory = new ArrayList<>();
    }
    public void deposit(double amount) {
        this.balance += amount;

        this.transactionHistory.add("Deposited €"+ amount);
    }
    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance -= amount;
        this.transactionHistory.add("Withdrew €" + amount);
    }

    public double getBalance() {
        return balance;
    }
    public ArrayList<String> getTransactionHistory(){
        return this.transactionHistory;
    }
}
