package com.techelevator;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.StringTokenizer;

/*
 In case you've ever pondered how much you weight on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

 $ MartianWeight 
 
Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth, is 37 lbs. on Mars.
 235 lbs. on Earth, is 88 lbs. on Mars.
 185 lbs. on Earth, is 69 lbs. on Mars. 
 */
public class MartianWeight {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		int[] earthWeights = new int[3];
		int[] martianWeights = new int[3];

		System.out.println("Enter a series of Earth weights (space-separated): ");

		for (int i = 0; i < 3; i++) {
			earthWeights[i] = userInput.nextInt();
		}

		for (int j = 0; j < 3; j++) {
			martianWeights[j] = (int) (earthWeights[j] * 0.378);
			System.out.println(earthWeights[j] + " lbs. on Earth, is " + martianWeights[j] + " lbs. on Mars.");
		}

		/*Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		StringTokenizer separatedInput = new StringTokenizer(input, "1"); //Separates input by the delimiter.

		int[] We = new int [3];
		int[] Wm = new int [3];

		for (int i = 0; i < 3; i++) {
			We [i] = Integer.parseInt((String) separatedInput.nextElement());
			Wm [i] = (int) (We [i] * 0.378);
			System.out.println(We [i] + " lbs. on Earth, is " + Wm [i] + " lbs. on Mars.");
		}*/
	}

}
