/*

Program: ObjectHeight.java          Last Date of this Revision: October 1, 2026

Purpose: An application that reads how many seconds an object dropped from
 100 m has been falling and outputs its height above the ground.

IPO:
 Input:   time t in seconds (number from 0 to 4.5)
 Process: check 0 <= t <= 4.5 (the object reaches the ground at about 4.52 s),
          otherwise re-prompt, then calculate height = 100 - 4.9t^2
 Output:  "After t seconds, the object's height from the ground will then be h m."

Author: Christian
School: CHHS
Course: Computer Programming 20 - CSE2140 Second Language Programming 1

*/

package Mastery;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ObjectHeight {

	public static void main(String[] args) {
		// Create Scanner object
		Scanner scanner = new Scanner(System.in);

		// Declare variable
		double t;

		// User-input debugging
		while (true) {
			try {
				// User prompt
				System.out.print(
						"An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : ");
				t = scanner.nextDouble();

				// Verify number is within allowed range
				if (t >= 0 && t <= 4.5) {
					break;
				} else {
					System.out.println("Number must be between 0 and 4.5. Re-enter: ");
				}
			} catch (InputMismatchException e) {
				// Log input-error
				System.out.println("Cannot use other symbols in place of a number. Re-enter: ");
				scanner.nextLine();
			}
		}

		// Final error-free result
		System.out.println("After " + t + " seconds, the object's height from the ground will then be "
				+ (100 - 4.9 * Math.pow(t, 2)) + " m.");

		// Close scanner
		scanner.close();
	}
}

/* Screen Dump

Test Case 1: Successful output, normal input (2.3453)
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : 2.3453
After 2.3453 seconds, the object's height from the ground will then be 73.047882759 m.

Test Case 2: Boundary held, lowest time (0)
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : 0
After 0.0 seconds, the object's height from the ground will then be 100.0 m.

Test Case 3: Boundary held, highest time (4.5)
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : 4.5
After 4.5 seconds, the object's height from the ground will then be 0.7749999999999915 m.

Test Case 4: Boundaries broken (5, -1, 4.647), then valid input (2.3453)
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : 5
Number must be between 0 and 4.5. Re-enter: 
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : -1
Number must be between 0 and 4.5. Re-enter: 
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : 4.647
Number must be between 0 and 4.5. Re-enter: 
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : 2.3453
After 2.3453 seconds, the object's height from the ground will then be 73.047882759 m.

Test Case 5: Illogical input (abc), then valid input (3)
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : abc
Cannot use other symbols in place of a number. Re-enter: 
An object drops 100 m above the ground. Input how many seconds the object falls for between 0 and 4.5 : 3
After 3.0 seconds, the object's height from the ground will then be 55.9 m.

 */
