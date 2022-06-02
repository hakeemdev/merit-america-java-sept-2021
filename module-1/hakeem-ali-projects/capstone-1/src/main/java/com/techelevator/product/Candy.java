package com.techelevator.product;

import com.techelevator.FileReader;
import java.io.File;
import java.util.List;

public class Candy extends Product {

    private String message;
    private String slot;


    public Candy(String slot) {
        super(slot);
        this.slot = slot;
    }

    @Override
    public String getMessage() {
        FileReader file = new FileReader();
        File inputFile = file.setInputFile();
        List<String> outputList = file.createVendingMachineList(inputFile);
        for (String s : outputList) {
            String[] splitLine = s.split("\\|");
            if (splitLine[0].equals(slot) && splitLine[3].equals("Candy")) {
                message = "Munch Munch, Yum!";
                break;
            }
        }
        return message;
    }

    public String getSlot() {
        return slot;
    }
}