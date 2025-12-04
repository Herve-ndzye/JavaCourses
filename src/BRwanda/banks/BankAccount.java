package BRwanda.banks;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount implements Serializable, Comparable<BankAccount> {
    private static final long serialVersionUID = 1L;

    private static int starter = 0;

    private final int accountNo;
    private final String accountHolder;
    private final AccountType accountType;

    private double balance = 0;
    private final List<String> transactionHistory =
            Collections.synchronizedList(new ArrayList<>());

    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public BankAccount(String holder, AccountType type) {
        this.accountHolder = holder;
        this.accountType = type;
        starter += 1;
        this.accountNo = starter;
        addTransaction("Account created (" + type + ")");
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            return;
        }
        this.balance += amount;
        addTransaction("Deposited " + amount + ", new balance = " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (amount <= 0) {
            return;
        }
        this.balance -= amount;
        addTransaction("Withdrew " + amount + ", new balance = " + balance);
    }

    public synchronized void applyInterest(double rate) {
        if (rate <= 0) {
            return;
        }
        double interest = balance * rate;
        balance += interest;
        addTransaction("Interest applied (" + (rate * 100) + "%): +" + interest + ", new balance = " + balance);
    }

    public synchronized double getBalance() {
        return this.balance;
    }

    @Override
    public int compareTo(BankAccount other) {
        return Integer.compare(this.accountNo, other.accountNo);
    }

    public void printStatement() {
        System.out.println("\n=== Transaction history for account " + accountNo + " ===");
        transactionHistory.forEach(System.out::println);
        System.out.println("=== End of statement ===\n");
    }

    private void addTransaction(String description) {
        String entry = LocalDateTime.now() + " - " + description;
        transactionHistory.add(entry);
    }
}

enum AccountType {
    SAVINGS,
    CURRENT
}

class choiceException extends Exception {
    public choiceException(String message) {
        super(message);
    }
}
