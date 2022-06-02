package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private List<String> productList = new ArrayList<String>();

    public File setInputFile() {
        return new File("vendingmachine.csv");
    }

    public List<String> createVendingMachineList(File inputFile) {

        try(Scanner scan = new Scanner(inputFile)) {
            while(scan.hasNextLine()) {
                productList.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return productList;
    }
}
