package bank;

import java.util.ArrayList;
import java.util.List;
public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private List<Transaction> transactions;
    private double withdrwalLimit;
    private double totalWithdrawn;

//    @RequestMapping("enummapping")

    public BankAccount(double withdrwalLimit) {
        this.transactions = new ArrayList<>();
        this.withdrwalLimit = withdrwalLimit;
        this.totalWithdrawn = 0.0;
    }

    public void createAccount(int accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
        System.out.println("Account created successfully!");
    }

    public void deposit(int accountNumber, double depositAmount) {
        if (this.accountNumber == accountNumber) {
            this.balance += depositAmount;
            transactions.add(new Transaction("Deposit", depositAmount));
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid account number!");
        }
    }

    public void withdraw(int accountNumber, double withdrawAmount) {
        if (this.accountNumber == accountNumber) {
            if ((totalWithdrawn + withdrawAmount) <= withdrwalLimit && withdrawAmount <= balance){
                this.balance -= withdrawAmount;
                transactions.add(new Transaction("Withdrawal", withdrawAmount));
                totalWithdrawn += withdrawAmount;
                System.out.println("Withdrawal successful");
            }else if ((totalWithdrawn + withdrawAmount) > withdrwalLimit) {
                System.out.println("Exceeded withdrawal limit");
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Invalid account number!");
        }
    }

    public double getBalance(int accountNumber) {
        if (this.accountNumber == accountNumber) {
            return this.balance;
        } else {
            System.out.println("Invalid account number!");
            return 0.0;
        }
    }

    public List<Transaction> getTransactions(String type) {
        return transactions;
    }

}
