package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PurchaseMenu extends Menu {

    public PurchaseMenu(InputStream input, OutputStream output) {
        super(input, output);
        PrintWriter out = new PrintWriter(output);
        Scanner in = new Scanner(input);
    }
}
