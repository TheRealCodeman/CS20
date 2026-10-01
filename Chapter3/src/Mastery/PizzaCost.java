/*

Program: PizzaCost.java          Last Date of this Revision: October 1, 2026

Purpose: An application that reads the diameter of a pizza in inches and
 outputs its cost.

IPO:
 Input:   pizza diameter in inches (number, 0 or more)
 Process: check diameter >= 0, otherwise re-prompt, then calculate
          cost = $0.75 labour + $1.00 rent + $0.05 x diameter^2 (materials)
 Output:  "The cost of the pizza is: $X.XX" (two decimal places)

Author: Christian
School: CHHS
Course: Computer Programming 20 - CSE2140 Second Language Programming 1

*/

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

/* Screen Dump

Test Case 1: Successful output, normal input (7)
Enter diameter of desired pizza in inches: 7
The cost of the pizza is: $4.20

Test Case 2: Successful output, decimal input (12.5)
Enter diameter of desired pizza in inches: 12.5
The cost of the pizza is: $9.56

Test Case 3: Boundary held, lowest diameter (0)
Enter diameter of desired pizza in inches: 0
The cost of the pizza is: $1.75

Test Case 4: Boundary broken, negative input (-3), then valid input (7)
Enter diameter of desired pizza in inches: -3
Number cannot be below 0. Re-enter: 
Enter diameter of desired pizza in inches: 7
The cost of the pizza is: $4.20

Test Case 5: Illogical input (abc), then valid input (7)
Enter diameter of desired pizza in inches: abc
Cannot use other symbols in place of a number. Press enter to restart: 
Enter diameter of desired pizza in inches: 7
The cost of the pizza is: $4.20

 */
