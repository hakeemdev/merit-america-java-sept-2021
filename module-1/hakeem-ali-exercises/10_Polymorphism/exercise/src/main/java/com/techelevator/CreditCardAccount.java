package com.techelevator;

public class CreditCardAccount implements Accountable {

    private String accountHolderName;
    private String accountNumber;
    private int debt;
    private int balance;

    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.debt = 0;
    }

    public String getAccountHolder() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }

    public int pay(int amountToPay) {
        debt = debt - amountToPay;
        return debt;
    }

    public int charge(int amountToCharge) {
        debt = debt + amountToCharge;
        return debt;
    }

    @Override
    public int getBalance() {
        return balance = balance - debt;
    }

}
