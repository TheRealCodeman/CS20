/*

Program: PackageCheck.java          Last Date of this Revision: October 5, 2026

Purpose: An application that reads a delivery package's weight (kg) and
 dimensions (cm), calculates its volume, and checks it against the weight
 and volume limits. It explains every limit violation, or confirms that
 the package was accepted.

IPO:
 Input:   weight in kg; width, length and height in cm (all above 0)
 Process: multiply the 3 dimensions for the volume, convert cm^3 to m^3, then
          check the weight against 27 kg and the volume against 0.1 m^3
 Output:  if at least one limit is exceeded: "unacceptable" plus each
          violation explained; otherwise an acceptance confirmation

Author: Christian
School: CHHS
Course: Computer Programming 20 - CSE2140 Second Language Programming 1

*/
//

package Mastery.lib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class package_check {

	// Limit attributes (constants, so each limit is changed in one place)
	private static final double MAX_WEIGHT_KG = 27.0;
	private static final double MAX_VOLUME_M3 = 0.1;
	private static final double CM3_PER_M3 = 1_000_000.0;

	public static void main(String[] args) {
		// Create Scanner object
		Scanner scanner = new Scanner(System.in);

		// Inputs (stored, because each value is reused in the checks and output)
		double weight = getPositiveNumber(scanner, "Enter the package weight in kg: ");
		double width = getPositiveNumber(scanner, "Enter the package width in cm: ");
		double length = getPositiveNumber(scanner, "Enter the package length in cm: ");
		double height = getPositiveNumber(scanner, "Enter the package height in cm: ");

		// Multiply the 3 dimensions and convert cm^3 to m^3
		double volume = width * length * height / CM3_PER_M3;

		// Check each limit separately so every violation can be explained
		boolean tooHeavy = weight > MAX_WEIGHT_KG;
		boolean tooLarge = volume > MAX_VOLUME_M3;

		// Final error-free result
		if (tooHeavy || tooLarge) {
			System.out.println("The package is unacceptable.");
			if (tooHeavy) {
				System.out.printf("- Weight limit exceeded: %.2f kg is over the %.0f kg limit by %.2f kg.%n", weight,
						MAX_WEIGHT_KG, weight - MAX_WEIGHT_KG);
			}
			if (tooLarge) {
				System.out.printf("- Volume limit exceeded: %.4f cubic m is over the %.1f cubic m limit by %.4f cubic m.%n",
						volume, MAX_VOLUME_M3, volume - MAX_VOLUME_M3);
			}
		} else {
			System.out.printf("The package was accepted (%.2f kg, %.4f cubic m).%n", weight, volume);
		}

		// Close scanner
		scanner.close();
	}

	/*
	 * Function: getPositiveNumber
	 * Pre-condition:  scanner is open; prompt describes the value and its unit
	 * Post-condition: returns a number greater than 0 (re-prompts until valid)
	 */
	private static double getPositiveNumber(Scanner scanner, String prompt) {
		while (true) {
			try {
				// User prompt
				System.out.print(prompt);
				double value = scanner.nextDouble();

				// Verify number is within allowed range
				if (value > 0) {
					return value;
				}
				System.out.println("Number must be greater than 0. Re-enter: ");
			} catch (InputMismatchException e) {
				// Log input-error and clear the bad input from the Scanner buffer
				System.out.println("Cannot use other symbols in place of a number. Re-enter: ");
				scanner.nextLine();
			}
		}
	}
}

/* Screen Dump

Test Case 1: Successful output, within both limits
Enter the package weight in kg: 10
Enter the package width in cm: 30
Enter the package length in cm: 30
Enter the package height in cm: 30
The package was accepted (10.00 kg, 0.0270 cubic m).

Test Case 2: Boundaries held, exactly at both limits
Enter the package weight in kg: 27
Enter the package width in cm: 100
Enter the package length in cm: 100
Enter the package height in cm: 10
The package was accepted (27.00 kg, 0.1000 cubic m).

Test Case 3: Weight boundary broken
Enter the package weight in kg: 30
Enter the package width in cm: 40
Enter the package length in cm: 40
Enter the package height in cm: 40
The package is unacceptable.
- Weight limit exceeded: 30.00 kg is over the 27 kg limit by 3.00 kg.

Test Case 4: Volume boundary broken
Enter the package weight in kg: 5
Enter the package width in cm: 50
Enter the package length in cm: 50
Enter the package height in cm: 50
The package is unacceptable.
- Volume limit exceeded: 0.1250 cubic m is over the 0.1 cubic m limit by 0.0250 cubic m.

Test Case 5: Both boundaries broken
Enter the package weight in kg: 28.5
Enter the package width in cm: 60
Enter the package length in cm: 50
Enter the package height in cm: 40
The package is unacceptable.
- Weight limit exceeded: 28.50 kg is over the 27 kg limit by 1.50 kg.
- Volume limit exceeded: 0.1200 cubic m is over the 0.1 cubic m limit by 0.0200 cubic m.

Test Case 6: Illogical inputs (-2, abc, 0), then valid inputs
Enter the package weight in kg: -2
Number must be greater than 0. Re-enter: 
Enter the package weight in kg: abc
Cannot use other symbols in place of a number. Re-enter: 
Enter the package weight in kg: 0
Number must be greater than 0. Re-enter: 
Enter the package weight in kg: 12
Enter the package width in cm: 20
Enter the package length in cm: 20
Enter the package height in cm: 20
The package was accepted (12.00 kg, 0.0080 cubic m).

 */
