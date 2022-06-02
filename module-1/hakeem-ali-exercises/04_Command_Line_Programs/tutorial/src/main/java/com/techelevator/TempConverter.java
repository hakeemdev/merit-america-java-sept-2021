package com.techelevator;

import java.util.Scanner;

public class TempConverter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the temperature: ");
        int temp = input.nextInt();
        input.nextLine();

        System.out.println("Is the temperature (C)elsius or (F)arenheit? ");

        String scale = input.nextLine();

        if (scale.equalsIgnoreCase("C")) {
            int tempInF = (int) ((temp * 1.8) + 32);
            System.out.println(temp + "C is " + tempInF + "F.");

        } else if (scale.equalsIgnoreCase("F")) {
            int tempInF = (int) ((temp - 32) / 1.8);
            System.out.println(temp + "F is " + tempInF + "C.");
        }
    }

}
