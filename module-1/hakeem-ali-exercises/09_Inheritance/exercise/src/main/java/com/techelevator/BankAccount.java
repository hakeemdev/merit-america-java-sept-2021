package com.techelevator;

public class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private int balance;

// constructor

    public BankAccount(String accountHolderName, String accountNumber) {
        balance = 0;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }



// getters & setters

    // return the accountHolderName

    public String getAccountHolderName() {
        return accountHolderName;
    }

    // return the accountNumber

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

// Methods

    // Deposit method

    public int deposit(int amountToDeposit) {
        balance += amountToDeposit;
        return balance;
    }

    // Withdraw method

    public int withdraw(int amountToWithdraw) {
        balance -= amountToWithdraw;
        return balance;
    }

}
