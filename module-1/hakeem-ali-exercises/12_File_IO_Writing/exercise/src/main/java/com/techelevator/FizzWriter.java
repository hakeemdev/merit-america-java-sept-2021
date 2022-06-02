package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		File fizzBuzz = new File(input.nextLine());
		String output = "";

		try (PrintWriter writer = new PrintWriter(fizzBuzz)) {
			for (int i = 1; i <= 300; i++) {
				if (i % 5 == 0 && i % 3 == 0) {
					output = "FizzBuzz";
				} else if (i % 3 == 0 || Integer.toString(i).contains("3")) {
					output = "Fizz";
				} else if (i % 5 == 0 || Integer.toString(i).contains("5")) {
					output = "Buzz";
				} else {
					output = Integer.toString(i);
				}
				writer.println(output);

			}

		} catch (FileNotFoundException e) {
			System.out.println("");;
		}

	}
}
