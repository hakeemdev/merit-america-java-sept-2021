package com.techelevator.sale;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.techelevator.VendingMachine;
import com.techelevator.view.Menu;

public class Purchase extends Menu {

    private Scanner in;
    private Double balance;
    private List<String> allMessages = new ArrayList();

    public Purchase(InputStream input, OutputStream output) {
        super(input, output);
        this.in = new Scanner(input);
        this.balance = 0.0;
    }

    public void selectProduct(VendingMachine vendingMachine, FeedMoney feedMoney) {
        balance = feedMoney.getBalance();
        boolean isInvalid = true;
        while (isInvalid) {
            System.out.println("------------------------------------");
            System.out.print("Select the slot number of the Item you wish to purchase >>>");
            String userInput = in.nextLine().toUpperCase();

            try (FileWriter fw = new FileWriter("log.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {

                Date dt = new Date();
                SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a ");

                if (vendingMachine.getVendingMachine().get(userInput) == null) {
                    System.out.println("Invalid Selection");
                } else if (balance == 0) {
                    System.out.println("Insert money to continue.");
                    break;
                }
                if (vendingMachine.getVendingMachine().get(userInput).getPrice() > balance) {
                    System.out.println("Please insert more money.");
                    break;
                }
                out.printf("%-22s %-18s%-5s $%4.2f          $%4.2f\n", f.format(dt), vendingMachine.getVendingMachine().get(userInput).getName(), userInput, balance, (balance - vendingMachine.getVendingMachine().get(userInput).getPrice()));
                balance = balance - vendingMachine.getVendingMachine().get(userInput).getPrice();
                feedMoney.updateBalance(vendingMachine.getVendingMachine().get(userInput).getPrice());
                vendingMachine.getVendingMachine().get(userInput).purchaseItem();
                allMessages.add(vendingMachine.getVendingMachine().get(userInput).getMessage());
                System.out.printf("You have $%4.2f remaining", balance);
                isInvalid = false;


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Double getBalance() {
        return balance;
    }

    public List<String> getAllMessages() {
        return allMessages;
    }
}