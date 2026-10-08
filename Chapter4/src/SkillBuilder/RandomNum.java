package SkillBuilder;

import java.util.Scanner;

public class RandomNum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Prompt the user for the minimum value
		System.out.print("Enter the minimum value: ");
		int min = scanner.nextInt();

		// Prompt the user for the maximum value
		System.out.print("Enter the maximum value: ");
		int max = scanner.nextInt();

		// Ensure the range is valid before generating the number
		if (min > max) {
			System.out.println("Error: The minimum value cannot be greater than the maximum value.");
		} else {
			// Generate a random integer between min and max (inclusive)
			int randomNum = (int) (Math.random() * (max - min + 1)) + min;

			// Display the result
			System.out.println("A random number between " + min + " and " + max + " is: " + randomNum);
		}

		scanner.close();
	}
}
