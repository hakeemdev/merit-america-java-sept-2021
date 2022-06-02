package com.techelevator.product;

import com.techelevator.FileReader;
import java.io.File;
import java.util.List;

public class Product {

    private String name;
    private Double price;
    private String slot;
    private String message;
    private String itemCount;
    private List <String> outputList;

    public Product(String slot) {
        this.itemCount = "5";
        this.slot = slot;
    }

    public String getName() {
        FileReader file = new FileReader();
        File inputFile = file.setInputFile();
        outputList = file.createVendingMachineList(inputFile);
        for (String s : outputList) {
            String[] splitLine = s.split("\\|");
            if (splitLine[0].equals(slot)) {
                name = splitLine[1];
            }
        }
        return name;
    }

    public Double getPrice() {
        FileReader file = new FileReader();
        File inputFile = file.setInputFile();
        outputList = file.createVendingMachineList(inputFile);
        for (String s : outputList) {
            String[] splitLine = s.split("\\|");
            if (splitLine[0].equals(slot)) {
                price = Double.valueOf(splitLine[2]);
            }
        }
        return price;
    }

    public String getMessage() {
        return message;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void purchaseItem() {
        Integer currentCount = Integer.parseInt(itemCount) - 1;
        if (currentCount > 0) {
            itemCount = String.valueOf(currentCount);
        } else {
            itemCount = "SOLD OUT";
        }
    }
}
