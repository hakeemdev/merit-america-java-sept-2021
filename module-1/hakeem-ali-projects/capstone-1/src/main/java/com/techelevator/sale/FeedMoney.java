package com.techelevator.sale;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FeedMoney extends Sale {

    private Double balance;

    public FeedMoney(InputStream input, OutputStream output) {
        super(input, output);
        this.balance = 0.0;
        Scanner in = new Scanner(input);
    }

    public Double getBalance() {
        return balance;
    }

    public void feedMoney(String choice) {
        try (
                FileWriter fw = new FileWriter("log.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)
                ) {

            Date date = new Date();
            SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyy hh:mm:ss a ");

            switch (choice) {
                case "Insert $1":
                    double oneDollar = 1.0;
                    balance += oneDollar;
                    out.printf(f.format(date), "FEED MONEY: ", oneDollar, balance);
                    System.out.println("Your balance is $" + balance);
                    break;
                case "Insert $2":
                    double twoDollars = 2.0;
                    balance += twoDollars;
                    out.printf(f.format(date), "FEED MONEY: ", twoDollars, balance);
                    System.out.println("Your balance is $" + balance);
                    break;
                case "Insert $5":
                    double fiveDollars = 5.0;
                    balance += fiveDollars;
                    out.printf(f.format(date), "FEED MONEY: ", fiveDollars, balance);
                    System.out.println("Your balance is $" + balance);
                    break;
                case "Insert $10":
                    double tenDollars = 10.0;
                    balance += tenDollars;
                    out.printf(f.format(date), "FEED MONEY: ", tenDollars, balance);
                    System.out.println("Your balance is $" + balance);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBalance(Double purchase) {
        balance -= purchase;
    }
}
