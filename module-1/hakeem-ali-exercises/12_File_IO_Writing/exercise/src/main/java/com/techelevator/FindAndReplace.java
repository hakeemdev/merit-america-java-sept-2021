package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {


    Scanner input = new Scanner(System.in);

    System.out.println("What is the search word?");
    String searchWord = input.nextLine();

    System.out.println("What is the replacement word?");
    String replacementWord = input.nextLine();

    System.out.println("What is the path of the source file?");
    String filePath = input.nextLine();

    System.out.println("What is the destination file path?");
    String destinationFilePath = input.nextLine();

    File originalFile = new File(filePath);
    File updatedFile = new File(destinationFilePath);

    try (
            Scanner fileInput = new Scanner(originalFile);
            PrintWriter writer = new PrintWriter(updatedFile);
            ) {
        while (fileInput.hasNextLine()) {
            String lineOfText = fileInput.nextLine();
            writer.println(lineOfText.replace(searchWord, replacementWord));
            System.out.println(lineOfText);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }
}
