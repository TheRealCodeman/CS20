package Mastery;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PizzaCost {

	public static void main(String[] args) {
		// Create Scanner object
		Scanner scanner = new Scanner(System.in);

		// Declare variable
		double pizzaDiameter;

		// User-input debugging
		while (true) {
			try {
				// User prompt
				System.out.print("Enter diameter of desired pizza in inches: ");
				pizzaDiameter = scanner.nextDouble();

				// Verify number is within allowed range
				if (pizzaDiameter >= 0) {
					break;
				} else {
					System.out.println("Number cannot be below 0. Re-enter: ");
				}
			} catch (InputMismatchException e) {
				// Log input-error
				System.out.println("Cannot use other symbols in place of a number. Press enter to restart: ");
				scanner.nextLine();
			}
		}

		// Final error-free result
		System.out.printf("The cost of the pizza is: $" + "%.2f", (0.75 + 1.00 + 0.05 * Math.pow(pizzaDiameter, 2)));

		// Close scanner
		scanner.close();
	}
}
/*
 * Screen Dump
 * 
 * Enter diameter of desired pizza in inches: 7 The cost of the pizza is: $4.20
 * 
 * 
 */