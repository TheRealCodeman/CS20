package SkillBuilder;

import java.util.Scanner;

public class rectangle_java {

	public static void main(String[] args) {
		// Declaration
		int length = 0; // Initialized to avoid null-related issues
		int width = 0; // Initialized to avoid null-related issues

		// Create Scanner object
		Scanner userinput = new Scanner(System.in);

		// Keep making the user re-enter until an appropriate width and length is
		// received (10 to 99)
		while (true) {
			try {
				// Get the width from the keyboard
				System.out.print("Enter width (10-99): ");
				width = userinput.nextInt();

				// Get length from the keyboard
				System.out.print("Enter length (10-99): ");
				length = userinput.nextInt();

				// Validate input range
				if (width >= 10 && width <= 99 && length >= 10 && length <= 99) {
					break;
				} else {
					System.out.println("Both width and length must be between 10 and 99. Please re-enter.");
				}
			} catch (Exception e) {
				// Report user-input errors
				System.out.println("Invalid input. Please enter numeric values only.");
				userinput.next(); // Clear the invalid input from the scanner buffer
			}
		}

		// Display the length and width
		System.out.println("The length is: " + length);
		System.out.println("The width is: " + width);

		// Corrected perimeter calculation
		System.out.println("Perimeter is: " + (2 * width + 2 * length));

		// Good practice: Close the scanner
		userinput.close();
	}
}

/*
 * 
 * Enter width (10-99): 52 Enter length (10-99): 532 Both width and length must
 * be between 10 and 99. Please re-enter. Enter width (10-99): 35 Enter length
 * (10-99): te Invalid input. Please enter numeric values only. Enter width
 * (10-99): 53 Enter length (10-99): 35 The length is: 35 The width is: 53
 * Perimeter is: 176
 * 
 */