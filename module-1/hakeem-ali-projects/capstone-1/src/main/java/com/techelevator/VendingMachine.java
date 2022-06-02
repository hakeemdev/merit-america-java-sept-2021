package com.techelevator;

import com.techelevator.product.*;
import java.io.File;
import java.util.*;


public class VendingMachine {

    private Map<String, Product> vendingMachine;

    public void createVendingMachine() {
        FileReader file = new FileReader();
        File inputFile = file.setInputFile();
        List<String> outputList = file.createVendingMachineList(inputFile);
        vendingMachine = new HashMap<>();
        for (String s : outputList) {
            String[] splitLine = s.split("\\|");
            switch (splitLine[3]) {
                case "Chip":
                    vendingMachine.put(splitLine[0], new Chip(splitLine[0]));
                    break;
                case "Candy":
                    vendingMachine.put(splitLine[0], new Candy(splitLine[0]));
                    break;
                case "Drink":
                    vendingMachine.put(splitLine[0], new Drink(splitLine[0]));
                    break;
                case "Gum":
                    vendingMachine.put(splitLine[0], new Gum(splitLine[0]));
                    break;
            }
        }
    }

    public Map<String, Product> getVendingMachine() {
        return vendingMachine;
    }

    public void displayProducts() {

        Set<String> orderedSet = new TreeSet<>();

        for (Map.Entry<String, Product> entry : vendingMachine.entrySet()) {
            orderedSet.add(entry.getKey() + " " + entry.getValue().getName() + " $" + String.valueOf(entry.getValue().getPrice()) + " " + entry.getValue().getItemCount());
        }

        for (String product : orderedSet) {
            System.out.println(product);
        }
    }

}