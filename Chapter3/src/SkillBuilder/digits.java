package SkillBuilder;

import java.util.Scanner;

public class digits {
	public static void main(String[] args) {
		// Declare digit outside the loop so it is accessible in the while condition and
		// print statements
		int digit = 0;

		// Create Scanner object
		Scanner userinput = new Scanner(System.in);

		// Keep making the user re-enter until an appropriate 2-digit number is received
		// (10 to 99)
		while (digit < 10 || digit >= 100) {
			try {
				System.out.print("Input any 2 digit number (will repeat until met): ");
				digit = userinput.nextInt(); // nextInt() does not take a prompt string as an argument
			} catch (Exception e) {
				// Report user-input errors
				System.out.println("An error was found stating: " + e + "\n Re-enter:");
				userinput.next(); // Clear the invalid input from the scanner buffer
			}
		}

		// Convert integer to string to use charAt() for splitting digits
		String digitStr = Integer.toString(digit);

		// Split and add zeros to each place
		System.out.println("Tens place: " + digitStr.charAt(0) + "0 \nOnes Place: " + digitStr.charAt(1));

		userinput.close();
	}
}

/*

Input any 2 digit number (will repeat until met): 5235
Input any 2 digit number (will repeat until met): 2352
Input any 2 digit number (will repeat until met): five
An error was found stating: java.util.InputMismatchException
 Re-enter:
Input any 2 digit number (will repeat until met): 68
Tens place: 60 
Ones Place: 8
 
*/