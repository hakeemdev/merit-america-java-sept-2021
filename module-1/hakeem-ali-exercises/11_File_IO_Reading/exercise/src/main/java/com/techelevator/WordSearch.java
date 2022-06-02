package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {

		try (Scanner userFilePathInput = new Scanner(System.in)) {

			System.out.println("Please enter the complete file path: ");

			File fileToBeSearched = new File(userFilePathInput.nextLine());;

			System.out.println("Please enter the word you would like to search: ");;
			String searchWord = "" + userFilePathInput.nextLine() + "";

			try (Scanner fileInput = new Scanner(fileToBeSearched)) {

				System.out.println("Should the search be case sensitive? (Y/N)");
				String yesOrNo = userFilePathInput.nextLine().toLowerCase();

				int lineCount = 0;

				if (yesOrNo.equals("n")) {
					while (fileInput.hasNextLine()) {
						lineCount++;
						String lineOfText = fileInput.nextLine();
						if (lineOfText.contains(searchWord.toLowerCase()) || lineOfText.contains(searchWord.toUpperCase())
								|| lineOfText.contains(searchWord.substring(0, 1).toUpperCase() + searchWord.substring(1).toLowerCase())) {
							System.out.println(lineCount + ")" + " " + lineOfText);
						}
					}
				} else if (yesOrNo.contentEquals("y")) {
					while (fileInput.hasNextLine()) {
						lineCount++;
						String lineOfText = fileInput.nextLine();
						if (lineOfText.contains(searchWord)) {
							System.out.println(lineCount + ")" + " " + lineOfText);
						}
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
		} catch (Exception e) {
				System.out.println("Word not found");
			}
		}
	}
}
