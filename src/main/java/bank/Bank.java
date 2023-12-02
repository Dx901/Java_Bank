package bank;

import bank.Transaction;

import java.util.List;

public class Bank {
    private String accountHolderName;
    private List<Transaction> transactions;

    public Bank (String accountHolderName, List transactions) {
        this.accountHolderName = accountHolderName;
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}