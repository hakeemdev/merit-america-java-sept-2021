package com.techelevator.sale;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FinishSale extends Sale {

    private Double balance;
    private int numberOfQuarters;
    private int numberOfDimes;
    private int numberOfNickels;

    public FinishSale(InputStream input, OutputStream output) {
        super(input, output);
        this.balance = 0.0;
    }

    public Double getBalance() {
        return balance;
    }

    public void calculateChange(Purchase purchase) {
        balance = purchase.getBalance();
        Double initialBalance = purchase.getBalance();
        List<String> allMessages = purchase.getAllMessages();

        try (FileWriter fw = new FileWriter("log.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            Date dt = new Date();
            SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");

            Double valueOfQuarter = 0.25;
            while (balance >= valueOfQuarter) {
                numberOfQuarters++;
                balance -= valueOfQuarter;
            }
            double valueOfDime = 0.10;
            while (balance >= valueOfDime) {
                numberOfDimes++;
                balance -= valueOfDime;
            }
            double valueOfNickel = 0.05;
            while (balance >= valueOfNickel) {
                numberOfNickels++;
                balance -= valueOfNickel;
            }

            out.printf("%-22s %-23s $%4.2f          $%4.2f\n", f.format(dt), "GIVE CHANGE: ", initialBalance, balance);
            System.out.println("Your change is " + numberOfQuarters + " quarter(s) " + numberOfDimes + " dime(s) " + numberOfNickels + " nickel(s).");
            for (String message : allMessages) {
                System.out.println(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
