package com.techelevator.product;

import com.techelevator.FileReader;
import java.io.File;
import java.util.List;

public class Gum extends Product {

    private String message;
    private String slot;

    public Gum(String slot) {
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
            if (splitLine[0].equals(slot) && splitLine[3].equals("Gum")) {
                message = "Chew Chew, Yum!";
                break;
            }
        }
        return message;
    }

    public String getSlot() {
        return slot;
    }
}