package bank;

import java.util.ArrayList;
import java.util.*;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;

@Entity
public class User {
    private @Id @GeneratedValue Long id;
    private int accountNumber;
    private String firstName;
    private String lastName;
    private double balance;
    private List<Transaction> transactions;
    private double withdrwalLimit;
    private double totalWithdrawn;

    public User() {}

    public User(String firtName, String lastName, int accountNumber) {
//        this.transactions = new ArrayList<>();
//        this.withdrwalLimit = withdrwalLimit;
//        this.totalWithdrawn = 0.0;
        this.firstName = firtName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public Long getId() {
        return this.id;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirtName(String firtName) {
        this.firstName = firtName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals (Object o) {

        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return Objects.equals(this.id, user.id) && Objects.equals(this.firstName, user.firstName)
                && Objects.equals(this.accountNumber, user.accountNumber);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.accountNumber);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", " +
                "firstName='" + this.firstName + '\'' + ", " +
                "lastName='" + this.lastName + '\'' + ", " +
                "account number='" + this.accountNumber + '\'' + '}';
    }
}

//    public void createAccount(int accountNumber, String firstName, String lastName) {
//        this.accountNumber = accountNumber;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.balance = 0.0;
//        System.out.println("Account created successfully!");
//    }
//
//    public void deposit(int accountNumber, double depositAmount) {
//        if (this.accountNumber == accountNumber) {
//            this.balance += depositAmount;
//            transactions.add(new Transaction("Deposit", depositAmount));
//            System.out.println("Deposit successful!");
//        } else {
//            System.out.println("Invalid account number!");
//        }
//    }
//
//    public void withdraw(int accountNumber, double withdrawAmount) {
//        if (this.accountNumber == accountNumber) {
//            if ((totalWithdrawn + withdrawAmount) <= withdrwalLimit && withdrawAmount <= balance){
//                this.balance -= withdrawAmount;
//                transactions.add(new Transaction("Withdrawal", withdrawAmount));
//                totalWithdrawn += withdrawAmount;
//                System.out.println("Withdrawal successful");
//            }else if ((totalWithdrawn + withdrawAmount) > withdrwalLimit) {
//                System.out.println("Exceeded withdrawal limit");
//            } else {
//                System.out.println("Insufficient balance");
//            }
//        } else {
//            System.out.println("Invalid account number!");
//        }
//    }
//
//    public double getBalance(int accountNumber) {
//        if (this.accountNumber == accountNumber) {
//            return this.balance;
//        } else {
//            System.out.println("Invalid account number!");
//            return 0.0;
//        }
//    }
//
//
//}


