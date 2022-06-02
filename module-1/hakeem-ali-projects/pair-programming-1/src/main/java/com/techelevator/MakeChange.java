package com.techelevator;
import java.util.Scanner;
import java.math.*;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // Scanner object for user input
		double bill = 0;
		double tendered = 0;
		double change = 0;

		String input = ""; // Initialize input variable

		// User input bill total
		System.out.println("Please enter the amount of the bill.");
		input = userInput.nextLine();
		bill = Double.parseDouble(input);

		// User input amount tendered
		System.out.println("Please enter the amount tendered.");
		input = userInput.nextLine();
		tendered = Double.parseDouble(input);

		// Change output
		change = (tendered - bill);
		System.out.printf("The change required is $%.2f", change);
	}

}
