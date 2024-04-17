import java.util.HashMap;
import java.util.Map;
/**
 * This class acts as a repository or manager for multiple bank accounts.
 * It's responsible for creating new accounts, retrieving existing accounts, and coordinating operations between accounts.
 * It's more concerned with managing collections of accounts and less with the specific details of individual accounts.
 */

public class Bank {
    private Map<String, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, new BankAccount(accountNumber));
        } else {
            System.out.println("Account already exists with account number: " + accountNumber);
        }
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
