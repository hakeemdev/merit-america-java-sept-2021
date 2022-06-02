package com.techelevator.sale;

import com.techelevator.view.Menu;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sale extends Menu {

    private Double balance;

    public Sale(InputStream input, OutputStream output) {
        super(input, output);
        this.balance = 0.0;
        PrintWriter out = new PrintWriter(output);
        Scanner in = new Scanner(input);
    }

    public Double getBalance() {
        return balance;
    }

}
