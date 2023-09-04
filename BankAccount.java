import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private String username;
    private String password;
    private double balance;

    public BankAccount(String username, String password, double initialBalance) {
        this.username = username;
        this.password = password;
        this.balance = initialBalance;
    }

    public String getUsername() {
        return username;
    }

    public boolean verifyPassword(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal.");
        }
    }
}