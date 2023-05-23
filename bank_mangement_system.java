import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of " + amount + " successful.");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create some sample accounts
        Account account1 = new Account("001", "John Doe", 1000.0);
        Account account2 = new Account("002", "Jane Smith", 2000.0);
        Account account3 = new Account("003", "Bob Johnson", 500.0);

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Bank Management System ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.next();
                Account account = bank.findAccount(accountNumber);
                if (account != null) {
                    System.out.print("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 2) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.next();
                Account account = bank.findAccount(accountNumber);
                if (account != null) {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.next();
                Account account = bank.findAccount(accountNumber);
                if (account != null) {
                    account.displayAccountDetails();
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
